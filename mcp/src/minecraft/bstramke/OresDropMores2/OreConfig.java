package bstramke.OresDropMores2;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraftforge.common.Configuration;

public class OreConfig {
	public boolean DoOreOverwrite;
	public int HarvestXPMin;
	public int HarvestXPMax;
	public int DropCountMin;
	public int DropCountMax;
	protected float OreSmeltXP;
	public boolean DoOreDropFragments;
	public int BlockId;
	public int FragmentMeta;
	public float Resistance;
	public float Hardness;
	public String TextureName;
	public String UnlocalizedName;
	public StepSound stepSound;
	public int SmeltResultCount;
	public int SmeltResultItemId;
	public int SmeltResultItemMeta;

	
	public OreConfig(Configuration config, String OreName, OreConfigDefaults defaults, String TextureName_) {
		String Category = "Settings for " + OreName;
		
		DoOreOverwrite = config.get(Category, "Overwrite " + OreName, true).getBoolean(true);
		HarvestXPMin = config.get(Category, OreName +" Harvest XP", defaults.MinXP).getInt(defaults.MinXP);
		HarvestXPMax = config.get(Category, OreName +" Harvest XP", defaults.MaxXP).getInt(defaults.MaxXP);
		DropCountMin = config.get(Category, OreName +" Harvest DropCount Minimum", defaults.DropCountMin).getInt(defaults.DropCountMin);
		DropCountMax = config.get(Category, OreName +" Harvest DropCount Maximum", defaults.DropCountMax).getInt(defaults.DropCountMax);
		OreSmeltXP = (float) config.get(Category, OreName +" Smelt XP", defaults.SmeltXP).getDouble(defaults.SmeltXP);
		SmeltResultCount = config.get(Category, OreName +" Number of Smelt Results", defaults.SmeltResultCount).getInt(defaults.SmeltResultCount);
		if(OreSmeltXP > 1.0F)
			OreSmeltXP = 1.0F;
		DoOreDropFragments = config.get(Category, OreName +" Drop as small Fragments", false).getBoolean(false);
		SmeltResultItemId = defaults.SmeltResultId;
		SmeltResultItemMeta = defaults.SmeltResultMeta;
		BlockId = defaults.ToReplaceBlock.blockID;
		Resistance = defaults.ToReplaceBlock.blockResistance;
		Hardness = defaults.ToReplaceBlock.blockHardness;
		TextureName = TextureName_;
		UnlocalizedName = defaults.ToReplaceBlock.getUnlocalizedName();
		stepSound = defaults.ToReplaceBlock.stepSound;
		FragmentMeta = defaults.FragmentMeta;
	}
}