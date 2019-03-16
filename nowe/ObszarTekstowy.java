package nowe;

import java.util.Arrays;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class ObszarTekstowy {
	  public static void pokazArrayListLancuchow(List<String> kolekcja) {
	      Stage formatkaN1 = new Stage();
	      formatkaN1.setTitle("wyswietlenie tekstu");
	      TextArea textArea = new TextArea();

	      Button button = new Button("Wyjscie");
	      button.setMinWidth(50);
	      
	      textArea.setText(kolekcja.toString());
	      
	      button.setOnAction(action -> {
   	 
	          
	      });

	      VBox vbox = new VBox(textArea, button);
	      Scene scene = new Scene(vbox, 550, 350);
	      formatkaN1.setScene(scene);
	      formatkaN1.show();
	  }
	  public static void pokaz() {
	      Stage formatkaN1 = new Stage();
	      formatkaN1.setTitle("formatka z pakietu nowe");
	      TextArea textArea = new TextArea();

	      Button button = new Button("Click to get text");
	      button.setMinWidth(50);

	      button.setOnAction(action -> {
	          String tab[] = textArea.getText().split("\n");
	          List<String> lista = Arrays.asList(tab);
	          int sigma = 0;
	          for (String linia : lista) {
	        	  sigma += Integer.parseInt(linia);
	          }
	    	 
//	          System.out.println(textArea.getText());

	          textArea.setText(textArea.getText() + "\n" + sigma);
	          
	      });

	      VBox vbox = new VBox(textArea, button);

	      Scene scene = new Scene(vbox, 500, 300);
	      formatkaN1.setScene(scene);
	      formatkaN1.show();
	  }

}




   
