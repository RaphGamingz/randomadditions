package raph.RandomAdditions.init;

import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;
import raph.RandomAdditions.customBlocks.ghostBlock.GhostBlock;
import raph.RandomAdditions.customBlocks.magicalGenerator.MagicalGenerator;
import raph.RandomAdditions.customBlocks.magicalGenerator.MagicalGeneratorContainer;
import raph.RandomAdditions.customBlocks.magicalGenerator.MagicalGeneratorTile;
import raph.RandomAdditions.customBlocks.magicalStorageChest.StorageChest;
import raph.RandomAdditions.customBlocks.magicalStorageChest.StorageChestContainer;
import raph.RandomAdditions.customBlocks.magicalStorageChest.StorageChestTile;

public class ModBlocks {
	public static Block magical_block;
	public static Block magical_ore;
	
	public static Block terra_altar;
	public static Block bounctium;
	
	public static MagicalGenerator magical_generator;
	@ObjectHolder("randomadditionsraph:magical_generator")
	public static TileEntityType<MagicalGeneratorTile> magical_generator_tile;
	@ObjectHolder("randomadditionsraph:magical_generator")
	public static ContainerType<MagicalGeneratorContainer> magical_generator_container;
	
	public static StorageChest magical_storage_chest;
	@ObjectHolder("randomadditionsraph:magical_storage_chest")
	public static TileEntityType<StorageChestTile> magical_storage_chest_tile;
	@ObjectHolder("randomadditionsraph:magical_storage_chest")
	public static ContainerType<StorageChestContainer> magical_storage_chest_container;
	
	public static GhostBlock ghost_block;
	@ObjectHolder("randomadditionsraph:ghost_block")
	public static TileEntityType<StorageChestTile> ghost_block_tile;
}