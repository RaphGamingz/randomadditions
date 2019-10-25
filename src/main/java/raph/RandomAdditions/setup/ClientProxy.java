package raph.RandomAdditions.setup;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import raph.RandomAdditions.client.render.MagicalChestEntityRender;
import raph.RandomAdditions.client.render.MagicalCowEntityRender;
import raph.RandomAdditions.client.render.MagicalPigEntityRender;
import raph.RandomAdditions.client.render.TerraSpiritEntityRender;
import raph.RandomAdditions.customBlocks.magicalGenerator.MagicalGeneratorScreen;
import raph.RandomAdditions.customBlocks.magicalStorageChest.StorageChestScreen;
import raph.RandomAdditions.entities.MagicalChest;
import raph.RandomAdditions.entities.MagicalCow;
import raph.RandomAdditions.entities.MagicalPig;
import raph.RandomAdditions.entities.TerraSpirit;
import raph.RandomAdditions.init.ModBlocks;
import raph.RandomAdditions.init.ModItems;
import raph.RandomAdditions.items.floatingChest.FloatingChestScreen;
public class ClientProxy implements IProxy {
	@Override
	public void init() {
		ScreenManager.registerFactory(ModBlocks.magical_generator_container, MagicalGeneratorScreen::new);
		ScreenManager.registerFactory(ModBlocks.magical_storage_chest_container, StorageChestScreen::new);
		ScreenManager.registerFactory(ModItems.floating_chest_container, FloatingChestScreen::new);
		
		RenderingRegistry.registerEntityRenderingHandler(MagicalCow.class, MagicalCowEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(MagicalPig.class, MagicalPigEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(MagicalChest.class, MagicalChestEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(TerraSpirit.class, TerraSpiritEntityRender::new);
	}
	@Override
	public World getClientWorld() {
		return Minecraft.getInstance().world;
	}

	@Override
	public PlayerEntity getClientPlayer() {
		return Minecraft.getInstance().player;
	}

}
