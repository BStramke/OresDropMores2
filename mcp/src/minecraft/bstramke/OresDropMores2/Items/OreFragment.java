package bstramke.OresDropMores2.Items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class OreFragment extends Item {
	//Metadata Values
	public static int Iron = 0;
	public static int Gold = 1;
	public static int Glowstone = 2;
	public static int Coal = 3;
	public static int Diamond = 4;
	public static int Emerald = 5;
	public static int Lapis = 6;
	public static int NetherQuartz = 7;
	public static int Redstone = 8;
	
	Icon itemIconGold;
	Icon itemIconGlowstone;
	Icon itemIconCoal;
	Icon itemIconDiamond;
	Icon itemIconEmerald;
	Icon itemIconLapis;
	Icon itemIconNetherQuartz;
	Icon itemIconRedstone;

	// meta: iron, gold, glowstone, coal, diamond, emerald, lapis, netherquartz,
	// redstone
	public OreFragment(int par1) {
		super(par1);
		this.setMaxDamage(0);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setHasSubtypes(true);
	}

	public static String[] itemDisplayNames = new String[] {
			"Iron Ore Fragment", "Gold Ore Fragment", "Glowstone Ore Fragment",
			"Coal Ore Fragment", "Diamond Ore Fragment",
			"Emerald Ore Fragment", "Lapis Ore Fragment",
			"NetherQuartz Ore Fragment", "Redstone Ore Fragment" };

	@Override
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("oresdropmores2:fragmentIronOre");
		itemIconGold = iconRegister
				.registerIcon("oresdropmores2:fragmentGoldOre");
		itemIconGlowstone = iconRegister
				.registerIcon("oresdropmores2:fragmentGlowstoneOre");
		itemIconCoal = iconRegister
				.registerIcon("oresdropmores2:fragmentCoalOre");
		itemIconDiamond = iconRegister
				.registerIcon("oresdropmores2:fragmentDiamondOre");
		itemIconEmerald = iconRegister
				.registerIcon("oresdropmores2:fragmentEmeraldOre");
		itemIconLapis = iconRegister
				.registerIcon("oresdropmores2:fragmentLapisOre");
		itemIconNetherQuartz = iconRegister
				.registerIcon("oresdropmores2:fragmentNetherQuartzOre");
		itemIconRedstone = iconRegister
				.registerIcon("oresdropmores2:fragmentRedstoneOre");
	}
	
	@Override
	public Icon getIconFromDamage(int par1) {
		switch (par1) {
		case 0:
			return itemIcon;
		case 1:
			return itemIconGold;
		case 2:
			return itemIconGlowstone;
		case 3:
			return itemIconCoal;
		case 4:
			return itemIconDiamond;
		case 5:
			return itemIconEmerald;
		case 6:
			return itemIconLapis;
		case 7:
			return itemIconNetherQuartz;
		case 8:
			return itemIconRedstone;
		default:
			return itemIcon;
		}
	}

	public static int getMetadataSize() {
		return itemDisplayNames.length;
	}

	@Override
	public String getItemDisplayName(ItemStack is) {
		if (is.getItemDamage() < getMetadataSize() && is.getItemDamage() >= 0)
			return itemDisplayNames[is.getItemDamage()];
		else
			return itemDisplayNames[0];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(int par1, CreativeTabs tab, List list) {
		for (int metaNumber = 0; metaNumber < getMetadataSize(); metaNumber++) {
			list.add(new ItemStack(par1, 1, metaNumber));
		}
	}
}
