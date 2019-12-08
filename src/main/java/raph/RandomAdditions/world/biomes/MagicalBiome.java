package raph.RandomAdditions.world.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import raph.RandomAdditions.ModRegistries;
import raph.RandomAdditions.init.ModBlocks;
import raph.RandomAdditions.init.ModEntities;

public class MagicalBiome extends Biome {

	public MagicalBiome() {
		super((new Biome.Builder())
			.surfaceBuilder(new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.STONE.getDefaultState(), ModBlocks.magical_ore.getDefaultState())))
			.category(Category.PLAINS)
			.scale(0.2f)
			.precipitation(RainType.SNOW)
			.downfall(0.3f)
			.depth(0.2f)
			.temperature(0.8f)
			.waterColor(0x479dff)
			.waterFogColor(0x479dff)
			.parent(null)
		);
		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addOres(this);
		
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(ModEntities.MAGICAL_COW, 200, 2, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(ModEntities.MAGICAL_PIG, 200, 2, 10));

		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 4, 4));
	
		this.setRegistryName(ModRegistries.location("magical_biome"));
	}
}
