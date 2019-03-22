package aplikacja;

import javafx.application.Application;
import javafx.stage.Stage;
import narzedzia.Pomocnicze;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GlownaKlasa3 {

	public static void pokaz() {
		Stage primaryStage = new Stage();
		Button button = new Button("Wielokrotne wywolanie");

		button.setOnAction(event -> {
			Powiadomienie3.powiadomienie1();
			wypisanieKomunikatu();
		});
		
		
//		{
//		    // Button was clicked, do something...
//		    System.out.println("nacisniety klawisz");
//		});
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);

		Scene scene = new Scene(layout, 400, 400);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private static void wypisanieKomunikatu() {
		Pomocnicze.komunikat("To jest klasa GlownaKlasa3.");
	}
}
