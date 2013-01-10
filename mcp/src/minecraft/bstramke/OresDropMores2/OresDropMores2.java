package bstramke.OresDropMores2;

import net.minecraft.block.Block;
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

	@PreInit
	public void PreLoad(FMLPreInitializationEvent event) {
		FMLLog.info("[OresDropMores2] PreLoad");
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		OreItemId = config.getItem(Configuration.CATEGORY_ITEM, "OreItemId", 5400).getInt();

		config.save();
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
