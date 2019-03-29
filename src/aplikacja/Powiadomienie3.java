package aplikacja;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import przyklady.testy_szybkosci.TestySzybkosci;

public class Powiadomienie3 {
	public static void testySzybkosci(double ileTestow) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Powiadomienie");
		alert.setHeaderText("Naglowek");
		String raport = TestySzybkosci.testStringBuilder(ileTestow);
		alert.setContentText("---Testy szybkosci klas lancuchowych-------\n" + raport);
		alert.showAndWait();
	}

	
}
