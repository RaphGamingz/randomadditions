package raph.RandomAdditions.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class PowerConfig {
	public static ForgeConfigSpec.IntValue mag_gen_maxpower;
	public static ForgeConfigSpec.IntValue mag_gen_generate;
	public static ForgeConfigSpec.IntValue mag_gen_send;
	public static ForgeConfigSpec.IntValue mag_gen_ticks;

	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
		server.comment("Magical Generator Settings");
		mag_gen_maxpower = server
				.comment("Maximum power generator can hold")
				.defineInRange("power.magical_generator_maxpower", 10000, 0, Integer.MAX_VALUE);
		mag_gen_generate = server
				.comment("Power Generated per tick for the generator")
				.defineInRange("power.magical_generator_generate", 8, 1, 1000);
		mag_gen_send = server
				.comment("Power sent per tick")
				.defineInRange("power.magical_generator_send", 100, 0, 10000);
		mag_gen_ticks = server
				.comment("Ticks per magical dust. Total amount of power generated = generated * ticks")
				.defineInRange("power.magical_generator_ticks", 100, 1, 1000);
	}
}
