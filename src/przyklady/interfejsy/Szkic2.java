package przyklady.interfejsy;

public interface Szkic2 {
  String info();
  void   dolacz();
  default String opis() {
	  return "Pusty opis";	  
  };
}
