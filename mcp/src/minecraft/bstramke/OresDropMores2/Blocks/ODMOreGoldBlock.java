package bstramke.OresDropMores2.Blocks;

import java.util.Random;

import bstramke.OresDropMores2.Items.OresDropMoresItems;


public class ODMOreGoldBlock extends ODMBlockOre {

	public ODMOreGoldBlock(int par1, int par2) {
		super(par1, par2);
	}
	
   public int damageDropped(int par1)
   {
       return 1;
   }
}
