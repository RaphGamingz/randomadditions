package raph.RandomAdditions.client.models;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import raph.RandomAdditions.entities.MagicalChest;

public class MagicalChestEntityModel extends EntityModel<MagicalChest> {
	
	public RendererModel body;

    public MagicalChestEntityModel() {
    	textureWidth = 64;
		textureHeight = 64;
		
        body = new RendererModel(this);
        body.cubeList.add(new ModelBox(body, 0, 19, -7.0F, -10.0F, -7.0F, 14, 10, 14, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 0, -7.0F, -15.0F, -7.0F, 14, 5, 14, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 0, -1.0F, -12.0F, -7.0F, 2, 4, 1, 0.0F, false));
    }

    @Override
    public void render(MagicalChest entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        body.render(scale);
    }
}