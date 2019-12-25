package raph.RandomAdditions.setup;

import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import raph.RandomAdditions.commands.ModCommands;
import raph.RandomAdditions.init.ModDimensions;

public class ForgeEventHandlers {

	@SubscribeEvent
	public void serverload(FMLServerStartingEvent event) {
		ModCommands.register(event.getCommandDispatcher());
	}
	
	@SubscribeEvent
	public void onDimensionRegistry(RegisterDimensionsEvent event) {
		if (DimensionType.byName(ModDimensions.DIMENSION_ID) == null) {
			ModDimensions.MAGICAL_DIM_TYPE = DimensionManager.registerDimension(ModDimensions.DIMENSION_ID, ModDimensions.MAGICAL_DIM, null, true);
		}
	}
}