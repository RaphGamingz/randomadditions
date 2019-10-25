package raph.RandomAdditions.client.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import raph.RandomAdditions.ModRegistries;
import raph.RandomAdditions.client.models.MagicalChestEntityModel;
import raph.RandomAdditions.entities.MagicalChest;

@OnlyIn(Dist.CLIENT)
public class MagicalChestEntityRender extends LivingRenderer<MagicalChest, MagicalChestEntityModel> {

	public MagicalChestEntityRender(EntityRendererManager manager) {
		super(manager, new MagicalChestEntityModel(), 0f);
	}

	@Override
	protected ResourceLocation getEntityTexture(MagicalChest entity) {
		return ModRegistries.location("textures/entity/magical_chest.png");
	}
}