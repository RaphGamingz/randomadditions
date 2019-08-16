package raph.RandomAdditions;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import raph.RandomAdditions.init.ModItems;

public class CustomItemGroup extends ItemGroup {

	public CustomItemGroup() {
		super("Random Additions");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ModItems.magical_ingot);
	}
}
