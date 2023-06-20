package Dsad.hud;

import java.util.ArrayList;
import java.util.List;

import Dsad.hud.impl.TestMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class Mods {

    public static List<Mod> listOfMods = new ArrayList();
    public static TestMod testMod = new TestMod(Minecraft.getMinecraft());

    public Mods() {
        this.listOfMods.add(testMod);
    }

    public static void renderOverlay() {

        for (Mod mod : listOfMods) {
            mod.render(new ScaledResolution(Minecraft.getMinecraft()).getScaledWidth());
        }
    }
}