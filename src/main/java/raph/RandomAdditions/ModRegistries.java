package raph.RandomAdditions;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import raph.RandomAdditions.customBlocks.Bounctium;
import raph.RandomAdditions.customBlocks.FusionCore;
import raph.RandomAdditions.customBlocks.TerraAltar;
import raph.RandomAdditions.customBlocks.ghostBlock.GhostBlock;
import raph.RandomAdditions.customBlocks.ghostBlock.GhostBlockTile;
import raph.RandomAdditions.customBlocks.magicalGenerator.MagicalGenerator;
import raph.RandomAdditions.customBlocks.magicalGenerator.MagicalGeneratorContainer;
import raph.RandomAdditions.customBlocks.magicalGenerator.MagicalGeneratorTile;
import raph.RandomAdditions.customBlocks.magicalStorageChest.StorageChest;
import raph.RandomAdditions.customBlocks.magicalStorageChest.StorageChestContainer;
import raph.RandomAdditions.customBlocks.magicalStorageChest.StorageChestTile;
import raph.RandomAdditions.dimension.MagicalModDimension;
import raph.RandomAdditions.init.ModArmourMaterials;
import raph.RandomAdditions.init.ModBiomes;
import raph.RandomAdditions.init.ModBlocks;
import raph.RandomAdditions.init.ModDimensions;
import raph.RandomAdditions.init.ModEntities;
import raph.RandomAdditions.init.ModFoods;
import raph.RandomAdditions.init.ModItems;
import raph.RandomAdditions.init.ModToolMaterials;
import raph.RandomAdditions.items.CustomAxeItem;
import raph.RandomAdditions.items.CustomPickaxeItem;
import raph.RandomAdditions.items.CustomShieldItem;
import raph.RandomAdditions.items.InvisibilityCloak;
import raph.RandomAdditions.items.ToolTippedItem;
import raph.RandomAdditions.items.floatingChest.FloatingChest;
import raph.RandomAdditions.items.floatingChest.FloatingChestContainer;
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
			
			ModItems.terra_drop = new ToolTippedItem(properties, "Very Terraful", "Or Is It", "Very Terrable").setRegistryName(location("terra_drop")),
			ModItems.terrasteel = new Item(properties).setRegistryName(location("terrasteel")),
			
			ModItems.pig_iron = new Item(properties).setRegistryName(location("pig_iron")),
			ModItems.coal_dust = new Item(properties).setRegistryName(location("coal_dust")),

			//Food
			ModItems.magical_apple = new Item(properties.food(ModFoods.magical_apple)).setRegistryName("magical_apple"),
			ModItems.candy = new Item(properties.food(ModFoods.lolly)).setRegistryName("candy"),
			ModItems.coffee = new Item(properties.food(ModFoods.coffee)).setRegistryName("coffee"),
	
			//Tools
			ModItems.basic_magical_axe = new CustomAxeItem(ModToolMaterials.Basic_Magical_Tool, -1, -2.0f, properties).setRegistryName(location("basic_magical_axe")),
			ModItems.basic_magical_hoe = new HoeItem(ModToolMaterials.Basic_Magical_Tool, -1.0f, properties).setRegistryName(location("basic_magical_hoe")),
			ModItems.basic_magical_pickaxe = new CustomPickaxeItem(ModToolMaterials.Basic_Magical_Tool, -2, 1, properties).setRegistryName(location("basic_magical_pickaxe")),
			ModItems.basic_magical_shovel = new ShovelItem(ModToolMaterials.Basic_Magical_Tool, -3, -2, properties).setRegistryName(location("basic_magical_shovel")),
			ModItems.basic_magical_sword = new SwordItem(ModToolMaterials.Basic_Magical_Tool, 0, -2, properties).setRegistryName(location("basic_magical_sword")),
			
			ModItems.terra_axe = new CustomAxeItem(ModToolMaterials.Terra_Tool, -1, -2.0f, properties).setRegistryName(location("terra_axe")),
			ModItems.terra_hoe = new HoeItem(ModToolMaterials.Terra_Tool, -1.0f, properties).setRegistryName(location("terra_hoe")),
			ModItems.terra_pickaxe = new CustomPickaxeItem(ModToolMaterials.Terra_Tool, -2, 1, properties).setRegistryName(location("terra_pickaxe")),
			ModItems.terra_shovel = new ShovelItem(ModToolMaterials.Terra_Tool, -3, -2, properties).setRegistryName(location("terra_shovel")),
			ModItems.terra_sword = new SwordItem(ModToolMaterials.Terra_Tool, 0, -2, properties).setRegistryName(location("terra_sword")),
			
			ModItems.magical_shield = new CustomShieldItem(properties, 500, ModItems.magical_dust).setRegistryName(location("magical_shield")),
			
			//Armour
			ModItems.basic_magical_helmet = new ArmorItem(ModArmourMaterials.Basic_Magical_Armour, EquipmentSlotType.HEAD, properties).setRegistryName(location("basic_magical_helmet")),
			ModItems.basic_magical_chestplate = new ArmorItem(ModArmourMaterials.Basic_Magical_Armour, EquipmentSlotType.CHEST, properties).setRegistryName(location("basic_magical_chestplate")),
			ModItems.basic_magical_leggings = new ArmorItem(ModArmourMaterials.Basic_Magical_Armour, EquipmentSlotType.LEGS, properties).setRegistryName(location("basic_magical_leggings")),
			ModItems.basic_magical_boots = new ArmorItem(ModArmourMaterials.Basic_Magical_Armour, EquipmentSlotType.FEET, properties).setRegistryName(location("basic_magical_boots")),
			
			ModItems.terra_helmet = new ArmorItem(ModArmourMaterials.Terra_Armour, EquipmentSlotType.HEAD, properties).setRegistryName(location("terra_helmet")),
			ModItems.terra_chestplate = new ArmorItem(ModArmourMaterials.Terra_Armour, EquipmentSlotType.CHEST, properties).setRegistryName(location("terra_chestplate")),
			ModItems.terra_leggings = new ArmorItem(ModArmourMaterials.Terra_Armour, EquipmentSlotType.LEGS, properties).setRegistryName(location("terra_leggings")),
			ModItems.terra_boots = new ArmorItem(ModArmourMaterials.Terra_Armour, EquipmentSlotType.FEET, properties).setRegistryName(location("terra_boots")),
			
			ModItems.invisiblity_cloak = new InvisibilityCloak(),
			
			//Item Blocks
			ModItems.magical_block = new BlockItem(ModBlocks.magical_block, properties).setRegistryName(ModBlocks.magical_block.getRegistryName()),
			ModItems.magical_ore = new BlockItem(ModBlocks.magical_ore, properties).setRegistryName(ModBlocks.magical_ore.getRegistryName()),
			
			ModItems.terra_altar = new BlockItem(ModBlocks.terra_altar, properties).setRegistryName(ModBlocks.terra_altar.getRegistryName()),
			ModItems.bounctium = new BlockItem(ModBlocks.bounctium, properties).setRegistryName(ModBlocks.bounctium.getRegistryName()),
			
			ModItems.magical_generator = new BlockItem(ModBlocks.magical_generator, properties).setRegistryName(ModBlocks.magical_generator.getRegistryName()),
			ModItems.magical_storage_chest = new BlockItem(ModBlocks.magical_storage_chest, properties).setRegistryName(ModBlocks.magical_storage_chest.getRegistryName()),
			
			ModItems.ghost_block = new BlockItem(ModBlocks.ghost_block, properties).setRegistryName(ModBlocks.ghost_block.getRegistryName()),
			
			//Custom Item
			ModItems.floating_chest = new FloatingChest()
		);
		
		ModEntities.registerEntitySpawnEggs(event);
		
		RandomAdditions.LOGGER.info("Items registered");
	}
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
			ModBlocks.magical_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(6f, 40f).sound(SoundType.METAL).harvestLevel(2)).setRegistryName(location("magical_block")),
			ModBlocks.magical_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6f, 40f).sound(SoundType.METAL).harvestLevel(1)).setRegistryName(location("magical_ore")),
			
			ModBlocks.terra_altar = new TerraAltar(),
			ModBlocks.bounctium = new Bounctium(),
			ModBlocks.fusion_core = new FusionCore(),
		
			ModBlocks.magical_generator = new MagicalGenerator(),
			ModBlocks.magical_storage_chest = new StorageChest(),
			
			ModBlocks.ghost_block = new GhostBlock()
		);
		RandomAdditions.LOGGER.info("Blocks registered");
	}
	@SubscribeEvent
	public static void registerEntityTiles(final RegistryEvent.Register<TileEntityType<?>> event) {
		event.getRegistry().registerAll(
			TileEntityType.Builder.create(MagicalGeneratorTile::new, ModBlocks.magical_generator).build(null).setRegistryName(ModBlocks.magical_generator.getRegistryName()),
			TileEntityType.Builder.create(StorageChestTile::new, ModBlocks.magical_storage_chest).build(null).setRegistryName(ModBlocks.magical_storage_chest.getRegistryName()),
			TileEntityType.Builder.create(GhostBlockTile::new, ModBlocks.ghost_block).build(null).setRegistryName(ModBlocks.ghost_block.getRegistryName())
		);
	}
	@SubscribeEvent
	public static void registerContainers(final RegistryEvent.Register<ContainerType<?>> event) {
		event.getRegistry().registerAll(
			IForgeContainerType.create((windowId, inv, data) -> {
				BlockPos pos = data.readBlockPos();
				return new MagicalGeneratorContainer(windowId, RandomAdditions.Proxy.getClientWorld(), pos, inv, RandomAdditions.Proxy.getClientPlayer());
			}).setRegistryName(ModBlocks.magical_generator.getRegistryName()),
			IForgeContainerType.create((windowId, inv, data) -> {
				BlockPos pos = data.readBlockPos();
				return new StorageChestContainer(windowId, RandomAdditions.Proxy.getClientWorld(), pos, inv, RandomAdditions.Proxy.getClientPlayer());
			}).setRegistryName(ModBlocks.magical_storage_chest.getRegistryName()),
			IForgeContainerType.create((windowId, inv, data) -> {
				return new FloatingChestContainer(windowId, inv, RandomAdditions.Proxy.getClientPlayer());
			}).setRegistryName(ModItems.floating_chest.getRegistryName())
		);
	}
	@SubscribeEvent
	public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(
			ModEntities.MAGICAL_COW,
			ModEntities.MAGICAL_PIG,
			ModEntities.MAGICAL_CHEST,
			ModEntities.TERRA_SPIRIT
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
	
	@SubscribeEvent
    public static void registerModDimensions(final RegistryEvent.Register<ModDimension> event) {
        event.getRegistry().register(new MagicalModDimension().setRegistryName(ModDimensions.DIMENSION_ID));
    }
	
	public static ResourceLocation location(String name) {
		return new ResourceLocation(RandomAdditions.MODID, name);
	}
}
