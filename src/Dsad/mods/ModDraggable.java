package Dsad.mods;

import java.io.File;

import org.apache.logging.log4j.core.appender.FileManager;

import Dsad.gui.hud.IRenderer;
import Dsad.gui.hud.ScreenPosition;

public abstract class ModDraggable extends Mod implements IRenderer
{
    public final int getLineOffset(ScreenPosition pos, int lineNum)
    {
        return pos.getAbsoluteX() + getLineOffset(lineNum);
    }

    private int getLineOffset(int lineNum)
    {
        return (font.FONT_HEIGHT + 3) * lineNum;
    }
}
