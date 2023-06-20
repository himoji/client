package Dsad.hud;

import java.io.IOException;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.Minecraft;

public class Hud extends GuiScreen {

    private int lastX;
    private int lastY;
    private boolean dragging;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        for (Mod mod : Mods.listOfMods) {
            mod.render(new ScaledResolution(Minecraft.getMinecraft()).getScaledWidth());
            if (this.dragging) {
                mod.offX += mouseX - this.lastX;
                mod.offY += mouseY - this.lastY;
            }
            this.lastX = mouseX;
            this.lastY = mouseY;
        }
    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        for (Mod mod : Mods.listOfMods) {
            if (mouseX >= (this.width - mod.width()) / 2 + mod.offX && mouseY >= mod.offY && mouseX <= (width + mod.width()) / 2 + mod.offX && mouseY <= mod.offY + mod.height()) {
                this.dragging = true;
                this.lastX = mouseX;
                this.lastY = mouseY;
            }
        }
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
        this.dragging = false;
    }
}
