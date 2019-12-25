package raph.RandomAdditions.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OregenConfig {
	public static ForgeConfigSpec.IntValue chance;
	public static ForgeConfigSpec.BooleanValue generate_overworld;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
		server.comment("Oregen Config");
		
		chance = server
				.comment("Maximum number of ore veins of magical ore that can spawn in one chunk")
				.defineInRange("oregen.chance", 20, 1, 40);
		generate_overworld = server
				.comment("Decide if you want magical ore to spawn in the overworld")
				.define("oregen.generate_overworld", true);
	}
}
