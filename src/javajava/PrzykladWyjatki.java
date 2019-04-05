package javajava;

import java.util.Scanner;

class WlasnyWyjatekException extends Exception {
	private String szczegoly;
	WlasnyWyjatekException(String aSzczegoly) {
		szczegoly = aSzczegoly;
	}
	@Override
	public String toString() {
		return "WlasnyWyjatekException [szczegoly=" + szczegoly + "]";
	}
}

public class PrzykladWyjatki {
	private static void dzialaj(Scanner sc1) throws WlasnyWyjatekException {
		System.out.println("Wywolac wlasny wyjatek? Podaj napis. n oznacza nie.");
        String liniaStr = sc1.nextLine();
        if (liniaStr.isEmpty()) {
	        return;
        }
        if (!liniaStr.equals("n")) {
        	throw new WlasnyWyjatekException(liniaStr);
        }
	}
	public static void run(Scanner sc1) {
		try {
			dzialaj(sc1);
		} catch (WlasnyWyjatekException e) {
			System.out.println("Zlapany wyjatek: " + e);
		} 
	}
}
