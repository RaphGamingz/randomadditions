package raph.RandomAdditions.customBlocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import raph.RandomAdditions.ModRegistries;

public class MagicalGenerator extends Block {
	
	public MagicalGenerator() {
        super(Block.Properties
        		.create(Material.IRON)
        		.hardnessAndResistance(6f, 40f)
        		.sound(SoundType.METAL)
        		.harvestLevel(2)
        );
        setRegistryName(ModRegistries.location("magical_generator"));
    }
	
	@Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new MagicalGeneratorTile();
    }
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
		if (entity != null) {
			world.setBlockState(pos, state.with(BlockStateProperties.FACING, getFacingFromEntity(pos, entity)), 2);
		}
	}
	
	public static Direction getFacingFromEntity(BlockPos clickedBlock, LivingEntity entity) {
		return Direction.getFacingFromVector(
				(float) (entity.posX - clickedBlock.getX()), 
				(float) (entity.posY - clickedBlock.getY()), 
				(float) (entity.posZ - clickedBlock.getZ())
		);
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.FACING);
    }
}