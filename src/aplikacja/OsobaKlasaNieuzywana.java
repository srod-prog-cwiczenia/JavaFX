package aplikacja;
/**
 * 
 * prawdopodobnie ta klasa nie jest juz uzywana, ale nalezy to sprawdzic
 *
 */
public class OsobaKlasaNieuzywana {
	
    private String imie = null;
    private String nazwisko = null;
    private String komentarz = null;

    public OsobaKlasaNieuzywana() {
    }

    public OsobaKlasaNieuzywana(String imie, String nazwisko, String komentarz) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.komentarz = komentarz;
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

	public String getKomentarz() {
		return komentarz;
	}

	public void setKomentarz(String komentarz) {
		this.komentarz = komentarz;
	}
    
    
}
