package helper;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class AnalizaDialog {
	static public void pokazCalaAnalize(Analiza aAnaliza) {
	    for (Map.Entry<String, Kolor> entry : aAnaliza.rezultatyMap.entrySet()) {
		    String kluczyk = entry.getKey();
		    String wartosc = entry.getValue().toString();
		    System.out.println(kluczyk + ": " + wartosc);
	    }
	}
	static public String zastosowanie(String stan, int jaka) {
		StringBuilder stan2bu = new StringBuilder(stan);
		for (int kk = 1; kk <= jaka; kk++) {
			if (jaka % kk == 0) {
				stan2bu.setCharAt(kk - 1, 'X');
			}
		}
		return stan2bu.toString();
	}
	static public boolean koncowyStan(String stan, int aLiczba) {
		boolean odp = true;
		for (int qq = 0; qq < aLiczba; qq++) {
			odp = odp && stan.charAt(qq) == 'X';
		}
		return odp;
	}
	static public void run() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Liczba? ");
		int liczba = sc1.nextInt();
		Analiza analiza = new Analiza(liczba);
		analiza.wykonajAnalize();
		char[] charArray = new char[liczba];
		Arrays.fill(charArray, '0');
		String stan = new String(charArray);
		do {
			System.out.println(stan + " " + analiza.rezultatyMap.get(stan).toString());
			switch (analiza.rezultatyMap.get(stan)) {
				case BIALY: {
					System.out.println("Proponowane moje odpowiedzi:");
					for (int qq = 1; qq <= liczba; qq++) {
						if (stan.charAt(qq - 1) == '0') {
							String stan2 = zastosowanie(stan, qq);
							if (analiza.rezultatyMap.get(stan2) == Kolor.CZARNY) {
								System.out.print(qq);
								System.out.print(" ");
							}
						} 
					}
					System.out.println("Jaka wybrac?");
					int odp = sc1.nextInt();
					stan = zastosowanie(stan, odp);
					break;
				}
				case CZARNY: {
					System.out.println("Jaka wybrac?");
					int odp = sc1.nextInt();
					stan = zastosowanie(stan, odp);
					break;
				}
			}
		} while (!koncowyStan(stan, liczba));	
		//TODO: to do uzupelnienia
		sc1.close();
	}  
}
