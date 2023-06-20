package Dsad.cosmetics;

import net.minecraft.client.entity.AbstractClientPlayer;

public class CosmeticControl {
	//database
	public static boolean shouldRenderTopHat(AbstractClientPlayer player) {
		return true;
	}
	
	public static float[] getTopHatColor(AbstractClientPlayer player) {
		//rgb 1-0 only
		return new float[] {1, 0, 0};
		}
	
	}
	

