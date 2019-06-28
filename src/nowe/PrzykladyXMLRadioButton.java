package nowe;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import narzedzia.Pomocnicze;
import przyklady.xml.PrzykladyXML;

public class PrzykladyXMLRadioButton {
    public static void run() {
		Stage stage = new Stage();
		stage.setTitle("Przyklady XML");
        stage.setWidth(550);
        stage.setHeight(550);

        RadioButton radioButton1 = new RadioButton("Utworzenie XML");
        RadioButton radioButton2 = new RadioButton("Walidacja XMLa zadanym plikiem XSD");
        RadioButton radioButton3 = new RadioButton("W przygotowaniu");
        RadioButton radioButton4 = new RadioButton("W przygotowaniu");

        ToggleGroup radioGroup = new ToggleGroup();

        radioButton1.setToggleGroup(radioGroup);
        radioButton1.setSelected(true);
        radioButton2.setToggleGroup(radioGroup);
        radioButton3.setToggleGroup(radioGroup);
        radioButton4.setToggleGroup(radioGroup);

        VBox vboxRB = new VBox(radioButton1, radioButton2, radioButton3, radioButton4);
        
        Button btnRadio = new Button("Wybierz");
		btnRadio.setOnAction((event) -> {
			RadioButton selectedRadioButton =
			        (RadioButton) radioGroup.getSelectedToggle();
			if (selectedRadioButton.equals(radioButton1))
			  PrzykladyXML.utworzenieXML(stage); 
			else if (selectedRadioButton.equals(radioButton2))
  			  PrzykladyXML.walidacjaXMLzadanymXSD(stage);  					
			else if (selectedRadioButton.equals(radioButton3))
  			  Pomocnicze.komunikat("Opcja w przygotowaniu");  					
			else if (selectedRadioButton.equals(radioButton4))
				Pomocnicze.komunikat("Opcja w przygotowaniu");  					

		});
		Button btnWyjscie = new Button("Wyjscie");
  		btnWyjscie.setOnAction((event) -> {
			stage.close();
		});
        VBox vbox = new VBox(vboxRB, btnRadio, btnWyjscie);
		Scene scene = new Scene(vbox, 200, 100);
        stage.setScene(scene);
        stage.show();
    }
}
