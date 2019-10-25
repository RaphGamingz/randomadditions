package raph.RandomAdditions.customBlocks.magicalGenerator;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import raph.RandomAdditions.ModRegistries;

public class MagicalGeneratorScreen extends ContainerScreen<MagicalGeneratorContainer> {

	private ResourceLocation GUI = ModRegistries.location("textures/gui/generator_gui.png");
	
	public MagicalGeneratorScreen(MagicalGeneratorContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
	}

	@Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
    	this.font.drawString("Magical Generator", 8.0F, 6.0F, 4210752);
    	this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F,(float) this.ySize - 96 + 2, 4210752);
    	drawString(Minecraft.getInstance().fontRenderer, "Energy: " + container.getEnergy(), 8, 48, 0xffffff);
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
