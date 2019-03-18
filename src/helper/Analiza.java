package helper;

import java.util.Set;

public class Analiza {
	public static final int ROZMIAR = 10;
	public static Kolor ocena(boolean skreslone[]) {
		/*String txt = "";
		for (int qq = 1; qq <= ROZMIAR; qq++) {
			txt += (skreslone[qq] ? "#" : ".");
		}
		System.out.println(txt);*/
		boolean sameSkreslone = true;
		for (int jj = 1; jj <= ROZMIAR; jj++) {
			sameSkreslone = sameSkreslone && skreslone[jj];
		}
		if (sameSkreslone) return Kolor.CZARNY;
		
		boolean dane[] = new boolean[ROZMIAR + 1];
		boolean sameBiale = true;
		for (int jj = 1; jj <= ROZMIAR; jj++) {
			if (skreslone[jj]) continue;
			for (int ii = 1; ii <= ROZMIAR; ii++) {
				dane[ii] = skreslone[ii];
			}
			for (int kk = 1; kk <= jj; kk++) {
				if (jj % kk == 0) {
					dane[kk] = true;
				}
			}
			sameBiale = sameBiale && ocena(dane) == Kolor.BIALY;
		}
		return sameBiale ? Kolor.CZARNY : Kolor.BIALY;
	}
	public static Kolor sprawdz() {
		boolean skreslone[] = new boolean [ROZMIAR + 1];
		for (int ii = 1; ii <= ROZMIAR; ii++) {
			skreslone[ii] = false;
		}
		return ocena(skreslone);
	}
}
