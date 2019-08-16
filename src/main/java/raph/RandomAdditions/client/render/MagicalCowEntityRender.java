package raph.RandomAdditions.client.render;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import raph.RandomAdditions.ModRegistries;
import raph.RandomAdditions.client.models.MagicalCowEntityModel;
import raph.RandomAdditions.entities.MagicalCow;

@OnlyIn(Dist.CLIENT)
public class MagicalCowEntityRender extends LivingRenderer<MagicalCow, MagicalCowEntityModel> {

	public MagicalCowEntityRender(EntityRendererManager manager) {
		super(manager, new MagicalCowEntityModel(), 0f);
	}

	@Override
	protected ResourceLocation getEntityTexture(MagicalCow entity) {
		return ModRegistries.location("textures/entity/magical_cow.png");
	}
	
	public static class RenderFactory implements IRenderFactory<MagicalCow>{
		@Override
		public EntityRenderer<? super MagicalCow> createRenderFor(EntityRendererManager manager) {
			return new MagicalCowEntityRender(manager);
		}
	}
}