package narzedzia;

import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Pomocnicze {
	public static String stackTrace2String(Exception aE) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		aE.printStackTrace(pw);
		return sw.toString(); 
	}
	public static void komunikat(String tresc) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Komunikat:");
		alert.setHeaderText("Komunikat:");
		alert.setContentText(tresc);
		alert.showAndWait();
	}
	public static String zbudujNaglowek(String txt, int dlugosc) {
		int ile = (dlugosc - txt.length()) / 2;
		if (ile < 0) ile = 0;
		String lancuchSeparator = new String(new char[ile]).replace("\0", "-"); 
	    lancuchSeparator += txt; 
        lancuchSeparator += (new String(new char[ile]).replace("\0", "-"));
        return lancuchSeparator;
	}
	public static String zbudujNaglowekStringBuilder(String txt, int dlugosc) {
/**
 * nowa metoda bazujaca na stringbuilderze
 */
		int ile = (dlugosc - txt.length()) / 2;
		if (ile < 0) ile = 0;
		StringBuilder lancuchSeparator = new StringBuilder(dlugosc);
		for (int qq = 0; qq < ile; qq++) {
			lancuchSeparator.append('-');
		};
	    lancuchSeparator.append(txt); 
		for (int qq = 0; qq < ile; qq++) {
			lancuchSeparator.append('-');
		};
        return lancuchSeparator.toString();
	}
}
