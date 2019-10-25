package raph.RandomAdditions.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ModFoods {
	   public static Food magical_apple = (new Food.Builder())
			   .hunger(2)
			   .saturation(1.2F)
			   .effect(new EffectInstance(Effects.REGENERATION, 600, 1), 1.0F)
			   .effect(new EffectInstance(Effects.RESISTANCE, 6000, 0), 1.0F)
			   .effect(new EffectInstance(Effects.FIRE_RESISTANCE, 6000, 0), 1.0F)
			   .effect(new EffectInstance(Effects.ABSORPTION, 2400, 3), 1.0F)
			   .effect(new EffectInstance(Effects.HEALTH_BOOST, 10000, 2), 1.0F)
			   .effect(new EffectInstance(Effects.LUCK, 1000, 1), 1.0F)
			   .effect(new EffectInstance(Effects.CONDUIT_POWER, 1000, 1), 1.0F)
			   .effect(new EffectInstance(Effects.DOLPHINS_GRACE, 1000, 1), 1.0F)
			   .effect(new EffectInstance(Effects.NIGHT_VISION, 1000, 2), 1.0F)
			   .effect(new EffectInstance(Effects.INVISIBILITY, 600, 1), 1.0F)
			   .effect(new EffectInstance(Effects.HASTE, 200, 1), 1.0F)
			   .setAlwaysEdible()
			   .fastToEat()
			   .build();
	   public static Food lolly = (new Food.Builder())
			   .hunger(0)
			   .saturation(0.1F)
			   .effect(new EffectInstance(Effects.SPEED, 10, 1), 1.0F)
			   .effect(new EffectInstance(Effects.STRENGTH, 10, 1), 1.0F)
			   .setAlwaysEdible()
			   .fastToEat()
			   .build();
	   public static Food coffee = (new Food.Builder())
			   .hunger(1)
			   .saturation(0.7F)
			   .effect(new EffectInstance(Effects.SPEED, 500, 1), 1.0F)
			   .effect(new EffectInstance(Effects.HASTE, 750, 1), 1.0F)
			   .effect(new EffectInstance(Effects.STRENGTH, 750, 1), 1.0F)
			   .effect(new EffectInstance(Effects.NIGHT_VISION, 750, 1), 1.0F)
			   .effect(new EffectInstance(Effects.NAUSEA, 5, 1), 1.0F)
			   .fastToEat()
			   .build();
}