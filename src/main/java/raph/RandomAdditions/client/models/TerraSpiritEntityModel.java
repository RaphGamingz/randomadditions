package raph.RandomAdditions.client.models;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import raph.RandomAdditions.entities.TerraSpirit;

public class TerraSpiritEntityModel extends EntityModel<TerraSpirit> {
	private final RendererModel main;

	public TerraSpiritEntityModel() {
		textureWidth = 16;
		textureHeight = 16;

		main = new RendererModel(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);
		main.cubeList.add(new ModelBox(main, 0, 0, -5.0F, -11.0F, 0.0F, 5, 8, 3, 0.0F, false));
		main.cubeList.add(new ModelBox(main, 0, 11, -4.0F, -3.0F, 0.0F, 3, 1, 3, 0.0F, false));
		main.cubeList.add(new ModelBox(main, 9, 11, -3.0F, -2.0F, 1.0F, 1, 1, 1, 0.0F, false));
	}

	@Override
	public void render(TerraSpirit entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		main.render(scale);
	}
}