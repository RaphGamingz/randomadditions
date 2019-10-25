package raph.RandomAdditions.customBlocks.magicalGenerator;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import raph.RandomAdditions.ModRegistries;

public class MagicalGenerator extends Block {
	
	public MagicalGenerator() {
        super(Block.Properties
        		.create(Material.IRON)
        		.hardnessAndResistance(6f, 40f)
        		.sound(SoundType.METAL)
        		.harvestLevel(2)
        		.lightValue(14)
        );
        setRegistryName(ModRegistries.location("magical_generator"));
    }
	
	@Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

	@SuppressWarnings("deprecation")
	@Override
	public int getLightValue(BlockState state) {
		return state.get(BlockStateProperties.POWERED) ? super.getLightValue(state) : 0;
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
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if (!world.isRemote) {
			TileEntity tileEntity = world.getTileEntity(pos);
			if (tileEntity instanceof INamedContainerProvider) {
				NetworkHooks.openGui((ServerPlayerEntity) player,(INamedContainerProvider) tileEntity, tileEntity.getPos());
			} else {
                throw new IllegalStateException("Our named container provider is missing!");
            }
			return true;
		}
		return super.onBlockActivated(state, world, pos, player, handIn, hit);
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
        builder.add(BlockStateProperties.FACING, BlockStateProperties.POWERED);
    }
}