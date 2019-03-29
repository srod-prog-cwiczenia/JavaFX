package aplikacja;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import testy.TestySzybkosci;

public class Powiadomienie3 {
	public static void powiadomienie1() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Powiadomienie");
		alert.setHeaderText("Naglowek");
		String raport = TestySzybkosci.testStringBuilder();
		alert.setContentText("---Testy szybkosci klas lancuchowych-------\n" + raport);
		alert.showAndWait();
	}

	
}
