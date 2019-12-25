package raph.RandomAdditions;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import raph.RandomAdditions.init.ModItems;
import raph.RandomAdditions.network.Networking;
import raph.RandomAdditions.setup.ForgeEventHandlers;

public class ModSetup {
	
	public ItemGroup itemGroup = new ItemGroup("Random Additions") {
		@Override
		public ItemStack createIcon() { 
			return new ItemStack(ModItems.magical_ingot); 
		}
	};
	
	public void init() {
		MinecraftForge.EVENT_BUS.register(new ForgeEventHandlers());
		Networking.registerMessages();
	}
}