package bstramke.OresDropMores2.Blocks;

import cpw.mods.fml.common.Mod.Instance;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlowStone;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
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
		Block.blocksList[89] = null;
		Block.blocksList[129] = null;
		Block.blocksList[153] = null;
				
		Block.blocksList[14] = new ODMOreGoldBlock(14).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreGold").func_111022_d("gold_ore");
		Block.blocksList[15] = new ODMOreIronBlock(15).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreIron").func_111022_d("iron_ore");
		Block.blocksList[16] = new ODMOreCoalBlock(16).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreCoal").func_111022_d("coal_ore");
		Block.blocksList[21] = new ODMOreLapisBlock(21).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreLapis").func_111022_d("lapis_ore");
		Block.blocksList[56] = new ODMOreDiamondBlock(56).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreDiamond").func_111022_d("diamond_ore");
		Block.blocksList[73] = new ODMOreRedstoneBlock(73, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreRedstone").setCreativeTab(CreativeTabs.tabBlock).func_111022_d("redstone_ore");
		Block.blocksList[74] = (new ODMOreRedstoneBlock(74, true)).setLightValue(0.625F).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreRedstone").func_111022_d("redstone_ore");
		Block.blocksList[89] = (new ODMBlockGlowStone(89, Material.glass)).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setLightValue(1.0F).setUnlocalizedName("lightgem").func_111022_d("glowstone");
		Block.blocksList[129] = new ODMOreEmeraldBlock(129).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreEmerald").func_111022_d("emerald_ore");
		Block.blocksList[153] = new ODMOreNetherQuartzBlock(153).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("netherquartz").func_111022_d("quartz_ore");
		
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
