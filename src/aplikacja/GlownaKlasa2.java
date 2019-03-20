package aplikacja;

import helper.Analiza;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import narzedzia.Pomocnicze;
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

		Button przycisk4 = new Button("Rekurencja");
		przycisk4.setOnAction((event) -> {
			Analiza analiza = new Analiza(10);
			System.out.println(analiza.sprawdz());
		});
		

//przyk�ad na radiobutton:
        RadioButton radioButton1 = new RadioButton("Jeden");
        RadioButton radioButton2 = new RadioButton("Dwa");
        RadioButton radioButton3 = new RadioButton("Trzy");
        RadioButton radioButton4 = new RadioButton("Cztery");

        ToggleGroup radioGroup = new ToggleGroup();

        radioButton1.setToggleGroup(radioGroup);
        radioButton1.setSelected(true);
        radioButton2.setToggleGroup(radioGroup);
        radioButton3.setToggleGroup(radioGroup);
        radioButton4.setToggleGroup(radioGroup);

        HBox hboxRB = new HBox(radioButton1, radioButton2, radioButton3, radioButton4);

	
		Button przycisk5 = new Button("Sprawdz Radio Group");
		przycisk5.setOnAction((event) -> {
			RadioButton selectedRadioButton =
			        (RadioButton) radioGroup.getSelectedToggle();
			if (selectedRadioButton.equals(radioButton1))
			  Pomocnicze.komunikat("Jeden"); 
			else if (selectedRadioButton.equals(radioButton2))
  			  Pomocnicze.komunikat("Dwa");  					
			else if (selectedRadioButton.equals(radioButton3))
  			  Pomocnicze.komunikat("Trzy");  					
			else if (selectedRadioButton.equals(radioButton4))
  			  Pomocnicze.komunikat("Cztery");  					

		});
		
		
		FlowPane fp = new FlowPane();
/*		StackPane layout = new StackPane();
		layout.getChildren().addAll(przycisk1, przycisk2, przycisk3);*///zamiast stackpane dajemy flowpane
		
		fp.getChildren().addAll(przycisk1, przycisk2, przycisk3, przycisk4, hboxRB, przycisk5);
        Scene scene = new Scene(/*layout*/fp, 550, 550);

		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
}
