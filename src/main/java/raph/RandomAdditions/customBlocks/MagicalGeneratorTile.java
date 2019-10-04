package raph.RandomAdditions.customBlocks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import raph.RandomAdditions.init.ModBlocks;
import raph.RandomAdditions.init.ModItems;

public class MagicalGeneratorTile extends TileEntity implements ITickableTileEntity {

	//private LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);
	private ItemStackHandler handler;
	
	public MagicalGeneratorTile() {
		super(ModBlocks.magical_generator_tile);
	}

	@Override
	public void tick() {
		
	}

	@Override
    public void read(CompoundNBT tag) {
		CompoundNBT invTag = tag.getCompound("inv");
		getHandler().deserializeNBT(invTag);
        super.read(tag);
    }
	
    @Override
    public CompoundNBT write(CompoundNBT tag) {
    	CompoundNBT compound = getHandler().serializeNBT();
    	tag.put("inv", compound);
        return super.write(tag);
    }
    /*
    private IItemHandler createHandler() {
    	return new ItemStackHandler(1) {
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return stack.getItem() == ModItems.magical_dust;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (stack.getItem() != ModItems.magical_dust) {
                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
            }
        };
    }*/
    
    private ItemStackHandler getHandler() {
    	if (handler == null) {
    		handler = new ItemStackHandler(1) {
    			@Override
    			public boolean isItemValid(int slot, ItemStack stack) {
    				return stack.getItem() == ModItems.magical_dust;
    			}
    			
    			@Nonnull
                @Override
                public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                    if (stack.getItem() != ModItems.magical_dust) {
                        return stack;
                    }
                    return super.insertItem(slot, stack, simulate);
                }
    		};
    	}
    	return handler;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return LazyOptional.of(() -> (T) getHandler());
        }
        return super.getCapability(cap, side);
    }
}
