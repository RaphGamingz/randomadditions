package raph.RandomAdditions.entities;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import raph.RandomAdditions.init.ModEntities;

public class MagicalChest extends CreatureEntity {

	@SuppressWarnings("unchecked")
	public MagicalChest(EntityType<? extends CreatureEntity> type, World worldIn) {
		super((EntityType<? extends CreatureEntity>) ModEntities.MAGICAL_CHEST, worldIn);
	}
	
	@Override
	protected void registerGoals() {
		
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0d);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1d);
	}
}