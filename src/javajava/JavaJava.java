package javajava;
import java.util.Scanner;
import java.util.ArrayList;

public class JavaJava {

    public static void start() {
        Scanner sc1 = new Scanner(System.in);
        ProsteMenu mn1 = new ProsteMenu(new String[]{"Fibonacci", "Interakcja", "Inne", "Dummy", "Testy"}, sc1);
	int iii = 0;	
	do {		
		iii = mn1.wybierz();
		switch (iii) {
		  case 1:
		    Fibonacci.fibonacci();
		    break;
		  case 2: {
		    Interakcja klasa = new Interakcja();
		    klasa.pobranieLancuchaZPliku();
		    klasa.pokazKolekcje();
		    klasa.zapisanieDoPliku();
		    break;
		  }
		  case 3: {
		    Interakcja klasa = new Interakcja();
		    klasa.pobranieLancucha();
		    klasa.pokazKolekcje();
		    klasa.posortujListe();
		    klasa.pokazKolekcje();
		    klasa.pokazKolekcje(klasa.lista);
		    break;
		  }
		  case 4: {
		    System.out.println("Dummy");
		    break;
		  }
		  case 5: {
			ProsteMenu mn2 = new ProsteMenu(new String[]{"Proba 1", "Mapy", "Test regexp", 
	"Klasy wewnetrzne", "Hasz zbior"}, sc1);
			int iii2 = mn2.wybierz();
			switch (iii2) {
				case 1: {
					String lancuch = "Ala ma kota";
					String [] lista = lancuch.split(" ");
					for (String txt : lista)
						System.out.println(txt);
					break;
				}
				case 2: {
					PrzykladyIteratorow pi = new PrzykladyIteratorow();
					pi.wypelnienieMapy(sc1);
					System.out.println("==================");
					System.out.println("Wersja 1 iteracji:");
					pi.pokazNamWersja1();
					System.out.println("==================");
					System.out.println("Wersja 2 iteracji:");
					pi.pokazNamWersja2();
					System.out.println("==================");
					System.out.println("Wersja 3 iteracji:");
					pi.pokazNamWersja3();
					break;
				}
				case 3: {
				  TestRegExp.test(sc1);
				  break;
				}
				case 4: {
				  ArrayList<String> i_al = new ArrayList<String>();
				  i_al.add("Adam");
				  i_al.add("Ola");
				  KlasaZewnetrzna.localClassInstantiation(i_al);
			          break;
				}
				case 5: {
				  HaszZbior.test(sc1);
				  break;
				}
			}
		  }
	       }
	} while (iii != 0);
	System.out.println("Koniec działania odnogi JavaJava...");
	sc1.close();
    }
}
