package aplikacja;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import narzedzia.Pomocnicze;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GlownaKlasa3 {

	public static void pokaz() {
		Stage primaryStage = new Stage();
        Label label = new Label("Wybierz liczbe testow:");
        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100000);
        slider.setValue(20000);
        slider.setMajorTickUnit(10000);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setBlockIncrement(100);
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20));
        vbox.setSpacing(10);
        vbox.getChildren().addAll(label, slider);

        Button btnTestSzybkosci = new Button("Rozmaite testy (szybkosci)");
		btnTestSzybkosci.setOnAction(event -> {
			Powiadomienie3.testySzybkosci(slider.getValue());
		});
        
		StackPane layout = new StackPane();
		layout.getChildren().addAll(vbox, btnTestSzybkosci);
		/**
		 * z niewiadomych dla mnie przyczyn kiedy podmieni sie
		 * kolejnosc w addAll (na btn a potem vbox) to btn robi sie
		 * nieaktywy - wyjasnic to!
		 */

		Scene scene = new Scene(layout, 400, 400);

		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
