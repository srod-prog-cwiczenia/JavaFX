package aplikacja;

import javafx.application.Application;
import javafx.stage.Stage;
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
			MetodaCosTam3.metodaCosTam1();
			metodaCosTam(primaryStage);
			System.out.println("Wiadomosc z konsoli"); 
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

	private static void metodaCosTam(Stage primaryStage) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Powiadomienie");
		alert.setHeaderText("Naglowek");
		alert.setContentText("Wywolanie metody private static void");
		alert.showAndWait();
	}
}
