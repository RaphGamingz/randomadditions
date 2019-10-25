package raph.RandomAdditions.items.floatingChest;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import raph.RandomAdditions.ModRegistries;
import raph.RandomAdditions.RandomAdditions;

public class FloatingChest extends Item {
	public FloatingChest() {
        super(new Item.Properties().group(RandomAdditions.CUSTOMITEMGROUP));
        setRegistryName(ModRegistries.location("floating_chest"));
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (!worldIn.isRemote) {
			NetworkHooks.openGui((ServerPlayerEntity) playerIn, new FloatingChestProvider());
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("Opens the Ender Chest Inventory"));
	}
}