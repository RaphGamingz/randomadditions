package raph.RandomAdditions.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import raph.RandomAdditions.ModRegistries;
import raph.RandomAdditions.RandomAdditions;
import raph.RandomAdditions.init.ModArmourMaterials;
import raph.RandomAdditions.init.ModItems;

public class InvisibilityCloak extends ArmorItem {

	public InvisibilityCloak() {
		super(
			ModArmourMaterials.Special_Armour, 
			EquipmentSlotType.CHEST, 
			new Item.Properties().group(RandomAdditions.CUSTOMITEMGROUP)
		);
        setRegistryName(ModRegistries.location("invisibility_cloak"));
	}
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		if(player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ModItems.invisiblity_cloak) {
			player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 2, 100));
		}
	}
}