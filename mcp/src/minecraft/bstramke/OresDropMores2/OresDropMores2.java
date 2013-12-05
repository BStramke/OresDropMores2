package bstramke.OresDropMores2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import bstramke.OresDropMores2.Blocks.OresDropMoresBlocks;
import bstramke.OresDropMores2.Common.CommonProxy;
import bstramke.OresDropMores2.Items.OreFragment;
import bstramke.OresDropMores2.Items.OreItem;
import bstramke.OresDropMores2.Items.OresDropMoresItems;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(name = "OresDropMores2", version = "0.11.1", modid = "OresDropMores2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class OresDropMores2 extends DummyModContainer {
	@Instance
	public static OresDropMores2 instance = new OresDropMores2();

	@SidedProxy(clientSide = "bstramke.OresDropMores2.Client.ClientProxy", serverSide = "bstramke.OresDropMores2.Common.CommonProxy")
	public static CommonProxy proxy;

	public static int OreItemId; // general ItemID for Drops
	public static int OreFragmentItemId; // general ItemID for Drops

	public static boolean ReduceToolRequirements;

	public static HashMap<String, OreConfig> OreConfiguration;

	@EventHandler
	public void PreLoad(FMLPreInitializationEvent event) {
		//FMLLog.info("[OresDropMores2] PreLoad");
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		config.addCustomCategoryComment("Remarks", "SmeltXP is a value between 0.0 and max 1.0");

		OreConfiguration = new HashMap<String, OreConfig>();
		OreConfiguration.put("IronOre", new OreConfig(config, "IronOre", new OreConfigDefaults(1, 1, 3, 5, 0.7F, Block.oreIron, OreFragment.Iron, 1, Item.ingotIron.itemID, 0),
				"iron_ore"));
		OreConfiguration.put("GoldOre", new OreConfig(config, "GoldOre", new OreConfigDefaults(1, 1, 3, 5, 1.0F, Block.oreGold, OreFragment.Gold, 1, Item.ingotGold.itemID, 0),
				"gold_ore"));
		OreConfiguration.put("CoalOre", new OreConfig(config, "CoalOre", new OreConfigDefaults(0, 2, 3, 5, 0.1F, Block.oreCoal, OreFragment.Coal, 1, Item.coal.itemID, 0), "coal_ore"));
		OreConfiguration.put("DiamondOre", new OreConfig(config, "DiamondOre",
				new OreConfigDefaults(3, 7, 3, 5, 1.0F, Block.oreDiamond, OreFragment.Diamond, 1, Item.diamond.itemID, 0), "diamond_ore"));
		OreConfiguration.put("EmeraldOre", new OreConfig(config, "EmeraldOre",
				new OreConfigDefaults(3, 7, 3, 5, 1.0F, Block.oreEmerald, OreFragment.Emerald, 1, Item.emerald.itemID, 0), "emerald_ore"));
		OreConfiguration.put("LapisOre", new OreConfig(config, "LapisOre", new OreConfigDefaults(2, 5, 4, 9, 0.2F, Block.oreLapis, OreFragment.Lapis, 1, Item.dyePowder.itemID, 4),
				"lapis_ore"));
		OreConfiguration.put("RedstoneOre", new OreConfig(config, "RedstoneOre", new OreConfigDefaults(1, 5, 4, 5, 0.7F, Block.oreRedstone, OreFragment.Redstone, 1,
				Item.redstone.itemID, 0), "redstone_ore"));
		OreConfiguration.put("NetherQuartzOre", new OreConfig(config, "NetherQuartzOre", new OreConfigDefaults(2, 5, 4, 9, 0.2F, Block.oreNetherQuartz, OreFragment.NetherQuartz, 1,
				Item.netherQuartz.itemID, 0), "quartz_ore"));
		OreConfiguration.put("GlowstoneOre", new OreConfig(config, "GlowstoneOre", new OreConfigDefaults(0, 0, 2, 4, 0F, Block.glowStone, OreFragment.Glowstone, 1, -1, -1),
				"glowstone"));

		OreItemId = config.getItem(Configuration.CATEGORY_ITEM, "OreItemId", 5400).getInt(5400);
		OreFragmentItemId = config.getItem(Configuration.CATEGORY_ITEM, "OreFragmentItemId", 5401).getInt(5401);
		ReduceToolRequirements = config.get(Configuration.CATEGORY_GENERAL, "Reduce Tool Requirement for Gathering", true).getBoolean(true);

		config.save();
		proxy.registerRenderThings();

		OresDropMoresBlocks.Init();
		OresDropMoresItems.Init();
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		initRecipes();
	}

	private void initRecipes() {
		for (Entry<String, OreConfig> entry : OreConfiguration.entrySet()) {
			if (entry.getValue().DoOreOverwrite == false)
				continue;

			OreConfig oc = entry.getValue();

			if (oc.SmeltResultItemId <= 0 || oc.SmeltResultItemMeta <= -1)
				continue;
			
			if (oc.DoOreDropFragments)
				GameRegistry.addRecipe(new ItemStack(oc.BlockId, 1, 0), new Object[] { "###", "###", "###", '#', new ItemStack(OresDropMoresItems.OreFragment, 1, oc.FragmentMeta) });
			else if (oc.BlockId == 14) // raw Gold
				FurnaceRecipes.smelting().addSmelting(OresDropMoresItems.OreItem.itemID, OreItem.gold, new ItemStack(Item.ingotGold, oc.SmeltResultCount), oc.OreSmeltXP);
			else if (oc.BlockId == 15) // raw Iron
				FurnaceRecipes.smelting().addSmelting(OresDropMoresItems.OreItem.itemID, OreItem.iron, new ItemStack(Item.ingotIron, oc.SmeltResultCount), oc.OreSmeltXP);

			FurnaceRecipes.smelting().getSmeltingList().remove(oc.BlockId);
			FurnaceRecipes.smelting().addSmelting(oc.BlockId, 0, new ItemStack(oc.SmeltResultItemId, oc.SmeltResultCount, oc.SmeltResultItemMeta), oc.OreSmeltXP);
		}
	}
}
