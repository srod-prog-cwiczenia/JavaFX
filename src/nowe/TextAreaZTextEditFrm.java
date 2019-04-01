package nowe;

import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextAreaZTextEditFrm {
	  private static TextField textField;
	  public static String getTextField() {
		  return textField.getText();		  
	  }
	  public static void setTextField(String tresc) {
		  textField.setText(tresc);		  
	  }
	  private static TextArea textArea;
	  public static void dopiszDoTextArea(String tresc) {
		  textArea.setText(textArea.getText() + "\n" + tresc);
	  }
	  public static void pokazArrayListLancuchow(List<String> kolekcja, String tytul, EventHandler<ActionEvent> eh) {
	      Stage formatkaN2 = new Stage();
	      formatkaN2.setTitle(tytul);
	      textArea = new TextArea();

	      Button button = new Button("Wyjscie");
	      button.setMinWidth(50);
	      
	      textArea.setText(kolekcja.toString());
	      
	      button.setOnAction(action -> {
            formatkaN2.close();	          
	      });

          textField = new TextField();

	      Button btnAkceptuj = new Button("Akceptuj tekst");
	      btnAkceptuj.setOnAction(eh);

	      VBox vbox = new VBox(textField, btnAkceptuj);
	      HBox hbox = new HBox(textArea, vbox);

	      Scene scene = new Scene(hbox, 650, 450);
	      formatkaN2.setScene(scene);
	      formatkaN2.show();
	  }
	  public static void pokazArrayListLancuchow(List<String> kolekcja) {
		  pokazArrayListLancuchow(kolekcja, "wyswietlenie listy lancuchow", 
			 new EventHandler<ActionEvent>() {
			  public void handle(ActionEvent event) {
				  dopiszDoTextArea(getTextField());
				  setTextField("");
			  }});
	  }
}
