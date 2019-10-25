package raph.RandomAdditions.customBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import raph.RandomAdditions.ModRegistries;
import raph.RandomAdditions.init.ModEntities;
import raph.RandomAdditions.init.ModItems;

public class TerraAltar extends Block {

	public TerraAltar() {
		super(Block.Properties
        		.create(Material.ROCK)
        		.hardnessAndResistance(6f, 40f)
        		.sound(SoundType.STONE)
        		.harvestLevel(3)
        		.lightValue(8)
        );
        setRegistryName(ModRegistries.location("terra_altar"));
	}
	@SuppressWarnings("deprecation")
	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		ItemStack item = player.getHeldItem(handIn);
		if (item.getItem() == ModItems.magical_dust) {
			if (!worldIn.isRemote) {
				if (player.getHeldItem(handIn).getStack().getCount() >= 3) {
					player.getHeldItem(handIn).getStack().setCount(player.getHeldItem(handIn).getStack().getCount() - 3);
					ModEntities.TERRA_SPIRIT.spawn(worldIn, null, null, pos.add(0, 1, 1), SpawnReason.REINFORCEMENT, false, false);
					ModEntities.TERRA_SPIRIT.spawn(worldIn, null, null, pos.add(1, 1, 0), SpawnReason.REINFORCEMENT, false, false);
					ModEntities.TERRA_SPIRIT.spawn(worldIn, null, null, pos.add(-1, 1, -1), SpawnReason.REINFORCEMENT, false, false);
				}
			}
		}
		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}
}
