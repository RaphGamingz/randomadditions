package raph.RandomAdditions.init;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;
import raph.RandomAdditions.customBlocks.MagicalGenerator;
import raph.RandomAdditions.customBlocks.MagicalGeneratorTile;

public class ModBlocks {
	public static Block magical_block;
	public static Block magical_ore;
	
	public static MagicalGenerator magical_generator;
	
	@ObjectHolder("randomadditionsraph:magical_generator")
	public static TileEntityType<MagicalGeneratorTile> magical_generator_tile;
}