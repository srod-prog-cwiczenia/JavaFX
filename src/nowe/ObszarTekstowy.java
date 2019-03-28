package nowe;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class ObszarTekstowy {
	  public static void pokazArrayListLancuchow(List<String> kolekcja, String tytul) {
	      Stage formatkaN1 = new Stage();
	      formatkaN1.setTitle(tytul);
	      TextArea textArea = new TextArea();

	      Button button = new Button("Wyjscie");
	      button.setMinWidth(50);
	      
	      textArea.setText(kolekcja.toString());
	      
	      button.setOnAction(action -> {
            formatkaN1.close();	          
	      });

	      VBox vbox = new VBox(textArea, button);
	      Scene scene = new Scene(vbox, 550, 350);
	      formatkaN1.setScene(scene);
	      formatkaN1.show();
	  }
	  public static void pokazArrayListLancuchow(List<String> kolekcja) {
		  pokazArrayListLancuchow(kolekcja, "wyswietlenie listy lancuchow");
	  }
	  public static void pokaz() {
	      Stage formatkaN1 = new Stage();
	      formatkaN1.setTitle("formatka z pakietu nowe");
	      TextArea textArea = new TextArea();

	      Button btnSumowanie = new Button("Podsumowanie wierszy będących liczbami");
	      btnSumowanie.setMinWidth(50);

	      btnSumowanie.setOnAction(action -> {
	          String tab[] = textArea.getText().split("\n");
	          List<String> lista = Arrays.asList(tab);
	          int sigma = 0;
	          for (String linia : lista) {
	        	  int liczba;
	        	  try {
	        		  liczba = Integer.parseInt(linia);
	        	  } catch (NumberFormatException e) {
	        		  liczba = 0;
	        	  }
	        	  sigma += liczba;
	          }
	   	      textArea.setText(textArea.getText() + "\n" + sigma);
	      });


          FileChooser wybierakPliku = new FileChooser();
	      Button btnWybierzPlik = new Button("Wybierz plik do wczytania");
	      btnWybierzPlik.setOnAction(e -> {
	    	  File wybranyPlik = wybierakPliku.showOpenDialog(formatkaN1);
//TODO: dorobic wczytywanie tego pliku do textarea	    	  
	      });
	      
	      VBox vbox = new VBox(textArea, btnSumowanie, btnWybierzPlik);
	      Scene scene = new Scene(vbox, 500, 300);
	      formatkaN1.setScene(scene);
	      formatkaN1.show();
	  }

}




   
