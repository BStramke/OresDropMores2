package bstramke.OresDropMores2.Blocks;

import cpw.mods.fml.common.Mod.Instance;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import bstramke.OresDropMores2.OresDropMores2;


public class OresDropMoresBlocks {	
	public static void Init() {
		Block.blocksList[14] = null;
		Block.blocksList[15] = null;
		Block.blocksList[16] = null;
		Block.blocksList[21] = null;
		Block.blocksList[56] = null;
		Block.blocksList[73] = null;
		Block.blocksList[74] = null;
		Block.blocksList[129] = null;
		Block.blocksList[153] = null;
				
		Block.blocksList[14] = new ODMOreGoldBlock(14).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreGold");
		Block.blocksList[15] = new ODMOreIronBlock(15).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreIron");
		Block.blocksList[16] = new ODMOreCoalBlock(16).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreCoal");
		Block.blocksList[21] = new ODMOreLapisBlock(21).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreLapis");
		Block.blocksList[56] = new ODMOreDiamondBlock(56).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreDiamond");
		Block.blocksList[73] = new ODMOreRedstoneBlock(73, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreRedstone").setCreativeTab(CreativeTabs.tabBlock);
		Block.blocksList[74] = (new ODMOreRedstoneBlock(74, true)).setLightValue(0.625F).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreRedstone");
		Block.blocksList[129] = new ODMOreEmeraldBlock(129).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreEmerald");
		Block.blocksList[153] = new ODMOreNetherQuartzBlock(153).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("netherquartz");
		
		if (OresDropMores2.ReduceToolRequirements) {
			MinecraftForge.setBlockHarvestLevel(Block.blocksList[14], "pickaxe", 1);
			MinecraftForge.setBlockHarvestLevel(Block.blocksList[15], "pickaxe", 0);
			MinecraftForge.setBlockHarvestLevel(Block.blocksList[56], "pickaxe", 1);
			MinecraftForge.setBlockHarvestLevel(Block.blocksList[129], "pickaxe", 1);
			MinecraftForge.setBlockHarvestLevel(Block.blocksList[73], "pickaxe", 1);
			MinecraftForge.setBlockHarvestLevel(Block.blocksList[74], "pickaxe", 1);
			MinecraftForge.setBlockHarvestLevel(Block.obsidian, "pickaxe", 2);
		}		
	}
}
