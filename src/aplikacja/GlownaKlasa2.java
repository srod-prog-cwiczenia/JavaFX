package aplikacja;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import nowe.ObszarTekstowy;
import przyklady.Strumienie;

public class GlownaKlasa2 {

	public static void pokaz() {

		Stage primaryStage = new Stage();
		Button przycisk1 = new Button("Uruchomienie akcji opisującej co sie dzieje w konsoli");

		przycisk1.setOnAction((event) -> {
			// Button was clicked, do something...
			/*for (int ii = 0; ii < 10; ii++) {
				System.out.println(ii + " ");
			}*/ //TODO: uporzadkowac te dwie metody ponizej
			PoNacisnieciuPrzycisku2.akcja1();
			Scena2.pokaz1(primaryStage);
		});

		Button przycisk2 = new Button("Uruchomienie Text Area");
		przycisk2.setOnAction((event) -> {
			ObszarTekstowy.pokaz();
		});
		
		Button przycisk3 = new Button("Test strumieni");
		przycisk3.setOnAction((event) -> {
			Strumienie.przyklad1();
		});

		FlowPane fp = new FlowPane();
/*		StackPane layout = new StackPane();
		layout.getChildren().addAll(przycisk1, przycisk2, przycisk3);*///zamiast stackpane dajemy flowpane
		
		fp.getChildren().addAll(przycisk1, przycisk2, przycisk3);
        Scene scene = new Scene(/*layout*/fp, 550, 550);

		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
}
