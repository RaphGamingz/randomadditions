package raph.RandomAdditions.init;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;
import raph.RandomAdditions.items.floatingChest.FloatingChestContainer;

public class ModItems {
	//Has To Be Lower Case Or Game Will Crash
	public static Item magical_ingot;
	public static Item magical_blend;
	public static Item magical_dust;
	
	public static Item terra_drop;
	public static Item terrasteel;
	
	//Food
	public static Item magical_apple;
	public static Item candy;
	public static Item coffee;
	
	//Tool
	public static Item basic_magical_axe;
	public static Item basic_magical_hoe;
	public static Item basic_magical_pickaxe;
	public static Item basic_magical_shovel;
	public static Item basic_magical_sword;
	
	public static Item terra_axe;
	public static Item terra_hoe;
	public static Item terra_pickaxe;
	public static Item terra_shovel;
	public static Item terra_sword;
	
	//Armour
	public static Item basic_magical_helmet;
	public static Item basic_magical_chestplate;
	public static Item basic_magical_leggings;
	public static Item basic_magical_boots;
	
	public static Item terra_helmet;
	public static Item terra_chestplate;
	public static Item terra_leggings;
	public static Item terra_boots;
	
	//Eggs
	public static Item magical_cow_egg;
	public static Item magical_pig_egg;
	public static Item magical_chest_egg;
	
	//Block
	public static Item magical_block;
	public static Item magical_ore;
	
	public static Item terra_altar;
	public static Item bounctium;
	
	public static Item magical_generator;
	public static Item magical_storage_chest;
	
	//Custom
	public static Item floating_chest;
	@ObjectHolder("randomadditionsraph:floating_chest")
	public static ContainerType<FloatingChestContainer> floating_chest_container;
}
