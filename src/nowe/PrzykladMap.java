package nowe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrzykladMap {
	private List<String> res;
	public PrzykladMap() {
		super();
		this.res = new ArrayList<String>();
	}
	public void drukuj(String linijka) {
		res.add(linijka + "\n");
	}
	public void przyklad1() {
	  Map<String, String> mapa = new HashMap<>();
	  mapa.put("Marcin", "Kolega");
	  mapa.put("Marcin", "Przyjaciel");
	  mapa.put("Adam", "Kowalski");
	  mapa.put("Adam", "Kowalski");
	  
	  drukuj("Iterowanie po wartosciach");
	  for (String value : mapa.values()) {
		  drukuj(value);
	  }
	 
	  drukuj("Iterowanie po kluczach i pobieranie wartosci");
	  for (String kluczyk : mapa.keySet()) {
	      String wartosc = mapa.get(kluczyk);
	      drukuj(kluczyk + ": " + wartosc);
	  }
	 
	  drukuj("Iterowanie po kluczach i wartosciach");
	  for (Map.Entry<String, String> entry : mapa.entrySet()) {
	    String kluczyk = entry.getKey();
	    String wartosc = entry.getValue();
	    drukuj(kluczyk + ": " + wartosc);
	  }
	  ObszarTekstowy.pokazArrayListLancuchow(res, "Raport z uzycia mapy");
	}
}
