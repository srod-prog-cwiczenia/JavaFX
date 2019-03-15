package aplikacja;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MetodaCosTam3 {
	
	public static void metodaCosTam1() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Powiadomienie");
		alert.setHeaderText("Naglowek");
		alert.setContentText("Wywolanie metody w klasie MetodaCosTam3.");
		alert.showAndWait();
	}

	
}
