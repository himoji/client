package Dsad.hud;

import net.minecraft.client.gui.Gui;

public abstract class Mod {
    protected int posX;
    protected int posY;
    protected int offY;
    protected int offX;

    public void render(int scaledWidth) {
    }

    public abstract int width();

    public abstract int height();

}