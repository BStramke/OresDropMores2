package bstramke.OresDropMores2;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.Configuration;
import bstramke.OresDropMores2.Blocks.OresDropMoresBlocks;
import bstramke.OresDropMores2.Common.CommonProxy;
import bstramke.OresDropMores2.Items.OreItem;
import bstramke.OresDropMores2.Items.OresDropMoresItems;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(name = "OresDropMores2", version = "0.1", modid = "OresDropMores2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class OresDropMores2 extends DummyModContainer {
	@Instance
	public static OresDropMores2 instance = new OresDropMores2();

	@SidedProxy(clientSide = "bstramke.OresDropMores2.Client.ClientProxy", serverSide = "bstramke.OresDropMores2.Common.CommonProxy")
	public static CommonProxy proxy;

	public static int OreItemId;
	public static int IronOreHarvestXPMin;
	public static int IronOreHarvestXPMax;
	public static int IronOreDropMin;
	public static int IronOreDropMax;
	protected static float IronOreSmeltXP;
	public static int GoldOreHarvestXPMin;
	public static int GoldOreHarvestXPMax;
	protected static float GoldOreSmeltXP;
	public static int GoldOreDropMin;
	public static int GoldOreDropMax;

	@PreInit
	public void PreLoad(FMLPreInitializationEvent event) {
		FMLLog.info("[OresDropMores2] PreLoad");
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		OreItemId = config.getItem(Configuration.CATEGORY_ITEM, "OreItemId", 5400).getInt();
		
		IronOreHarvestXPMin = config.get(Configuration.CATEGORY_GENERAL, "IronOre Harvest XP", 1).getInt(1);
		IronOreHarvestXPMax = config.get(Configuration.CATEGORY_GENERAL, "IronOre Harvest XP", 1).getInt(1);
		IronOreDropMin = config.get(Configuration.CATEGORY_GENERAL, "IronOre Harvest DropCount Minimum", 3).getInt(3);
		IronOreDropMax = config.get(Configuration.CATEGORY_GENERAL, "IronOre Harvest DropCount Maximum", 5).getInt(5);
		IronOreSmeltXP = (float) config.get(Configuration.CATEGORY_GENERAL, "IronOre Smelt XP", 0.1F).getDouble(0.1F);
		
		GoldOreHarvestXPMin = config.get(Configuration.CATEGORY_GENERAL, "GoldOre Harvest XP Minimum", 1).getInt(1);
		GoldOreHarvestXPMax = config.get(Configuration.CATEGORY_GENERAL, "GoldOre Harvest XP Maximum", 1).getInt(1);
		GoldOreDropMin = config.get(Configuration.CATEGORY_GENERAL, "IronOre Harvest DropCount Minimum", 3).getInt(3);
		GoldOreDropMax = config.get(Configuration.CATEGORY_GENERAL, "IronOre Harvest DropCount Maximum", 5).getInt(5);
		GoldOreSmeltXP = (float) config.get(Configuration.CATEGORY_GENERAL, "GoldOre Smelt XP", 0.2F).getDouble(0.2F);

		config.save();
		
		Block.blocksList[14] = null;
		Block.blocksList[15] = null;
	}

	@Init
	public void load(FMLInitializationEvent event) {

		initRecipes();
		initLanguageRegistry();
		proxy.registerRenderThings();
		
		Block.blocksList[14] = OresDropMoresBlocks.odmOreGoldBlock;
		Block.blocksList[15] = OresDropMoresBlocks.odmOreIronBlock;
	}

	private void initRecipes() {
		FurnaceRecipes.smelting().addSmelting(OresDropMoresItems.OreItem.itemID, OreItem.iron, new ItemStack(Item.ingotIron), IronOreSmeltXP);
		FurnaceRecipes.smelting().addSmelting(OresDropMoresItems.OreItem.itemID, OreItem.gold, new ItemStack(Item.ingotGold), GoldOreSmeltXP);
	}

	private void initLanguageRegistry() {
		for (int i = 0; i < ((OreItem) OresDropMoresItems.OreItem).getMetadataSize(); i++) {
			LanguageRegistry.instance().addStringLocalization("item.OresDropMoresOreItem." + ((OreItem) OresDropMoresItems.OreItem).itemNames[i] + ".name",
					((OreItem) OresDropMoresItems.OreItem).itemDisplayNames[i]);
		}

	}

	@PostInit
	public static void postInit(FMLPostInitializationEvent event) {
		FMLLog.info("[OresDropMores2] postInit");
	}
}
