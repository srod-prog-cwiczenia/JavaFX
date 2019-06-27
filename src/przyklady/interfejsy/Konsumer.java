package przyklady.interfejsy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import aplikacja.EdycjaOsobyFrm;
import narzedzia.TextAreaConsoleFrm;

public class Konsumer {
	public static void run() {
		  TextAreaConsoleFrm cons = new TextAreaConsoleFrm();
	      List<EdycjaOsobyFrm.OsobaKlasaWewn> studenci = Arrays.asList(
	            new EdycjaOsobyFrm.OsobaKlasaWewn("Anna", "Nieznana", "7"),
	            new EdycjaOsobyFrm.OsobaKlasaWewn("Marek", "Kowalski", "13"),
	            new EdycjaOsobyFrm.OsobaKlasaWewn("Adam", "Nowak", "10")	            
	      );

	      przetwarzanieListyStudentow(studenci, 
	    		  stu -> cons.println(stu.getImie() + " " + stu.getNazwisko() + " " + stu.getKomentarz()));
	      przetwarzanieListyStudentow(studenci, stu -> {
        	  try {
        		  stu.setKomentarz("" + 10 * Integer.parseInt(stu.getKomentarz()));
        	  } catch (NumberFormatException e) {
        		  stu.setKomentarz("0");
        	  }
	      });
	      przetwarzanieListyStudentow(studenci, 
	    		  stu -> cons.println(stu.getImie() + " " + stu.getNazwisko() + " " + stu.getKomentarz()));
	      cons.czytajLinie();
	      cons.zamkniecieFormatki();
	   }

	   public static void przetwarzanieListyStudentow(List<EdycjaOsobyFrm.OsobaKlasaWewn> student, Consumer<EdycjaOsobyFrm.OsobaKlasaWewn> printer) {
	      for (EdycjaOsobyFrm.OsobaKlasaWewn stu : student) {
	         printer.accept(stu);
	      }
	   }
}
