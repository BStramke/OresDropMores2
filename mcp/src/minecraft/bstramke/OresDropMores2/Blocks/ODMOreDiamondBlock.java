package bstramke.OresDropMores2.Blocks;

import java.util.Random;

import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import bstramke.OresDropMores2.OresDropMores2;

public class ODMOreDiamondBlock extends ODMBlockOreDrop {

	public ODMOreDiamondBlock(int par1) {
		super(par1);
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return MathHelper.getRandomIntegerInRange(par1Random, OresDropMores2.DiamondOreDropMin, OresDropMores2.DiamondOreDropMax);
	}

	@Override
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
		super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
		this.dropXpOnBlockBreak(par1World, par2, par3, par4,
				MathHelper.getRandomIntegerInRange(par1World.rand, OresDropMores2.DiamondOreHarvestXPMin, OresDropMores2.DiamondOreHarvestXPMax));
	}
	
}
