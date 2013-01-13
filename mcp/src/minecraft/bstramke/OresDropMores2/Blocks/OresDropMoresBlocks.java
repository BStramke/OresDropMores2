package bstramke.OresDropMores2.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.creativetab.CreativeTabs;


public class OresDropMoresBlocks {
	public static final Block odmOreIronBlock = new ODMOreIronBlock(15,33).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreIron");
	public static final Block odmOreGoldBlock = new ODMOreGoldBlock(14,32).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreGold");
	public static final Block odmOreCoalBlock = new ODMOreCoalBlock(16,34).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreCoal");
	public static final Block odmOreLapisBlock = new ODMOreLapisBlock(21,160).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreLapis");
	public static final Block odmOreDiamondBlock = new ODMOreDiamondBlock(56,50).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreDiamond");
	public static final Block odmOreRedstoneBlock = new ODMOreRedstoneBlock(73,51, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreRedstone").setRequiresSelfNotify().setCreativeTab(CreativeTabs.tabBlock);
   public static final Block odmOreRedstoneBlockGlowing = (new ODMOreRedstoneBlock(74, 51, true)).setLightValue(0.625F).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreRedstone").setRequiresSelfNotify();
	public static final Block odmOreEmeraldBlock = new ODMOreEmeraldBlock(129,171).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreEmerald");
}
