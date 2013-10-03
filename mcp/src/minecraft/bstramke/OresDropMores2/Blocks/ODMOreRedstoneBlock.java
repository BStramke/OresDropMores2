package bstramke.OresDropMores2.Blocks;

import java.util.Random;

import bstramke.OresDropMores2.OresDropMores2;
import bstramke.OresDropMores2.Items.OresDropMoresItems;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ODMOreRedstoneBlock extends BlockRedstoneOre {

	public ODMOreRedstoneBlock(int par1, boolean par3) {
		super(par1, par3);
	}

	public int damageDropped(int par1) {
		if(!OresDropMores2.RedstoneOreDropFragments)
			return super.damageDropped(par1);
		else
			return 8;
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		return MathHelper.getRandomIntegerInRange(par1Random, OresDropMores2.RedstoneOreDropMin, OresDropMores2.RedstoneOreDropMax);
	}

	@Override
	public int idDropped(int meta, Random par2Random, int par3) {
		if(!OresDropMores2.RedstoneOreDropFragments)
			return super.idDropped(meta, par2Random, par3);
		else
			return OresDropMoresItems.OreFragment.itemID;
	}
	
	@Override
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
		super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
		this.dropXpOnBlockBreak(par1World, par2, par3, par4,
				MathHelper.getRandomIntegerInRange(par1World.rand, OresDropMores2.RedstoneOreHarvestXPMin, OresDropMores2.RedstoneOreHarvestXPMax));
	}
}
