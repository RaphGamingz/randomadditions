package raph.RandomAdditions.init;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ModToolMaterials implements IItemTier {
	Basic_Magical_Tool(10.0f, 9.0f, 1500, 3, 25, ModItems.magical_ingot),
	Terra_Tool(12.0f, 10.0f, 1650, 3, 30, ModItems.terrasteel);
	
	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchantability;
	private Item repairMaterial;
	
	private ModToolMaterials(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial) {
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public int getMaxUses() {
		return this.durability;
	}

	@Override
	public float getEfficiency() {
		return this.efficiency;
	}

	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}

	@Override
	public int getHarvestLevel() {
		return this.harvestLevel;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromItems(this.repairMaterial);
	}
}
