package raph.RandomAdditions.customBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import raph.RandomAdditions.ModRegistries;
import raph.RandomAdditions.init.ModDimensions;
import raph.RandomAdditions.tools.TeleportationTools;

public class FusionCore extends Block {

	public FusionCore() {
		super(Block.Properties
        		.create(Material.IRON)
        		.hardnessAndResistance(7f, 40f)
        		.sound(SoundType.METAL)
        		.harvestLevel(3)
        		.lightValue(8)
        );
        setRegistryName(ModRegistries.location("fusion_core"));
	}
	@SuppressWarnings("deprecation")
	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if (!worldIn.isRemote) {
			if (player.dimension.equals(ModDimensions.MAGICAL_DIM_TYPE)) {
	            TeleportationTools.teleportPlayer((ServerPlayerEntity) player, DimensionType.OVERWORLD, new BlockPos(player.posX, player.posY, player.posZ));
	        } else {
	            TeleportationTools.teleportPlayer((ServerPlayerEntity) player, ModDimensions.MAGICAL_DIM_TYPE, new BlockPos(player.posX, player.posY, player.posZ));
	        }
		}
		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}
}
