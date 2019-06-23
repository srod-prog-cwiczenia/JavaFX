package przyklady.interfejsy;

public class NiepelneRozwiniecieSzkic2 implements Szkic2 {
	  public static int liczba = 0; 
	  public String info() {
		  return "(Niepelne rozwiniecie) Tu informacja o liczbie: " + liczba;
	  }
	  public void dolacz() {
		liczba++;
	  }
}
