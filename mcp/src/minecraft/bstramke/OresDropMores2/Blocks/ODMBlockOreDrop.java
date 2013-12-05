package bstramke.OresDropMores2.Blocks;

import java.util.Random;

import bstramke.OresDropMores2.OreConfig;
import bstramke.OresDropMores2.Items.OreItem;
import bstramke.OresDropMores2.Items.OresDropMoresItems;

import net.minecraft.block.BlockOre;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ODMBlockOreDrop extends BlockOre {

	OreConfig conf;
	public ODMBlockOreDrop(int blockId, OreConfig conf_) {
		super(blockId);
		conf = conf_;
	}
	
	@Override
	public int damageDropped(int par1) {
		if(conf.DoOreDropFragments)
			return conf.FragmentMeta;
		else
		{
			if(blockID == 14)
				return OreItem.gold;
			else if(blockID == 15)
				return OreItem.iron;
			else
				return super.damageDropped(par1);
		}
	}
	
	public ODMBlockOreDrop(int par1) {
		super(par1);
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		return MathHelper.getRandomIntegerInRange(par1Random, conf.DropCountMin, conf.DropCountMax);
	}
	
	@Override
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
		super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
		this.dropXpOnBlockBreak(par1World, par2, par3, par4,
				MathHelper.getRandomIntegerInRange(par1World.rand, conf.HarvestXPMin, conf.HarvestXPMax));
	}
	
	@Override
	public int idDropped(int meta, Random par2Random, int par3) {
		if(!conf.DoOreDropFragments)
		{
			if(blockID == 14 || blockID == 15) //gold and iron
				return OresDropMoresItems.OreItem.itemID;
			else
				return super.idDropped(meta, par2Random, par3);
		}
		else
			return OresDropMoresItems.OreFragment.itemID;
	}
}
