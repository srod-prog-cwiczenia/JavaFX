package aplikacja;

import java.util.Arrays;
import java.util.List;

public class PrzykladyKonsolowe {
  public static void akcja1() {
	  System.out.println("Nacisnieto przycisk nr 1.");
	  RozwiniecieSzkic2 rs1 = new RozwiniecieSzkic2();
	  rs1.dolacz();
	  rs1.dolacz();
	  System.out.println(rs1.info());
	  System.out.println(rs1.opis());
	  System.out.println("------- zwiezly kod do wypisania kolekcji liczb: ----");
	  List<Integer> listaLiczb = Arrays.asList(3, 1, 4, 1);
	  listaLiczb.forEach(System.out::println);
  }
}

