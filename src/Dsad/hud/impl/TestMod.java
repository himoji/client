package Dsad.hud.impl;

import Dsad.hud.Mod;
import net.minecraft.client.Minecraft;

public class TestMod extends Mod {

    private int centerX;
    public int startX;
    public int startY;

    public TestMod(Minecraft mc) {
        super();
    }

    @Override
    public void render(int scaledWidth) {
        this.centerX = scaledWidth / 2 + this.offX;
        int posX = (int) (this.centerX - 2.0D);
        int posY = this.offY + this.height() / 2 - (int) (2.0D);
        Minecraft.getMinecraft().fontRendererObj.drawString("TESTMOD", posX + 2, posY + 3, -1);
        this.posX = posX;
        this.posY = posY;
        this.startX = posX;
        this.startY = posY;
    }

    @Override
    public int width() {
        return Minecraft.getMinecraft().fontRendererObj.getStringWidth("TESTMOD");
    }

    @Override
    public int height() {
        return Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT + 2;
    }
}