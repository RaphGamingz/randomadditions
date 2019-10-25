package raph.RandomAdditions.items.floatingChest;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import raph.RandomAdditions.ModRegistries;

public class FloatingChestScreen extends ContainerScreen<FloatingChestContainer> {

	private ResourceLocation GUI = ModRegistries.location("textures/gui/floating_chest_gui.png");
	private final int inventoryRows;
	
	public FloatingChestScreen(FloatingChestContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
		this.inventoryRows = 3;
		this.ySize = 114 + this.inventoryRows * 18;
	}

	@Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
    	this.font.drawString("Floating Chest", 8.0F, 6.0F, 4210752);
    	this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F,(float) this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int relX = (this.width - this.xSize) / 2;
        int relY = (this.height - this.ySize) / 2;
        this.blit(relX, relY, 0, 0, this.xSize, this.ySize);
    }
}
