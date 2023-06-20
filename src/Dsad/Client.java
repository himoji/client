package Dsad;

import Dsad.event.EventManager;
import Dsad.event.EventTarget;
import Dsad.event.impl.ClientTickEvent;
import Dsad.gui.SplashProgress;
import Dsad.gui.hud.HUDManager;
import Dsad.mods.ModInstances;
import net.minecraft.client.Minecraft;

public class Client {
	
	private static final Client INSTANCE = new Client();
	public static final Client getInstance() {
		return INSTANCE;
	}
	
	private HUDManager hudManager;
	
	public void init() {
		SplashProgress.setProgress(0, "$#@*$^@*#&^(%!!");
		EventManager.register(this);
	}
	public void start() {
		hudManager = HUDManager.getInstance();
		ModInstances.register(hudManager);
	}
	
	@EventTarget
	public void onTick(ClientTickEvent e) {
		if(Minecraft.getMinecraft().gameSettings.CLIENT_GUI_MOD_POS.isPressed()) {
			hudManager.openConfigScreen();
		}
	}
}
//CommandGameMode - gamemode