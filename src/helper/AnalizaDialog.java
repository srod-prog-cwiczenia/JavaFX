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
	static public void run() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Liczba? ");
		int liczba = sc1.nextInt();
		Analiza analiza = new Analiza(liczba);
		analiza.sprawdz();
		char[] charArray = new char[liczba];
		Arrays.fill(charArray, '0');
		String stan = new String(charArray);
		System.out.println(stan + " " + analiza.rezultatyMap.get(stan).toString());
		System.out.println("Kto zaczyna? j - ja, inny - Ty");
		String odp = sc1.nextLine();
		//TODO: to do uzupelnienia
		sc1.close();
	}  
}
