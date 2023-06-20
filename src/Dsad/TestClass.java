package Dsad;

import Dsad.event.EventTarget;
import Dsad.event.impl.ClientTickEvent;

public class TestClass {

	@EventTarget
	public void dd(ClientTickEvent e) {
		
		System.out.println("ti loh");
		
	}
	
}
