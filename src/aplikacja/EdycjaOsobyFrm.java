package aplikacja;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import narzedzia.Pomocnicze;
import nowe.ObszarTekstowy;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;


public class EdycjaOsobyFrm {
	public static class OsobaKlasaWewn implements Comparable<OsobaKlasaWewn>, Serializable {
		/**
		 * to ponizej wymagane przez interface Serializable 
		 */
		private static final long serialVersionUID = -3709610380471390993L;
		String imie, nazwisko, komentarz;

		public OsobaKlasaWewn() {}
		
	    public OsobaKlasaWewn(String imie, String nazwisko, String komentarz) {
	        this.imie = imie;
	        this.nazwisko = nazwisko;
	        this.komentarz = komentarz;
	    }

		public String getImie() {
			return imie;
		}

		public void setImie(String imie) {
			this.imie = imie;
		}

		public String getNazwisko() {
			return nazwisko;
		}

		public void setNazwisko(String nazwisko) {
			this.nazwisko = nazwisko;
		}

		public String getKomentarz() {
			return komentarz;
		}

		public void setKomentarz(String komentarz) {
			this.komentarz = komentarz;
		}

		@Override
		public String toString() {
			return "Osoba [imie=" + imie + ", nazwisko=" + nazwisko + ", komentarz=" + komentarz + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((imie == null) ? 0 : imie.hashCode());
			result = prime * result + ((komentarz == null) ? 0 : komentarz.hashCode());
			result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			OsobaKlasaWewn other = (OsobaKlasaWewn) obj;
			if (imie == null) {
				if (other.imie != null)
					return false;
			} else if (!imie.equals(other.imie))
				return false;
			if (komentarz == null) {
				if (other.komentarz != null)
					return false;
			} else if (!komentarz.equals(other.komentarz))
				return false;
			if (nazwisko == null) {
				if (other.nazwisko != null)
					return false;
			} else if (!nazwisko.equals(other.nazwisko))
				return false;
			return true;
		}
		@Override
		public int compareTo(OsobaKlasaWewn oso) {
			int wynik = this.nazwisko.compareTo(oso.nazwisko);
			if (wynik != 0) return wynik;
			wynik = this.imie.compareTo(oso.imie);
			if (wynik != 0) return wynik;
			wynik = this.komentarz.compareTo(oso.komentarz);
			return wynik;
			
		} 
	}

	public static void pokaz() {
		List<OsobaKlasaWewn> kolekcja = new ArrayList<OsobaKlasaWewn>();
		Set<OsobaKlasaWewn> zbiorOso = new HashSet<OsobaKlasaWewn>();

		Stage formatka5 = new Stage();
		formatka5.setTitle("Edycja danych osoby");
		StackPane root5 = new StackPane();
//Stworzenie pojemnika GridPane 
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
//Zdefiniowanie pola Imie
		final TextField imie = new TextField();
		imie.setPromptText("Podaj swoje imie.");
		imie.setPrefColumnCount(10);
		imie.getText();
		GridPane.setConstraints(imie, 0, 0);
		grid.getChildren().add(imie);
//Zdefiniowanie pola nazwisko:
		final TextField nazwisko = new TextField();
		nazwisko.setPromptText("Podaj swoje nazwisko.");
		GridPane.setConstraints(nazwisko, 0, 1);
		grid.getChildren().add(nazwisko);
//Zdefiniowanie pola komentarz:
		final TextField komentarz = new TextField();
		komentarz.setPrefColumnCount(15);
		komentarz.setPromptText("Napisz uwagi.");
		GridPane.setConstraints(komentarz, 0, 2);
		grid.getChildren().add(komentarz);
//Zdefiniowanie przycisku Skasuj
		Button btnSkasuj = new Button("Skasuj");
		GridPane.setConstraints(btnSkasuj, 1, 1);
		grid.getChildren().add(btnSkasuj);
//akcja przycisku Skasuj:
		btnSkasuj.setOnAction((event) -> {
			imie.setText("");
			nazwisko.setText("");
			komentarz.setText("");
		});
//Zdefiniowanie przycisku Wyslij
		Button btnWyslij = new Button("Akceptuj");
		GridPane.setConstraints(btnWyslij, 1, 0);
		grid.getChildren().add(btnWyslij);
//akcja przycisku Wyslij:
		btnWyslij.setOnAction((event) -> {
			OsobaKlasaWewn oso = new OsobaKlasaWewn();			
			oso.imie = imie.getText();
			oso.nazwisko = nazwisko.getText();
			oso.komentarz = komentarz.getText();
			kolekcja.add(oso);
			btnSkasuj.getOnAction().handle(null); //aby skasować pola - null to wartość akcji
		});
//Zdefiniowanie przycisku sortuj
		Button btnSortuj = new Button("Posortuj");
		GridPane.setConstraints(btnSortuj, 1, 5);
		grid.getChildren().add(btnSortuj);
//akcja przycisku Sortuj:
		btnSortuj.setOnAction((event) -> {
			Collections.sort(kolekcja);
		});
//Zdefiniowanie przycisku Pokaz
		Button btnPokaz = new Button("Pokaz kolekcje");
		GridPane.setConstraints(btnPokaz, 1, 3);
		grid.getChildren().add(btnPokaz);
//akcja przycisku Pokaz:
		btnPokaz.setOnAction((event) -> {
//			List<String> lancuchy = 
//to nie chce sie przekomilowac:     		kolekcja.stream().map(object -> Osoba.toString(object, null)).collect(Collectors.toList());
	        List<String> lLancuchy = new ArrayList<String>();
	        lLancuchy.add(Pomocnicze.zbudujNaglowekStringBuilder("Array list", 70) + "\n");
	        for (OsobaKlasaWewn oso : kolekcja) {
	        	lLancuchy.add(oso.toString() + "\n");
	        };
   			zbiorOso.addAll(kolekcja);
   			lLancuchy.add(Pomocnicze.zbudujNaglowekStringBuilder("Hash set", 70) + "\n");
   			for (OsobaKlasaWewn oso : zbiorOso) {
	        	lLancuchy.add(oso.toString() + "\n");
	        };
	        ObszarTekstowy.pokazArrayListLancuchow(lLancuchy, "kolekcja wprowadzonych osob oraz zbior wprowadzonych osob:");	        
		});

//Zdefiniowanie przycisku PokazGrid
		Button btnPokazGrid = new Button("Pokaz Grid");
		GridPane.setConstraints(btnPokazGrid, 1, 4);
		grid.getChildren().add(btnPokazGrid);
//akcja przycisku PokazGrid:
		btnPokazGrid.setOnAction((event) -> {
		   	TableWidokFrm.pokaz(FXCollections.observableArrayList(kolekcja));		   	
		});
		
		//Zdefiniowanie przycisku Zapisz
		Button btnZapisz = new Button("Zapisz");
		GridPane.setConstraints(btnZapisz, 1, 7);
		grid.getChildren().add(btnZapisz);
		//TODO: oprogramowac odczyt (nie mam juz na to czasu :) )
//akcja przycisku Zapisz:
		btnZapisz.setOnAction((event) -> {
			FileChooser wybierakPliku = new FileChooser();
            FileChooser.ExtensionFilter filtrRozszerzen = new FileChooser.ExtensionFilter("Pliki DAT (*.dat)", "*.dat");
            wybierakPliku.getExtensionFilters().add(filtrRozszerzen);
            wybierakPliku.setInitialDirectory(new File(System.getProperty("user.home")));
            wybierakPliku.setInitialFileName("serializacjaOsobyJava.dat");

            File plik = wybierakPliku.showSaveDialog(formatka5);
            
            if (plik == null) {
            	return;
            }
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;
			try {
				fos = new FileOutputStream(plik); 
		        oos = new ObjectOutputStream(fos); 
   		        oos.writeObject(kolekcja);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (oos != null) oos.close();
				} catch (IOException e) {}
				try {
					if (fos != null) fos.close();
				} catch (IOException e) {}
			}
		});
		//Zdefiniowanie przycisku Wczytaj
		Button btnWczytaj = new Button("Wczytaj");
		GridPane.setConstraints(btnWczytaj, 1, 6);
		grid.getChildren().add(btnWczytaj);
//akcja przycisku Wczytaj:
		btnWczytaj.setOnAction((event) -> {
			boolean nadpisanie = false;
			if (!kolekcja.isEmpty()) {
				Alert customAlert = new Alert(AlertType.CONFIRMATION);
				customAlert.setResizable(true);
				customAlert.setX(50);
				customAlert.setWidth(800); //TODO: z jakis powodow to nie dziala
				customAlert.setTitle("W pamieci znajduje sie juz wczytana kolekcja " + kolekcja.size() + " osob.");
				customAlert.setHeaderText("W pamieci znajduje sie juz wczytana kolekcja " + kolekcja.size() + " osob.");
				customAlert.setContentText("Co chcesz zrobic?");
				ButtonType buttonCA1 = new ButtonType("Dodac do niej zawartosc pliku");
				ButtonType buttonCA2 = new ButtonType("Skasowac i nadpisac plikiem");
				ButtonType buttonCACancel = new ButtonType("Wyjdz i nic nie rob", ButtonData.CANCEL_CLOSE);

				customAlert.getButtonTypes().setAll(buttonCA1, buttonCA2, buttonCACancel);

				Optional<ButtonType> wybranyKlawisz = customAlert.showAndWait();
				if (wybranyKlawisz.get() == buttonCA1){
					nadpisanie = false;
				} else if (wybranyKlawisz.get() == buttonCA2) {
					nadpisanie = true;
				} else {
			      return;
				}
			}	
			FileChooser wybierakPliku = new FileChooser();
            FileChooser.ExtensionFilter filtrRozszerzen = new FileChooser.ExtensionFilter("Pliki DAT (*.dat)", "*.dat");
            wybierakPliku.getExtensionFilters().add(filtrRozszerzen);
            wybierakPliku.setInitialDirectory(new File(System.getProperty("user.home")));
            wybierakPliku.setInitialFileName("serializacjaOsobyJava.dat");
            File wybranyPlik = wybierakPliku.showOpenDialog(formatka5);
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {
            	fis = new FileInputStream(wybranyPlik);  
            	ois = new ObjectInputStream(fis);
            	if (nadpisanie)
            		kolekcja.clear();
/** instrukcja taka jak ponizej dziala ale generuje warning,
 *  spowodowany rzutowaniem parametru generycznego na Collection
 *  okazuje sie ze mozna to zastapic kodem ponizej ale pewnie dziala on duzo
 *  wolniej...? 
 *             	kolekcja.addAll((ArrayList<OsobaKlasaWewn>) ois.readObject());
 */
            	Object obiekt = ois.readObject();
            	ArrayList<?> kolekcjaObiektow = (ArrayList<?>) obiekt;
            	for (Object oo : kolekcjaObiektow) {
            		kolekcja.add((OsobaKlasaWewn) oo);
            	}
            } catch (FileNotFoundException e) {
              e.printStackTrace();
            } catch (IOException e) {
              e.printStackTrace();
            } catch (ClassNotFoundException e) {
              e.printStackTrace();
            } finally {
              try {
                if (ois != null) ois.close();
              } catch (IOException e) {}
              try {
                if (fis != null) fis.close();
              } catch (IOException e) {}
            }            
		});

		Scene scene = new Scene(grid, 400, 350);
		formatka5.setScene(scene);
		formatka5.show();
	}
}
