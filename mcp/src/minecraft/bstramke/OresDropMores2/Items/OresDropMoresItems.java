package bstramke.OresDropMores2.Items;

import net.minecraft.item.Item;
import bstramke.OresDropMores2.OresDropMores2;

public class OresDropMoresItems {
	public static Item OreItem;
	public static Item OreFragment;
	public static void Init() {
		OreItem = new OreItem(OresDropMores2.OreItemId).setUnlocalizedName("OresDropMoresOreItem");
		OreFragment = new OreFragment(OresDropMores2.OreFragmentItemId).setUnlocalizedName("OresDropMoresOreFragmentItem");
	}
}
