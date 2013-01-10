package bstramke.OresDropMores2.Blocks;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import bstramke.OresDropMores2.Items.OresDropMoresItems;

public class ODMBlockOre extends BlockOre {

	public ODMBlockOre(int par1, int par2) {
		super(par1, par2);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int idDropped(int meta, Random par2Random, int par3) {
		return OresDropMoresItems.OreItem.itemID;
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		return 1 + par1Random.nextInt(3);
	}
	
	@Override
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
		super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
		
		this.dropXpOnBlockBreak(par1World, par2, par3, par4, MathHelper.getRandomIntegerInRange(par1World.rand, 0, 3));
		
		/*if (this.idDropped(par5, par1World.rand, par7) != this.blockID)
      {
          int var8 = 0;

          if (this.blockID == Block.oreCoal.blockID)
          {
              var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 0, 2);
          }
          else if (this.blockID == Block.oreDiamond.blockID)
          {
              var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
          }
          else if (this.blockID == Block.oreEmerald.blockID)
          {
              var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
          }
          else if (this.blockID == Block.oreLapis.blockID)
          {
              var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);
          }

          
      }*/
		
	}
}
