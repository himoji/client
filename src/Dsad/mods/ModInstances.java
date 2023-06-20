package Dsad.mods;

import Dsad.gui.hud.HUDManager;
import Dsad.gui.hud.IRenderer;
import Dsad.mods.impl.ModBossbar;
import Dsad.mods.impl.ModFPS;
import Dsad.mods.impl.ModHealthIndicator;
import Dsad.mods.impl.ModKeystrokes;
import Dsad.mods.impl.ModPotionStatus;

public class ModInstances {

	private static ModKeystrokes str;
	private static ModHealthIndicator hp;
	private static ModFPS fps;
	private static ModBossbar bar;
	private static ModPotionStatus pots;
	
	
	
	public static void register(HUDManager api) {
		str = new ModKeystrokes();
		api.register(str);
		
		hp = new ModHealthIndicator();
		api.register(hp);
		
		fps = new ModFPS();
		api.register(fps);
		
		bar = new ModBossbar();
		api.register(bar);
		
		pots = new ModPotionStatus();
		api.register(pots);
		
		
	}
	
}
