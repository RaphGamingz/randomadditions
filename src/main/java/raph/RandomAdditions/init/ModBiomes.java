package raph.RandomAdditions.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;

public class ModBiomes {
	public static Biome magical_biome;
	
	public static void registerBiomes() {
		registerBiome(magical_biome, Type.PLAINS, Type.RARE);
	}
	
	public static void registerBiome(Biome biome, Type... types) {
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}
}
