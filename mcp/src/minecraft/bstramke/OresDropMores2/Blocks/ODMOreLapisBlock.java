package bstramke.OresDropMores2.Blocks;

import java.util.Random;

import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import bstramke.OresDropMores2.OresDropMores2;
import bstramke.OresDropMores2.Items.OresDropMoresItems;

public class ODMOreLapisBlock extends ODMBlockOreDrop {

	public ODMOreLapisBlock(int par1) {
		super(par1);
	}

	public int damageDropped(int par1) {
		if(!OresDropMores2.LapisOreDropFragments)
			return super.damageDropped(par1);
		else
			return 6;
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		return MathHelper.getRandomIntegerInRange(par1Random, OresDropMores2.LapisOreDropMin, OresDropMores2.LapisOreDropMax);
	}

	@Override
	public int idDropped(int meta, Random par2Random, int par3) {
		if(!OresDropMores2.LapisOreDropFragments)
			return super.idDropped(meta, par2Random, par3);
		else
			return OresDropMoresItems.OreFragment.itemID;
	}
	
	@Override
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
		super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
		this.dropXpOnBlockBreak(par1World, par2, par3, par4,
				MathHelper.getRandomIntegerInRange(par1World.rand, OresDropMores2.LapisOreHarvestXPMin, OresDropMores2.LapisOreHarvestXPMax));
	}

}
