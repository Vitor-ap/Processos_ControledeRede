package view;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController redes = new RedesController();
		String os = System.getProperty("os.name");
		redes.ip(os);
		redes.ping(os);
	}

}