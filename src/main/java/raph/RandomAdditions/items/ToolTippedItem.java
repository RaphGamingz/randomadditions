package raph.RandomAdditions.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ToolTippedItem extends Item {

	private String[] components;
	
	public ToolTippedItem(Properties properties, String... components) {
		super(properties);
		this.components = components;
	}
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		for (String line : components) {
			tooltip.add(new StringTextComponent(line));
		}
	}
}
