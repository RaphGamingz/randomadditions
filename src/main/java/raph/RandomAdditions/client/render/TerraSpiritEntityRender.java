package raph.RandomAdditions.client.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import raph.RandomAdditions.ModRegistries;
import raph.RandomAdditions.client.models.TerraSpiritEntityModel;
import raph.RandomAdditions.entities.TerraSpirit;

@OnlyIn(Dist.CLIENT)
public class TerraSpiritEntityRender extends LivingRenderer<TerraSpirit, TerraSpiritEntityModel> {

	public TerraSpiritEntityRender(EntityRendererManager manager) {
		super(manager, new TerraSpiritEntityModel(), 0f);
	}

	@Override
	protected ResourceLocation getEntityTexture(TerraSpirit entity) {
		return ModRegistries.location("textures/entity/terra_spirit.png");
	}
}