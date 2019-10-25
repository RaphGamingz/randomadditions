package raph.RandomAdditions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import raph.RandomAdditions.config.Config;
import raph.RandomAdditions.setup.ClientProxy;
import raph.RandomAdditions.setup.IProxy;
import raph.RandomAdditions.setup.ServerProxy;
import raph.RandomAdditions.world.gen.OreGeneration;

@Mod("randomadditionsraph")
public class RandomAdditions {
	public static RandomAdditions instance;
	public static final String MODID = "randomadditionsraph";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static final ItemGroup CUSTOMITEMGROUP = new CustomItemGroup();
	
	public static IProxy Proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
	
	public RandomAdditions() {
		instance = this;
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG, "randomadditionsraph-server.toml");
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG, "randomadditionsraph-client.toml");

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		Config.loadConfig(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("randomadditionsraph-client.toml").toString());
		Config.loadConfig(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("randomadditionsraph-server.toml").toString());
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		OreGeneration.setupOreGeneration();
		Proxy.init();
		LOGGER.info("setup method registered");
	}
	private void clientRegistries(final FMLClientSetupEvent event) {
		LOGGER.info("clientRegistries method registered");
	}	
}
