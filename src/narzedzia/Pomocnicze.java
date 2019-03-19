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
}
