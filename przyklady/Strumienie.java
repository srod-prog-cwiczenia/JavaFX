package przyklady;

import java.util.List;
import nowe.ObszarTekstowy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Strumienie {
	public static List<String> getStringList(List<Osoba> kolekcja) { 
      List<String> lancuchy = new ArrayList<String>();
	  for (Osoba obj : kolekcja) {
    	  lancuchy.add(obj.toString() + "\n");
      }
	  return lancuchy;
	}  

	static class Osoba {
		String imie, nazwisko;

		public Osoba(String imie, String nazwisko) {
			super();
			this.imie = imie;
			this.nazwisko = nazwisko;
		}

		@Override
		public String toString() {
			return "Osoba [imie=" + imie + ", nazwisko=" + nazwisko + "]";
		}

		public String getImie() {
			return imie;
		}

		public void setImie(String imie) {
			this.imie = imie;
		}

		public String getNazwisko() {
			return nazwisko;
		}

		public void setNazwisko(String nazwisko) {
			this.nazwisko = nazwisko;
		}
		
	}
	public static void przyklad1() {
		List<Osoba> lOso = Arrays.asList(new Osoba("Adam", "Kowalski"), new Osoba("Monika", "Test"));
		List<String> lLan = getStringList(lOso);
		ObszarTekstowy.pokazArrayListLancuchow(lLan, "wszystkie osoby");
		Stream<Osoba> panie = lOso.stream().filter(oso -> 
		  oso.getImie().charAt(oso.getImie().length() - 1) == 'a'); 
		List<String> lLanPanie = new ArrayList<String>();
		panie.forEach(dama -> lLanPanie.add(dama.toString()));
		ObszarTekstowy.pokazArrayListLancuchow(lLanPanie, "tylko panie");		
	}
}
