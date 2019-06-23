package aplikacja;

import java.util.Arrays;
import java.util.List;

import narzedzia.TextAreaConsoleFrm;
import przyklady.interfejsy.*;

public class PrzykladyKonsolowe {
  public static void akcja1() {
	  TextAreaConsoleFrm kons = new TextAreaConsoleFrm();
      kons.pokaz("Przykład funkcjonowania interface-u.");
	  RozwiniecieSzkic2 rs1 = new RozwiniecieSzkic2();
	  NiepelneRozwiniecieSzkic2 rs2 = new NiepelneRozwiniecieSzkic2();
	  rs1.dolacz();
	  rs1.dolacz();
	  rs2.dolacz();
	  rs2.dolacz();
	  kons.pokaz("------ pelna implementacja interfejsu -------");
	  kons.pokaz(rs1.info());
	  kons.pokaz(rs1.opis());
	  kons.pokaz("------ niepelna implementacja interfejsu (bez implementowania metody defaultowej) -------");		  
	  kons.pokaz(rs2.info());
	  kons.pokaz(rs2.opis());
	  kons.pokaz("------- zwiezly kod do wypisania kolekcji liczb: ----");
	  List<Integer> listaLiczb = Arrays.asList(3, 1, 4, 1);
/*	  if (KONSOLA)
		  listaLiczb.forEach(System.out::println); */
	  for (int liczba : listaLiczb)
		  kons.pokaz(liczba);
//		  listaLiczb.forEach(liczba -> kons.pokaz(liczba)); -TODO: w tym kontekście kompilator żąda final od kons
	  kons.pokaz("------- to samo ale zastosowane do kolekcji łańcuchów: ----");		  
	  List<String> listaLancuchow = Arrays.asList("trzy", "jeden", "cztery", "jeden");
	  /*if (KONSOLA)	  
		  listaLancuchow.forEach(System.out::println);*/
	  for (String txt : listaLancuchow)
		  kons.pokaz(txt);
//		  listaLancuchow.forEach(txt -> kons.pokaz(txt)); -TODO: w tym kontekście kompilator żąda final od kons
  }
}

