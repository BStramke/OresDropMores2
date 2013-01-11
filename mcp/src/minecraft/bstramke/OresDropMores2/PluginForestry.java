package bstramke.OresDropMores2;

import java.util.Random;

import net.minecraft.command.ICommand;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import bstramke.OresDropMores2.Items.OreItem;
import bstramke.OresDropMores2.Items.OresDropMoresItems;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.IGuiHandler;
import forestry.api.core.IOreDictionaryHandler;
import forestry.api.core.IPacketHandler;
import forestry.api.core.IPickupHandler;
import forestry.api.core.IPlugin;
import forestry.api.core.IResupplyHandler;
import forestry.api.core.ISaveEventHandler;
import forestry.api.core.PluginInfo;
import forestry.api.storage.BackpackManager;

@PluginInfo(name = "OresDropMores2 Forestry Plugin", pluginID = "OresDropMores2ForestryPlugin", author = "bstramke")
public class PluginForestry implements IPlugin {
	// forestry backpack numbers
	private static final int MINER = 0;
	private static final int DIGGER = 1;
	private static final int FORESTER = 2;
	private static final int ADVENTURER = 3;
	private static final int BUILDER = 4;
	@Override
	public boolean isAvailable() {
		return true;
	}

	@Override
	public void preInit() {}

	@Override
	public void doInit() {
		FMLLog.info("[OresDropMores2] Loading Forestry Plugin");
		addBackpackItems();
	}

	@Override
	public void postInit() {}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public void generateSurface(World world, Random rand, int chunkX, int chunkZ) {}

	@Override
	public IGuiHandler getGuiHandler() {
		return null;
	}

	@Override
	public IPacketHandler getPacketHandler() {
		return null;
	}

	@Override
	public IPickupHandler getPickupHandler() {
		return null;
	}

	@Override
	public IResupplyHandler getResupplyHandler() {
		return null;
	}

	@Override
	public ISaveEventHandler getSaveEventHandler() {
		return null;
	}

	@Override
	public IOreDictionaryHandler getDictionaryHandler() {
		return null;
	}

	@Override
	public ICommand[] getConsoleCommands() {
		return null;
	}

	private static void addBackpackItems() {
		BackpackManager.backpackItems[MINER].add(new ItemStack(OresDropMoresItems.OreItem, 1, OreItem.iron));
		BackpackManager.backpackItems[MINER].add(new ItemStack(OresDropMoresItems.OreItem, 1, OreItem.gold));
	}
}
