package bstramke.OresDropMores2.Blocks;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import bstramke.OresDropMores2.OreConfigDefaults;
import bstramke.OresDropMores2.OresDropMores2;
import bstramke.OresDropMores2.OreConfig;
import bstramke.OresDropMores2.Items.OreFragment;
import bstramke.OresDropMores2.Items.OreItem;

public class OresDropMoresBlocks {
	public static void Init() {
		for (Entry<String, OreConfig> entry : OresDropMores2.OreConfiguration.entrySet()) {
			if (entry.getValue().DoOreOverwrite == false)
				continue;
			Block.blocksList[entry.getValue().BlockId] = null;

			if(entry.getValue().BlockId != 73) //redstone...
				Block.blocksList[entry.getValue().BlockId] = new ODMBlockOreDrop(entry.getValue().BlockId, entry.getValue());
			else
			{
				Block.blocksList[73] = new ODMOreRedstoneBlock(73, false, entry.getValue()).setCreativeTab(CreativeTabs.tabBlock);

				// set the glowing redstone values
				Block.blocksList[entry.getValue().BlockId + 1] = null;
				Block.blocksList[74] = new ODMOreRedstoneBlock(74, true, entry.getValue()).setLightValue(0.625F).setResistance(0.3F).setStepSound(entry.getValue().stepSound)
						.setHardness(entry.getValue().Hardness).setUnlocalizedName(entry.getValue().UnlocalizedName).setTextureName(entry.getValue().TextureName);
			}

			Block.blocksList[entry.getValue().BlockId].setResistance(entry.getValue().Resistance).setStepSound(entry.getValue().stepSound).setHardness(entry.getValue().Hardness)
					.setUnlocalizedName(entry.getValue().UnlocalizedName).setTextureName(entry.getValue().TextureName);
		}
		
		try {
			setFinalStatic(Block.class.getField("oreGold"), Block.blocksList[14]);
			setFinalStatic(Block.class.getField("oreIron"), Block.blocksList[15]);
			setFinalStatic(Block.class.getField("oreCoal"), Block.blocksList[16]);
			setFinalStatic(Block.class.getField("oreLapis"), Block.blocksList[21]);
			setFinalStatic(Block.class.getField("oreDiamond"), Block.blocksList[56]);
			setFinalStatic(Block.class.getField("oreRedstone"), Block.blocksList[73]);
			setFinalStatic(Block.class.getField("oreRedstoneGlowing"), Block.blocksList[74]);
			setFinalStatic(Block.class.getField("glowStone"), Block.blocksList[89]);
			setFinalStatic(Block.class.getField("oreEmerald"), Block.blocksList[129]);
			setFinalStatic(Block.class.getField("oreNetherQuartz"), Block.blocksList[153]);
		} catch (NoSuchFieldException e) {
			// e.printStackTrace();
		} catch (SecurityException e) {
			// e.printStackTrace();
		} catch (Exception e) {
			// e.printStackTrace();
		}

		try {
			setFinalStatic(Block.class.getField("field_71941_G"), Block.blocksList[14]); // Ore Gold
			setFinalStatic(Block.class.getField("field_71949_H"), Block.blocksList[15]); // Ore Iron
			setFinalStatic(Block.class.getField("field_71950_I"), Block.blocksList[16]); // Ore Coal
			setFinalStatic(Block.class.getField("field_71947_N"), Block.blocksList[21]); // Ore Lapis
			setFinalStatic(Block.class.getField("field_72073_aw"), Block.blocksList[56]); // Ore Diamond
			setFinalStatic(Block.class.getField("field_72047_aN"), Block.blocksList[73]); // Ore Redstone
			setFinalStatic(Block.class.getField("field_72048_aO"), Block.blocksList[74]); // Ore Redstone Glowing
			setFinalStatic(Block.class.getField("field_72014_bd"), Block.blocksList[89]); // glowStone
			setFinalStatic(Block.class.getField("field_72068_bR"), Block.blocksList[129]); // Ore Emerald
			setFinalStatic(Block.class.getField("field_94342_cr"), Block.blocksList[153]); // oreNetherQuartz
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

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

	static void setFinalStatic(Field field, Object newValue) throws Exception {
		field.setAccessible(true);

		// remove final modifier from field
		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

		field.set(null, newValue);
	}
}
