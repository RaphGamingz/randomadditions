package raph.RandomAdditions.init;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.event.RegistryEvent;
import raph.RandomAdditions.ModRegistries;
import raph.RandomAdditions.RandomAdditions;
import raph.RandomAdditions.entities.MagicalCow;
import raph.RandomAdditions.entities.MagicalPig;

public class ModEntities {
	public static EntityType<?> MAGICAL_COW = EntityType.Builder.create(MagicalCow::new, EntityClassification.CREATURE).build(RandomAdditions.MODID + ":magical_cow").setRegistryName(ModRegistries.location("magical_cow"));
	public static EntityType<?> MAGICAL_PIG = EntityType.Builder.create(MagicalPig::new, EntityClassification.CREATURE).build(RandomAdditions.MODID + ":magical_pig").setRegistryName(ModRegistries.location("magical_pig"));

	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
			ModItems.magical_cow_egg = registerEntitySpawnEgg(MAGICAL_COW, 0x0077ff, 0x7fbbff, "magical_cow_egg"),
			ModItems.magical_pig_egg = registerEntitySpawnEgg(MAGICAL_PIG, 0xadadad, 0x03bafc, "magical_pig_egg")
		);
	}
	
	public static void registerEntityWorldSpawns() {
		registerEntityWorldSpawn(MAGICAL_COW,
				Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, 
				Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.FLOWER_FOREST, 
				Biomes.JUNGLE, Biomes.BAMBOO_JUNGLE, 
				Biomes.TAIGA, Biomes.MOUNTAINS);
		registerEntityWorldSpawn(MAGICAL_PIG,
				Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, 
				Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.FLOWER_FOREST, 
				Biomes.JUNGLE, Biomes.BAMBOO_JUNGLE, 
				Biomes.TAIGA, Biomes.MOUNTAINS);
	}
	
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name) {
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(RandomAdditions.CUSTOMITEMGROUP));
		item.setRegistryName(ModRegistries.location(name));
		return item;
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, Biome... biomes) {
		for (Biome biome : biomes) {
			if (biome != null) {
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, 10, 1, 10));
			}
		}
	}
}
