package bstramke.OresDropMores2;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;

public class OreConfigDefaults {
	public int MinXP;
	public int MaxXP;
	public int DropCountMin;
	public int DropCountMax; 
	public float SmeltXP;
	public int SmeltResultCount;
	public int SmeltResultId;
	public int SmeltResultMeta;
	public Block ToReplaceBlock;
	public int FragmentMeta;
	
	public OreConfigDefaults(int MinXp, int MaxXp, int MinDropCount, int MaxDropCount, float SmeltXp, Block ToReplaceBlock, int FragmentMeta_, int SmeltResultCount, int SmeltResultId_, int SmeltResultMeta_) {
		this.MinXP = MinXp;
		this.MaxXP = MaxXp;
		this.DropCountMin = MinDropCount;
		this.DropCountMax = MaxDropCount;
		this.SmeltXP = SmeltXp;
		this.SmeltResultCount = SmeltResultCount;
		this.ToReplaceBlock = ToReplaceBlock;
		this.FragmentMeta = FragmentMeta_;
		this.SmeltResultId = SmeltResultId_;
		this.SmeltResultMeta = SmeltResultMeta_;
	}
}
