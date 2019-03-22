package nowe;

import java.util.Arrays;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextAreaZTextEditFrm {
	  public static void pokazArrayListLancuchow(List<String> kolekcja, String tytul) {
	      Stage formatkaN2 = new Stage();
	      formatkaN2.setTitle(tytul);
	      TextArea textArea = new TextArea();

	      Button button = new Button("Wyjscie");
	      button.setMinWidth(50);
	      
	      textArea.setText(kolekcja.toString());
	      
	      button.setOnAction(action -> {
            formatkaN2.close();	          
	      });

          TextField textField = new TextField();

	      Button btnAkceptuj = new Button("Akceptuj tekst");

	      btnAkceptuj.setOnAction(action -> {
	          System.out.println(textField.getText());
	      });

	      VBox vbox = new VBox(textField, btnAkceptuj);
	      HBox hbox = new HBox(textArea, vbox);

	      Scene scene = new Scene(hbox, 650, 450);
	      formatkaN2.setScene(scene);
	      formatkaN2.show();
	  }
	  public static void pokazArrayListLancuchow(List<String> kolekcja) {
		  pokazArrayListLancuchow(kolekcja, "wyswietlenie listy lancuchow");
	  }
}
