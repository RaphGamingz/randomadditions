package raph.RandomAdditions;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import raph.RandomAdditions.customBlocks.MagicalGenerator;
import raph.RandomAdditions.customBlocks.MagicalGeneratorTile;
import raph.RandomAdditions.init.ModArmourMaterials;
import raph.RandomAdditions.init.ModBiomes;
import raph.RandomAdditions.init.ModBlocks;
import raph.RandomAdditions.init.ModEntities;
import raph.RandomAdditions.init.ModItems;
import raph.RandomAdditions.init.ModToolMaterials;
import raph.RandomAdditions.items.CustomAxeItem;
import raph.RandomAdditions.items.CustomPickaxeItem;
import raph.RandomAdditions.world.biomes.MagicalBiome;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModRegistries {
	
	private static final ItemGroup CUSTOMITEMGROUP = RandomAdditions.CUSTOMITEMGROUP;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		Item.Properties properties = new Item.Properties().group(CUSTOMITEMGROUP);
		
		event.getRegistry().registerAll(
			//Items
			ModItems.magical_ingot = new Item(properties).setRegistryName(location("magical_ingot")),
			ModItems.magical_blend = new Item(properties).setRegistryName(location("magical_blend")),
			ModItems.magical_dust = new Item(properties).setRegistryName(location("magical_dust")),
			
			//Tools
			ModItems.basic_magical_axe = new CustomAxeItem(ModToolMaterials.Basic_Magical_Tool, -1, -2.0f, properties).setRegistryName(location("basic_magical_axe")),
			ModItems.basic_magical_hoe = new HoeItem(ModToolMaterials.Basic_Magical_Tool, -1.0f, properties).setRegistryName(location("basic_magical_hoe")),
			ModItems.basic_magical_pickaxe = new CustomPickaxeItem(ModToolMaterials.Basic_Magical_Tool, -2, 1, properties).setRegistryName(location("basic_magical_pickaxe")),
			ModItems.basic_magical_shovel = new ShovelItem(ModToolMaterials.Basic_Magical_Tool, -3, -2, properties).setRegistryName(location("basic_magical_shovel")),
			ModItems.basic_magical_sword = new SwordItem(ModToolMaterials.Basic_Magical_Tool, 0, -2, properties).setRegistryName(location("basic_magical_sword")),
			
			//Armour
			ModItems.basic_magical_helmet = new ArmorItem(ModArmourMaterials.Basic_Magical_Armour, EquipmentSlotType.HEAD, properties).setRegistryName(location("basic_magical_helmet")),
			ModItems.basic_magical_chestplate = new ArmorItem(ModArmourMaterials.Basic_Magical_Armour, EquipmentSlotType.CHEST, properties).setRegistryName(location("basic_magical_chestplate")),
			ModItems.basic_magical_leggings = new ArmorItem(ModArmourMaterials.Basic_Magical_Armour, EquipmentSlotType.LEGS, properties).setRegistryName(location("basic_magical_leggings")),
			ModItems.basic_magical_boots = new ArmorItem(ModArmourMaterials.Basic_Magical_Armour, EquipmentSlotType.FEET, properties).setRegistryName(location("basic_magical_boots")),

			//Item Blocks
			ModItems.magical_block = new BlockItem(ModBlocks.magical_block, properties).setRegistryName(ModBlocks.magical_block.getRegistryName()),
			ModItems.magical_ore = new BlockItem(ModBlocks.magical_ore, properties).setRegistryName(ModBlocks.magical_ore.getRegistryName()),
		
			ModItems.magical_generator = new BlockItem(ModBlocks.magical_generator, properties).setRegistryName(ModBlocks.magical_generator.getRegistryName())
		);
		
		ModEntities.registerEntitySpawnEggs(event);
		
		RandomAdditions.LOGGER.info("Items registered");
	}
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
			ModBlocks.magical_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(6f, 40f).sound(SoundType.METAL).harvestLevel(2)).setRegistryName(location("magical_block")),
			ModBlocks.magical_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6f, 40f).sound(SoundType.METAL).harvestLevel(1)).setRegistryName(location("magical_ore")),
		
			ModBlocks.magical_generator = new MagicalGenerator()
		);
		RandomAdditions.LOGGER.info("Blocks registered");
	}
	@SubscribeEvent
	public static void registerEntityTiles(final RegistryEvent.Register<TileEntityType<?>> event) {
		event.getRegistry().registerAll(
			TileEntityType.Builder.create(MagicalGeneratorTile::new, ModBlocks.magical_generator).build(null).setRegistryName(ModBlocks.magical_generator.getRegistryName())
		);
	}
	@SubscribeEvent
	public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(
			ModEntities.MAGICAL_COW,
			ModEntities.MAGICAL_PIG
		);
		ModEntities.registerEntityWorldSpawns();
	}
	@SubscribeEvent
	public static void registerBiomes(final RegistryEvent.Register<Biome> event) {
		event.getRegistry().registerAll(
			ModBiomes.magical_biome = new MagicalBiome()
		);
		ModBiomes.registerBiomes();
	}
	
	public static ResourceLocation location(String name) {
		return new ResourceLocation(RandomAdditions.MODID, name);
	}
}
