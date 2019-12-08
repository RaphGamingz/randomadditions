package raph.RandomAdditions.customBlocks.ghostBlock;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class GhostBlock extends Block {

	private final VoxelShape shape = VoxelShapes.create(0, 0, 0, 0, 0, 0);

	public GhostBlock() {
		super(Properties.create(Material.AIR).hardnessAndResistance(2.0f));
		setRegistryName("ghost_block");
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
		return shape;
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new GhostBlockTile();
	}

	@Override
	public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
			BlockRayTraceResult result) {
		ItemStack item = player.getHeldItem(hand);
		if (!item.isEmpty() && item.getItem() instanceof BlockItem) {
			if (!world.isRemote) {
				TileEntity te = world.getTileEntity(pos);
				if (te instanceof GhostBlockTile) {
					BlockState mimicState = ((BlockItem) item.getItem()).getBlock().getDefaultState();
					((GhostBlockTile) te).setMimic(mimicState);
				}
			}
			return true;
		}
		return super.onBlockActivated(state, world, pos, player, hand, result);
	}
}