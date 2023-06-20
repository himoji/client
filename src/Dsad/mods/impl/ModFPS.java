package Dsad.mods.impl;

import Dsad.gui.hud.ScreenPosition;
import Dsad.mods.ModDraggable;

public class ModFPS extends Dsad.mods.ModDraggable {
	
	private ScreenPosition pos;

    private boolean isChroma = true;
    private boolean betterUI = false;

    @Override
    public int getWidth() {
        return 50;
    }

    @Override
    public int getHeight() {
        return font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {
    	font.drawString(betterUI ? mc.getDebugFPS() + " FPS" : "FPS: " + mc.getDebugFPS(), pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
    }


    @Override
	public void save(ScreenPosition pos) {
		this.pos = pos;
		
	}

	@Override
	public ScreenPosition load() {
		return pos;
	}
}