package bstramke.OresDropMores2.Blocks;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import bstramke.OresDropMores2.Items.OresDropMoresItems;

public class ODMBlockOre extends BlockOre {

	public ODMBlockOre(int par1) {
		super(par1);
	}
	
	@Override
	public int idDropped(int meta, Random par2Random, int par3) {
		return OresDropMoresItems.OreItem.itemID;
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		return 1 + par1Random.nextInt(3);
	}
}
