package raph.RandomAdditions.setup;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ServerProxy implements IProxy {

	@Override
	public void init() {

	}
	
	@Override
	public World getClientWorld() {
		throw new IllegalStateException("Only run the method: getClientWorld on the client!");
	}

	@Override
	public PlayerEntity getClientPlayer() {
		throw new IllegalStateException("Only run the method: getClientPlayer on the client!");
	}
}
