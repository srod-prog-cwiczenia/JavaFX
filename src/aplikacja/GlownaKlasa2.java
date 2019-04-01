package aplikacja;

import java.util.ArrayList;
import java.util.Arrays;

import helper.Analiza;
import helper.AnalizaDialog;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import narzedzia.Pomocnicze;
import nowe.ObszarTekstowy;
import nowe.PrzykladMap;
import nowe.TextAreaZTextEditFrm;
import przyklady.Strumienie;

public class GlownaKlasa2 {

	public static void pokaz(boolean czyTilePane) {

		Stage primaryStage = new Stage();
		Button przycisk1 = new Button("Uruchomienie listy " +
				"przykladow z opisem tego co sie dzieje na konsoli");

		przycisk1.setOnAction((event) -> {
			// Button was clicked, do something...
			/*for (int ii = 0; ii < 10; ii++) {
				System.out.println(ii + " ");
			}*/ //TODO: uporzadkowac te dwie metody ponizej
			PrzykladyKonsolowe.akcja1();
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
			/*Analiza analiza = new Analiza(10);
			Pomocnicze.komunikat(analiza.sprawdz().toString());
			Pomocnicze.komunikat("" + analiza.rezultatyMap.keySet().size());*/
			AnalizaDialog.run();
		});

		Button przycisk6 = new Button("Test mapy");
		przycisk6.setOnAction((event) -> {
			(new PrzykladMap()).przyklad1();
		});

		Button przycisk7 = new Button("Uruchomienie TextAreaZTextEditFrm");
		przycisk7.setOnAction((event) -> {
			TextAreaZTextEditFrm.pokazArrayListLancuchow(
					new ArrayList<String>(
  				      Arrays.asList("Linia nr 1", "Linia nr 2", "Linia nr 3")), "",
					    new EventHandler<ActionEvent>() {
						  public void handle(ActionEvent event) {
						  TextAreaZTextEditFrm.dopiszDoTextArea(TextAreaZTextEditFrm.getTextField());
						  TextAreaZTextEditFrm.setTextField("");
						  }});
		});

		Button btnWyjscie = new Button("Wyjscie");
  		btnWyjscie.setOnAction((event) -> {
			primaryStage.close();
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
		
		
		FlowPane fp = null;
		TilePane tp = null;
		if (czyTilePane) {
			tp = new TilePane();
		} else {
			fp = new FlowPane();
		}
/*		StackPane layout = new StackPane();
		layout.getChildren().addAll(przycisk1, przycisk2, przycisk3);*///zamiast stackpane dajemy flowpane
		if (tp == null)
			fp.getChildren().addAll(przycisk1, przycisk2, 
					przycisk3, przycisk4, hboxRB, przycisk5, przycisk6, 
					przycisk7, btnWyjscie);
		else 
			tp.getChildren().addAll(przycisk1, przycisk2, 
					przycisk3, przycisk4, hboxRB, przycisk5, przycisk6, 
					przycisk7, btnWyjscie);

		Scene scene = new Scene((tp == null ? fp : tp), 550, 550);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
}
