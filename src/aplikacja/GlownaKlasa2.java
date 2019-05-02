package aplikacja;

import java.util.ArrayList;
import java.util.Arrays;

import helper.Analiza;
import helper.AnalizaDialog;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import narzedzia.Pomocnicze;
import nowe.BazaDanych;
import nowe.ObszarTekstowy;
import nowe.PrzykladMap;
import nowe.TextAreaZTextEditFrm;
import przyklady.Strumienie;

public class GlownaKlasa2 {
	public static String[] getTablicaOpisow() {
		return new String[] 
				{"Uruchomienie listy przykladow z opisem tego co sie dzieje na konsoli",
				 "Uruchomienie Text Area",
				 "Test strumieni",
				 "Rekurencja",
				 "Test mapy",
				 "Uruchomienie TextAreaZTextEditFrm", 
				 "Bazy danych - przykłady"
				};
	};
	
	public static void wybranaAkcja(int aNr, Stage aStage) {
		switch (aNr) {
		case 1:
			//TODO: uporzadkowac te dwie metody ponizej
			PrzykladyKonsolowe.akcja1();
			Scena2.pokaz1(aStage);
			break;
		case 2:
			ObszarTekstowy.pokaz();
			break;
		case 3:
			Strumienie.przyklad1();
			break;
		case 4:
			AnalizaDialog.run();
			break;
		case 5:
			(new PrzykladMap()).przyklad1();
			break;
		case 6:
			TextAreaZTextEditFrm.pokazArrayListLancuchow(
					new ArrayList<String>(
  				      Arrays.asList("Linia nr 1", "Linia nr 2", "Linia nr 3")), "",
					    new EventHandler<ActionEvent>() {
						  public void handle(ActionEvent event) {
						  TextAreaZTextEditFrm.dopiszDoTextArea(TextAreaZTextEditFrm.getTextField());
						  TextAreaZTextEditFrm.setTextField("");
						  }});
				break;
			case 7: 
				BazaDanych bd = new BazaDanych();
				if (bd.isPoprawnie()) {
					bd.testBazyDanych();
					bd.zamknieciePolaczenia();
				}	
				break;
		}
	} 

	public static void pokazComboBox() {
		Stage stage = new Stage();
		stage.setTitle("Odnoga projektu numer 2");
        stage.setWidth(550);
        stage.setHeight(550);
		Scene scene = new Scene(new Group(), 550, 550);
        ComboBox<String> cB = new ComboBox<String>();
        cB.getItems().addAll(getTablicaOpisow());
        Button btnAkceptuj = new Button("Akceptuj");
		btnAkceptuj.setOnAction((event) -> {
			int selItem = cB.getSelectionModel().getSelectedIndex();
			if (selItem >= 0) {
				wybranaAkcja(selItem + 1, stage);				
			}
		});
		
		Button btnWyjscie = new Button("Wyjście");
		btnWyjscie.setOnAction((event) -> {
			stage.close();
		});
		
        VBox vbox = new VBox();
        vbox.getChildren().addAll(cB, btnAkceptuj, btnWyjscie);
        vbox.setSpacing(5);

        HBox root = new HBox();
        root.getChildren().add(vbox);
        root.setSpacing(40);

        ((Group) scene.getRoot()).getChildren().add(root);
        stage.setScene(scene);
        stage.show();
	}
	
	public static void pokaz(boolean czyTilePane) {

		Stage primaryStage = new Stage();
		primaryStage.setTitle("Odnoga projektu numer 2");
		Button przycisk1 = new Button("Uruchomienie listy " +
				"przykladow z opisem tego co sie dzieje na konsoli");

		przycisk1.setOnAction((event) -> {
			wybranaAkcja(1, primaryStage);
		});

		Button przycisk2 = new Button("Uruchomienie Text Area");
		przycisk2.setOnAction((event) -> {
			wybranaAkcja(2, primaryStage);
		});
		
		Button przycisk3 = new Button("Test strumieni");
		przycisk3.setOnAction((event) -> {
			wybranaAkcja(3, primaryStage);
		});

		Button przycisk4 = new Button("Rekurencja");
		przycisk4.setOnAction((event) -> {
			wybranaAkcja(4, primaryStage);
		});

		Button przycisk6 = new Button("Test mapy");
		przycisk6.setOnAction((event) -> {
			wybranaAkcja(5, primaryStage);
		});

		Button przycisk7 = new Button("Uruchomienie TextAreaZTextEditFrm");
		przycisk7.setOnAction((event) -> {
			wybranaAkcja(6, primaryStage);
		});

		Button przycisk8 = new Button("Test bazy danych");
		przycisk8.setOnAction((event) -> {
			wybranaAkcja(7, primaryStage);
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
					przycisk3, przycisk4, przycisk6, 
					przycisk7, przycisk8, hboxRB, przycisk5, btnWyjscie);
		else 
			tp.getChildren().addAll(przycisk1, przycisk2, 
					przycisk3, przycisk4, przycisk6, 
					przycisk7, przycisk8, hboxRB, przycisk5, btnWyjscie);

		Scene scene = new Scene((tp == null ? fp : tp), 550, 550);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
}
