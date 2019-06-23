package przyklady.interfejsy;

public class RozwiniecieSzkic2 implements Szkic2 {
  public static int liczba = 0; 
  public String info() {
	  return "Tu informacja o liczbie: " + liczba;
  }
  public void dolacz() {
	liczba++;
  }
  public String opis() {
	  return "Opis info o liczbie: " + liczba;
  }
}
