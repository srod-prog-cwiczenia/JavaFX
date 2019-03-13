package aplikacja;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GlownaKlasa2 {

	public static void pokaz() {

		Stage primaryStage = new Stage();
		Button button = new Button("Uruchomienie akcji");

		button.setOnAction((event) -> {
			// Button was clicked, do something...
			/*for (int ii = 0; ii < 10; ii++) {
				System.out.println(ii + " ");
			}*/
			PoNacisnieciuPrzycisku2.akcja1();
			Scena2.pokaz1(primaryStage);
		});

		StackPane layout = new StackPane();

		layout.getChildren().add(button);

		Scene scene = new Scene(layout, 400, 400);

		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
}
