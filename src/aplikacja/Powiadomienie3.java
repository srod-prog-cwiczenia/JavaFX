package aplikacja;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Powiadomienie3 {
	
	public static void powiadomienie1() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Powiadomienie");
		alert.setHeaderText("Naglowek");
		alert.setContentText("Wywolanie metody w klasie Powiadomienie3.");
		alert.showAndWait();
	}

	
}
