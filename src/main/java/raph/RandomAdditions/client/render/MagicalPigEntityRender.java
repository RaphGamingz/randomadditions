package raph.RandomAdditions.client.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import raph.RandomAdditions.ModRegistries;
import raph.RandomAdditions.client.models.MagicalPigEntityModel;
import raph.RandomAdditions.entities.MagicalPig;

@OnlyIn(Dist.CLIENT)
public class MagicalPigEntityRender extends LivingRenderer<MagicalPig, MagicalPigEntityModel> {

	public MagicalPigEntityRender(EntityRendererManager manager) {
		super(manager, new MagicalPigEntityModel(), 0f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(MagicalPig entity) {
		return ModRegistries.location("textures/entity/magical_pig.png");
	}
}