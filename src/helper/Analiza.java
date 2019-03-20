package helper;

import java.util.Set;

public class Analiza {
	private  int rozmiar = 10;
	public Analiza (int rozmiar) {
		super();
		this.rozmiar = rozmiar;
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
		if (sameSkreslone) return Kolor.CZARNY;
		
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
		return sameBiale ? Kolor.CZARNY : Kolor.BIALY;
	}
	public Kolor sprawdz() {
		boolean skreslone[] = new boolean [rozmiar + 1];
		for (int ii = 1; ii <= rozmiar; ii++) {
			skreslone[ii] = false;
		}
		return ocena(skreslone);
	}
}
