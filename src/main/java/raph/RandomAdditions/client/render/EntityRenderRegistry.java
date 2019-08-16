package raph.RandomAdditions.client.render;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import raph.RandomAdditions.entities.MagicalCow;
import raph.RandomAdditions.entities.MagicalPig;

@OnlyIn(Dist.CLIENT)
public class EntityRenderRegistry {
	public static void registryEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(MagicalCow.class, new MagicalCowEntityRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(MagicalPig.class, new MagicalPigEntityRender.RenderFactory());
	}
}
