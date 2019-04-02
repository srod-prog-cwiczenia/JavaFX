package nowe;

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

public class TextAreaZTextEdit2Frm {
	protected TextField textField;
	protected Stage formatkaN2;
	protected Button button;
	protected Button btnAkceptuj; 
	protected VBox vbox;
	protected HBox hbox;
	protected Scene scene;
	protected TextArea textArea;
    public void akcjaBtnAkceptuj() {
    	System.out.println("Nie jestem wirtualna!");
    }
    public TextAreaZTextEdit2Frm(String tytul) {
			super();
			formatkaN2 = new Stage();
			formatkaN2.setTitle(tytul);
			textArea = new TextArea();

		    button = new Button("Wyjscie");
		    button.setMinWidth(50);
		    button.setOnAction(action -> {
		    	formatkaN2.close();	          
		    });
	        textField = new TextField();

	        btnAkceptuj = new Button("Akceptuj tekst");
	        btnAkceptuj.setOnAction(new EventHandler<ActionEvent>() {
				  public void handle(ActionEvent event) {
					  akcjaBtnAkceptuj();
			       }
			  }
	        );	          
		    vbox = new VBox(textField, btnAkceptuj);
		    //hbox = new HBox(textArea, vbox);
		    /**
		    * vbox2 by pole edycyjne zajmowalo caly jeden poziom
		    * zmienna vbox2 jest poki co lokalna, ale moze byc rownie
		    * dobrze polem klasy.
		    */
		    VBox vbox2 = new VBox(textArea, vbox);
		    scene = new Scene(vbox2, 650, 450);
		    formatkaN2.setScene(scene);
		    formatkaN2.show();
    }
	public void pokazArrayListLancuchow(List<String> kolekcja) {
	      textArea.setText(kolekcja.toString());
    }
}
