package raph.RandomAdditions.world.gen;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import raph.RandomAdditions.config.OregenConfig;
import raph.RandomAdditions.init.ModBlocks;

public class OreGeneration {
	public static void setupOreGeneration() {
		if (OregenConfig.generate_overworld.get()) {
			for (Biome biome : ForgeRegistries.BIOMES) {
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, ModBlocks.magical_ore.getDefaultState(), OregenConfig.chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(10, 20, 0, 100)));
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK, ModBlocks.magical_ore.getDefaultState(), OregenConfig.chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(10, 20, 0, 100)));
			}
		}
	}
}
