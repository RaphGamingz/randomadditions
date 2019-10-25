package raph.RandomAdditions.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import raph.RandomAdditions.init.ModEntities;

public class TerraSpirit extends MonsterEntity {

	@SuppressWarnings("unchecked")
	public TerraSpirit(EntityType<? extends MonsterEntity> type, World worldIn) {
		super((EntityType<? extends MonsterEntity>) ModEntities.TERRA_SPIRIT, worldIn);
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
	    this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.0D, 0.0F));
	    this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 8.0F));
	    this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
	    this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
	      this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
	      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.23F);
	      this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(48.0D);
	}
	
	@Override
	public float getBrightness() {
		return 1.0F;
	}
	
	@Override
	public void livingTick() {
		if (!this.onGround && this.getMotion().y < 0.0D) {
	    	this.setMotion(this.getMotion().mul(1.0D, 0.6D, 1.0D));
		}

		if (this.world.isRemote) {
			this.world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.getWidth(), this.posY + this.rand.nextDouble() * (double)this.getHeight(), this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.getWidth(), 0.0D, -0.1D, 0.0D);
		}
		super.livingTick();
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (!super.attackEntityAsMob(entityIn)) {
			return false;
		} else {
			if (entityIn instanceof LivingEntity) {
				((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.POISON, 200));
			}
			return true;
		}
	}
	
	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.BLOCK_METAL_BREAK;
	}
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.BLOCK_METAL_HIT;
	}
}