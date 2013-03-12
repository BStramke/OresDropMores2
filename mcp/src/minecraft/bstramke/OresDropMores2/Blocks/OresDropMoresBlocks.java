package bstramke.OresDropMores2.Blocks;

import cpw.mods.fml.common.Mod.Instance;
import net.minecraft.block.Block;
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
				
		Block.blocksList[14] = new ODMOreGoldBlock(14,32).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreGold");
		Block.blocksList[15] = new ODMOreIronBlock(15,33).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreIron");
		Block.blocksList[16] = new ODMOreCoalBlock(16,34).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreCoal");
		Block.blocksList[21] = new ODMOreLapisBlock(21,160).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreLapis");
		Block.blocksList[56] = new ODMOreDiamondBlock(56,50).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreDiamond");
		Block.blocksList[73] = new ODMOreRedstoneBlock(73,51, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreRedstone").setRequiresSelfNotify().setCreativeTab(CreativeTabs.tabBlock);
		Block.blocksList[74] = (new ODMOreRedstoneBlock(74, 51, true)).setLightValue(0.625F).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreRedstone").setRequiresSelfNotify();
		Block.blocksList[129] = new ODMOreEmeraldBlock(129,171).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreEmerald");
		
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
