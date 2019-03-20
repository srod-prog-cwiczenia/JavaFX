package helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analiza {
	private  int rozmiar = 10;
	public Map<String, Kolor> rezultatyMap; //TODO: nieladne rozwiazanie, na razie chwilowe (public)
	public Analiza (int rozmiar) {
		super();
		this.rozmiar = rozmiar;
		rezultatyMap = new HashMap<>();
	}
	public void zapiszRezultat(boolean skreslone[], Kolor kolor) {
		char tablicaCh[] = new char[this.rozmiar];
		for (int qq = 0; qq < rozmiar; qq++) {
			tablicaCh[qq] = (skreslone[qq + 1] ? '1' : '0');
		}
		String txt = String.valueOf(tablicaCh);
		rezultatyMap.put(txt, kolor);
	}
	public  Kolor ocena(boolean skreslone[]) {
		/*String txt = "";
		for (int qq = 1; qq <= ROZMIAR; qq++) {
			txt += (skreslone[qq] ? "#" : ".");
		}
		System.out.println(txt);*/
		boolean sameSkreslone = true;
		for (int jj = 1; jj <= rozmiar; jj++) {
			sameSkreslone = sameSkreslone && skreslone[jj];
		}
		if (sameSkreslone) {
			zapiszRezultat(skreslone, Kolor.CZARNY);
			return Kolor.CZARNY;
		}
		
		boolean dane[] = new boolean[rozmiar + 1];
		boolean sameBiale = true;
		for (int jj = 1; jj <= rozmiar; jj++) {
			if (skreslone[jj]) continue;
			for (int ii = 1; ii <= rozmiar; ii++) {
				dane[ii] = skreslone[ii];
			}
			for (int kk = 1; kk <= jj; kk++) {
				if (jj % kk == 0) {
					dane[kk] = true;
				}
			}
			sameBiale = sameBiale && ocena(dane) == Kolor.BIALY;
		}
		Kolor ocenaKolor = sameBiale ? Kolor.CZARNY : Kolor.BIALY;
		zapiszRezultat(skreslone, ocenaKolor);
		return ocenaKolor;
	}
	public Kolor sprawdz() {
		boolean skreslone[] = new boolean [rozmiar + 1];
		for (int ii = 1; ii <= rozmiar; ii++) {
			skreslone[ii] = false;
		}
		return ocena(skreslone);
	}
}
