package bstramke.OresDropMores2;

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

@Mod(name = "OresDropMores2", version = "0.10", modid = "OresDropMores2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class OresDropMores2 extends DummyModContainer {
	@Instance
	public static OresDropMores2 instance = new OresDropMores2();

	@SidedProxy(clientSide = "bstramke.OresDropMores2.Client.ClientProxy", serverSide = "bstramke.OresDropMores2.Common.CommonProxy")
	public static CommonProxy proxy;

	public static int OreItemId;
	public static int OreFragmentItemId;
	public static int IronOreHarvestXPMin;
	public static int IronOreHarvestXPMax;
	public static int IronOreDropMin;
	public static int IronOreDropMax;
	protected static float IronOreSmeltXP;
	public static boolean IronOreDropFragments;
	
	public static int GoldOreHarvestXPMin;
	public static int GoldOreHarvestXPMax;
	protected static float GoldOreSmeltXP;
	public static int GoldOreDropMin;
	public static int GoldOreDropMax;
	public static boolean GoldOreDropFragments;

	public static int CoalOreHarvestXPMin;
	public static int CoalOreHarvestXPMax;
	public static int CoalOreDropMin;
	public static int CoalOreDropMax;
	public static boolean CoalOreDropFragments;

	public static int DiamondOreHarvestXPMin;
	public static int DiamondOreHarvestXPMax;
	public static int DiamondOreDropMin;
	public static int DiamondOreDropMax;
	public static boolean DiamondOreDropFragments;

	public static int EmeraldOreHarvestXPMin;
	public static int EmeraldOreHarvestXPMax;
	public static int EmeraldOreDropMin;
	public static int EmeraldOreDropMax;
	public static boolean EmeraldOreDropFragments;

	public static int LapisOreHarvestXPMin;
	public static int LapisOreHarvestXPMax;
	public static int LapisOreDropMin;
	public static int LapisOreDropMax;
	public static boolean LapisOreDropFragments;
	
	public static int RedstoneOreHarvestXPMin;
	public static int RedstoneOreHarvestXPMax;
	public static int RedstoneOreDropMin;
	public static int RedstoneOreDropMax;
	public static boolean RedstoneOreDropFragments;
	
	public static int NetherQuartzOreHarvestXPMin;
	public static int NetherQuartzOreHarvestXPMax;
	public static int NetherQuartzOreDropMin;
	public static int NetherQuartzOreDropMax;
	public static boolean NetherQuartzOreDropFragments;
	
	public static int GlowstoneOreHarvestXPMin;
	public static int GlowstoneOreHarvestXPMax;
	public static int GlowstoneOreDropMin;
	public static int GlowstoneOreDropMax;
	public static boolean GlowstoneOreDropFragments;

	public static boolean ReduceToolRequirements;

	@EventHandler
	public void PreLoad(FMLPreInitializationEvent event) {
		FMLLog.info("[OresDropMores2] PreLoad");
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		OreItemId = config.getItem(Configuration.CATEGORY_ITEM, "OreItemId", 5400).getInt(5400);
		OreFragmentItemId = config.getItem(Configuration.CATEGORY_ITEM, "OreFragmentItemId", 5401).getInt(5401);

		IronOreHarvestXPMin = config.get(Configuration.CATEGORY_GENERAL, "IronOre Harvest XP", 1).getInt(1);
		IronOreHarvestXPMax = config.get(Configuration.CATEGORY_GENERAL, "IronOre Harvest XP", 1).getInt(1);
		IronOreDropMin = config.get(Configuration.CATEGORY_GENERAL, "IronOre Harvest DropCount Minimum", 3).getInt(3);
		IronOreDropMax = config.get(Configuration.CATEGORY_GENERAL, "IronOre Harvest DropCount Maximum", 5).getInt(5);
		IronOreSmeltXP = (float) config.get(Configuration.CATEGORY_GENERAL, "IronOre Smelt XP", 0.1F).getDouble(0.1F);
		IronOreDropFragments = config.get(Configuration.CATEGORY_GENERAL, "IronOre Drop as small Fragments", false).getBoolean(false);

		GoldOreHarvestXPMin = config.get(Configuration.CATEGORY_GENERAL, "GoldOre Harvest XP Minimum", 1).getInt(1);
		GoldOreHarvestXPMax = config.get(Configuration.CATEGORY_GENERAL, "GoldOre Harvest XP Maximum", 1).getInt(1);
		GoldOreDropMin = config.get(Configuration.CATEGORY_GENERAL, "GoldOre Harvest DropCount Minimum", 3).getInt(3);
		GoldOreDropMax = config.get(Configuration.CATEGORY_GENERAL, "GoldOre Harvest DropCount Maximum", 5).getInt(5);
		GoldOreSmeltXP = (float) config.get(Configuration.CATEGORY_GENERAL, "GoldOre Smelt XP", 0.2F).getDouble(0.2F);
		GoldOreDropFragments = config.get(Configuration.CATEGORY_GENERAL, "GoldOre Drop as small Fragments", false).getBoolean(false);

		CoalOreHarvestXPMin = config.get(Configuration.CATEGORY_GENERAL, "Coal Harvest XP Minimum", 0).getInt(0);
		CoalOreHarvestXPMax = config.get(Configuration.CATEGORY_GENERAL, "Coal Harvest XP Maximum", 2).getInt(2);
		CoalOreDropMin = config.get(Configuration.CATEGORY_GENERAL, "Coal Harvest DropCount Minimum", 3).getInt(3);
		CoalOreDropMax = config.get(Configuration.CATEGORY_GENERAL, "Coal Harvest DropCount Maximum", 5).getInt(5);
		CoalOreDropFragments = config.get(Configuration.CATEGORY_GENERAL, "CoalOre Drop as small Fragments", false).getBoolean(false);

		DiamondOreHarvestXPMin = config.get(Configuration.CATEGORY_GENERAL, "Diamond Harvest XP Minimum", 3).getInt(3);
		DiamondOreHarvestXPMax = config.get(Configuration.CATEGORY_GENERAL, "Diamond Harvest XP Maximum", 7).getInt(7);
		DiamondOreDropMin = config.get(Configuration.CATEGORY_GENERAL, "Diamond Harvest DropCount Minimum", 3).getInt(3);
		DiamondOreDropMax = config.get(Configuration.CATEGORY_GENERAL, "Diamond Harvest DropCount Maximum", 5).getInt(5);
		DiamondOreDropFragments = config.get(Configuration.CATEGORY_GENERAL, "DiamondOre Drop as small Fragments", false).getBoolean(false);

		EmeraldOreHarvestXPMin = config.get(Configuration.CATEGORY_GENERAL, "Emerald Harvest XP Minimum", 3).getInt(3);
		EmeraldOreHarvestXPMax = config.get(Configuration.CATEGORY_GENERAL, "Emerald Harvest XP Maximum", 7).getInt(7);
		EmeraldOreDropMin = config.get(Configuration.CATEGORY_GENERAL, "Emerald Harvest DropCount Minimum", 3).getInt(3);
		EmeraldOreDropMax = config.get(Configuration.CATEGORY_GENERAL, "Emerald Harvest DropCount Maximum", 5).getInt(5);
		EmeraldOreDropFragments = config.get(Configuration.CATEGORY_GENERAL, "EmeraldOre Drop as small Fragments", false).getBoolean(false);

		LapisOreHarvestXPMin = config.get(Configuration.CATEGORY_GENERAL, "Lapis Harvest XP Minimum", 2).getInt(2);
		LapisOreHarvestXPMax = config.get(Configuration.CATEGORY_GENERAL, "Lapis Harvest XP Maximum", 5).getInt(5);
		LapisOreDropMin = config.get(Configuration.CATEGORY_GENERAL, "Lapis Harvest DropCount Minimum", 4).getInt(4);
		LapisOreDropMax = config.get(Configuration.CATEGORY_GENERAL, "Lapis Harvest DropCount Maximum", 9).getInt(9);
		LapisOreDropFragments = config.get(Configuration.CATEGORY_GENERAL, "LapisOre Drop as small Fragments", false).getBoolean(false);

		RedstoneOreHarvestXPMin = config.get(Configuration.CATEGORY_GENERAL, "Redstone Harvest XP Minimum", 1).getInt(1);
		RedstoneOreHarvestXPMax = config.get(Configuration.CATEGORY_GENERAL, "Redstone Harvest XP Maximum", 5).getInt(5);
		RedstoneOreDropMin = config.get(Configuration.CATEGORY_GENERAL, "Redstone Harvest DropCount Minimum", 4).getInt(4);
		RedstoneOreDropMax = config.get(Configuration.CATEGORY_GENERAL, "Redstone Harvest DropCount Maximum", 5).getInt(5);
		RedstoneOreDropFragments = config.get(Configuration.CATEGORY_GENERAL, "RedstoneOre Drop as small Fragments", false).getBoolean(false);
		
		NetherQuartzOreHarvestXPMin = config.get(Configuration.CATEGORY_GENERAL, "NetherQuartz Harvest XP Minimum", 2).getInt(2);
		NetherQuartzOreHarvestXPMax = config.get(Configuration.CATEGORY_GENERAL, "NetherQuartz Harvest XP Maximum", 5).getInt(5);
		NetherQuartzOreDropMin = config.get(Configuration.CATEGORY_GENERAL, "NetherQuartz Harvest DropCount Minimum", 4).getInt(4);
		NetherQuartzOreDropMax = config.get(Configuration.CATEGORY_GENERAL, "NetherQuartz Harvest DropCount Maximum", 9).getInt(9);
		NetherQuartzOreDropFragments = config.get(Configuration.CATEGORY_GENERAL, "NetherQuartzOre Drop as small Fragments", false).getBoolean(false);

		GlowstoneOreHarvestXPMin = config.get(Configuration.CATEGORY_GENERAL, "Glowstone Harvest XP Minimum", 0).getInt(0);
		GlowstoneOreHarvestXPMax = config.get(Configuration.CATEGORY_GENERAL, "Glowstone Harvest XP Maximum", 0).getInt(0);
		GlowstoneOreDropMin = config.get(Configuration.CATEGORY_GENERAL, "Glowstone Harvest DropCount Minimum", 2).getInt(2);
		GlowstoneOreDropMax = config.get(Configuration.CATEGORY_GENERAL, "Glowstone Harvest DropCount Maximum", 4).getInt(4);
		GlowstoneOreDropFragments = config.get(Configuration.CATEGORY_GENERAL, "GlowstoneOre Drop as small Fragments", false).getBoolean(false);

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
		if(IronOreDropFragments)
			GameRegistry.addRecipe(new ItemStack(Block.oreIron, 1), new Object[] { "###", "###", "###", '#', new ItemStack(OresDropMoresItems.OreFragment, 1, 0) });
		else
			FurnaceRecipes.smelting().addSmelting(OresDropMoresItems.OreItem.itemID, OreItem.iron, new ItemStack(Item.ingotIron), IronOreSmeltXP);
		
		if(GoldOreDropFragments)
			GameRegistry.addRecipe(new ItemStack(Block.oreGold, 1), new Object[] { "###", "###", "###", '#', new ItemStack(OresDropMoresItems.OreFragment, 1, 1) });
		else
			FurnaceRecipes.smelting().addSmelting(OresDropMoresItems.OreItem.itemID, OreItem.gold, new ItemStack(Item.ingotGold), GoldOreSmeltXP);
		
		if(GlowstoneOreDropFragments)
			GameRegistry.addRecipe(new ItemStack(Block.glowStone, 1), new Object[] { "###", "###", "###", '#', new ItemStack(OresDropMoresItems.OreFragment, 1, 2) });
		if(CoalOreDropFragments)
			GameRegistry.addRecipe(new ItemStack(Block.oreCoal, 1), new Object[] { "###", "###", "###", '#', new ItemStack(OresDropMoresItems.OreFragment, 1, 3) });
		if(DiamondOreDropFragments)
			GameRegistry.addRecipe(new ItemStack(Block.oreDiamond, 1), new Object[] { "###", "###", "###", '#', new ItemStack(OresDropMoresItems.OreFragment, 1, 4) });
		if(EmeraldOreDropFragments)
			GameRegistry.addRecipe(new ItemStack(Block.oreEmerald, 1), new Object[] { "###", "###", "###", '#', new ItemStack(OresDropMoresItems.OreFragment, 1, 5) });
		if(LapisOreDropFragments)
			GameRegistry.addRecipe(new ItemStack(Block.oreLapis, 1), new Object[] { "###", "###", "###", '#', new ItemStack(OresDropMoresItems.OreFragment, 1, 6) });
		if(NetherQuartzOreDropFragments)
			GameRegistry.addRecipe(new ItemStack(Block.oreNetherQuartz, 1), new Object[] { "###", "###", "###", '#', new ItemStack(OresDropMoresItems.OreFragment, 1, 7) });
		if(RedstoneOreDropFragments)
			GameRegistry.addRecipe(new ItemStack(Block.oreRedstone, 1), new Object[] { "###", "###", "###", '#', new ItemStack(OresDropMoresItems.OreFragment, 1, 8) });
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		FMLLog.info("[OresDropMores2] postInit");
	}
}
