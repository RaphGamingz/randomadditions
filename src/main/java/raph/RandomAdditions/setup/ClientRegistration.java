package raph.RandomAdditions.setup;

import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import raph.RandomAdditions.ModRegistries;
import raph.RandomAdditions.RandomAdditions;
import raph.RandomAdditions.customBlocks.ghostBlock.GhostBlockBakedModel;
import raph.RandomAdditions.init.ModBlocks;

@Mod.EventBusSubscriber(modid = RandomAdditions.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegistration {
	
	@SubscribeEvent
	public static void onTextureStitch(TextureStitchEvent.Pre event) {
		if (!event.getMap().getBasePath().equals("textures")) {
			return;
		}
		event.addSprite(ModRegistries.location("blocks/ghost_block"));
	}
	
	@SubscribeEvent
	public static void onModelBake(ModelBakeEvent event) {
		event.getModelRegistry().put(new ModelResourceLocation(ModBlocks.ghost_block.getRegistryName(), ""),
				new GhostBlockBakedModel(DefaultVertexFormats.BLOCK));
		event.getModelRegistry().put(new ModelResourceLocation(ModBlocks.ghost_block.getRegistryName(), "inventory"),
				new GhostBlockBakedModel(DefaultVertexFormats.ITEM));
	}
}