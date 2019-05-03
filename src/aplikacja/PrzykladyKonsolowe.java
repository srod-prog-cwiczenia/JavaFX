package aplikacja;

import java.util.Arrays;
import java.util.List;

import nowe.TextAreaConsoleFrm;

public class PrzykladyKonsolowe {
  final public static boolean KONSOLA = false; 
  public static void akcja1() {
	  TextAreaConsoleFrm kons = null;
	  if (!KONSOLA)
		  kons = new TextAreaConsoleFrm();
	  
	  if (KONSOLA)
		  System.out.println("Przykład funkcjonowania interface-u.");
	  else 
		  kons.pokaz("Przykład funkcjonowania interface-u.");
	  RozwiniecieSzkic2 rs1 = new RozwiniecieSzkic2();
	  rs1.dolacz();
	  rs1.dolacz();
	  if (KONSOLA) {
		  System.out.println(rs1.info());
		  System.out.println(rs1.opis());
		  System.out.println("------- zwiezly kod do wypisania kolekcji liczb: ----");
	  } else {
		  kons.pokaz(rs1.info());
		  kons.pokaz(rs1.opis());
		  kons.pokaz("------- zwiezly kod do wypisania kolekcji liczb: ----");
	  }
	  List<Integer> listaLiczb = Arrays.asList(3, 1, 4, 1);
	  if (KONSOLA)
		  listaLiczb.forEach(System.out::println);
	  else for (int liczba : listaLiczb)
		  kons.pokaz(liczba);
//		  listaLiczb.forEach(liczba -> kons.pokaz(liczba)); -TODO: w tym kontekście kompilator żąda final od kons
	  if (KONSOLA)
		  System.out.println("------- to samo ale zastosowane do kolekcji łańcuchów: ----");
	  else
		  kons.pokaz("------- to samo ale zastosowane do kolekcji łańcuchów: ----");		  
	  List<String> listaLancuchow = Arrays.asList("trzy", "jeden", "cztery", "jeden");
	  if (KONSOLA)	  
		  listaLancuchow.forEach(System.out::println);
	  else for (String txt : listaLancuchow)
		  kons.pokaz(txt);
//		  listaLancuchow.forEach(txt -> kons.pokaz(txt)); -TODO: w tym kontekście kompilator żąda final od kons
  }
}

