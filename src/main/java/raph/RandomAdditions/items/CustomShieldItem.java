package raph.RandomAdditions.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;

public class CustomShieldItem extends ShieldItem {

	private int duration;
	private Item item;
	
	public CustomShieldItem(Properties builder, int duration, Item item) {
		super(builder);
		this.duration = duration;
		this.item = item;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return duration;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return item == repair.getItem() ? true : false;
	}
}