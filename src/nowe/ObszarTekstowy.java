package nowe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import narzedzia.Pomocnicze;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;


public class ObszarTekstowy {
	  public static void wczytaniePliku(File plik, TextArea aTextArea) {
		  if (!plik.exists()) {
			  Pomocnicze.komunikat("Nie ma pliku " + plik.getName());
			  return;
		  }
		  try {
			FileReader fr = new FileReader(plik);
			int rozmiarPliku = (int)plik.length();
			char [] buffor = new char[rozmiarPliku];
			fr.read(buffor, 0, rozmiarPliku);
			String strZPliku = new String(buffor);
			fr.close();
			aTextArea.setText(strZPliku);
		  } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }
	  }
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

	      Tooltip ttSumowanie = new Tooltip("Wybiera do sumowania tylko te wiersze\nktore daja sie przekonwertowac do liczby");
	      Button btnSumowanie = new Button("Podsumowanie wierszy będących liczbami");
	      btnSumowanie.setMinWidth(50);
	      btnSumowanie.setTooltip(ttSumowanie);
	      
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
	    	  wczytaniePliku(wybranyPlik, textArea);
	      });
	      
	      VBox vbox = new VBox(textArea, btnSumowanie, btnWybierzPlik);
	      Scene scene = new Scene(vbox, 500, 300);
	      formatkaN1.setScene(scene);
	      formatkaN1.show();
	  }

}




   
