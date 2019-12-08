package raph.RandomAdditions.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import raph.RandomAdditions.RandomAdditions;

public enum ModArmourMaterials implements IArmorMaterial {
	Basic_Magical_Armour("basicmagical", 30, new int[] {8, 9, 10, 7}, 25, ModItems.magical_ingot, "entity.skeleton.hurt", 0.0f),
	Terra_Armour("terra", 40, new int[] {8, 9, 10, 7}, 30, ModItems.terrasteel, "entity.skeleton.hurt", 1.0f),
	
	Special_Armour("special", 50, new int[] {8, 9, 10, 7}, 40, ModItems.magical_dust, "entity.skeleton.hurt", 1.5f);

	private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
	private String name, equipSound;
	private int durability, enchantability;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;
	
	private ModArmourMaterials(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness) {
		this.name = name;
		this.equipSound = equipSound;
		this.durability = durability;
		this.enchantability = enchantability;
		this.repairItem = repairItem;
		this.damageReductionAmounts = damageReductionAmounts;
		this.toughness = toughness;
	}

	@Override
	public int getDurability(EquipmentSlotType slot) {
		return max_damage_array[slot.getIndex()] * this.durability;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) {
		return this.damageReductionAmounts[slot.getIndex()];
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() {
		return new SoundEvent(new ResourceLocation(equipSound));
	}

	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public String getName() {
		return RandomAdditions.MODID + ":" + this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}
}
