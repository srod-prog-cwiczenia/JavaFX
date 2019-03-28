package narzedzia;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Pomocnicze {
	public static void komunikat(String tresc) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Komunikat:");
		alert.setHeaderText("Komunikat:");
		alert.setContentText(tresc);
		alert.showAndWait();
	}
	public static String zbudujNaglowek(String txt, int dlugosc) {
//TODO przerobic to na StringBuilder
		int ile = (dlugosc - txt.length()) / 2;
		if (ile < 0) ile = 0;
		String lancuchSeparator = new String(new char[ile]).replace("\0", "-"); 
	    lancuchSeparator += txt; 
        lancuchSeparator += (new String(new char[ile]).replace("\0", "-"));
        return lancuchSeparator;
	}
}
