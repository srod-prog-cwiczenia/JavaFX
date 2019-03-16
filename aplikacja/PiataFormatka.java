package aplikacja;

import java.time.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import nowe.ObszarTekstowy;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class PiataFormatka {
	static class Osoba {
		String imie, nazwisko, komentarz;

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
			Osoba other = (Osoba) obj;
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
		
	}

	public static void pokaz() {
		List<Osoba> kolekcja = new ArrayList<Osoba>();

		Stage formatka5 = new Stage();
		formatka5.setTitle("Piąta formatka");
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
		Button btnWyslij = new Button("Wyslij");
		GridPane.setConstraints(btnWyslij, 1, 0);
		grid.getChildren().add(btnWyslij);
//akcja przycisku Wyslij:
		btnWyslij.setOnAction((event) -> {
			Osoba oso = new Osoba();			
			oso.imie = imie.getText();
			oso.nazwisko = nazwisko.getText();
			oso.komentarz = komentarz.getText();
			kolekcja.add(oso);
			btnSkasuj.getOnAction().handle(null); //aby skasować pola - null to wartość akcji
		});
//Zdefiniowanie przycisku Pokaz
		Button btnPokaz = new Button("Pokaz");
		GridPane.setConstraints(btnPokaz, 1, 3);
		grid.getChildren().add(btnPokaz);
//akcja przycisku Pokaz:
		btnPokaz.setOnAction((event) -> {
//			List<String> lancuchy = 
//to nie chce sie przekomilowac:     		kolekcja.stream().map(object -> Osoba.toString(object, null)).collect(Collectors.toList());
	        List<String> lancuchy = new ArrayList<String>();
	        for (Osoba oso : kolekcja) {
	        	lancuchy.add(oso.toString() + "\n");
	        };
   			ObszarTekstowy.pokazArrayListLancuchow(lancuchy);
		});

		Scene scene = new Scene(grid, 400, 350);
		formatka5.setScene(scene);
		formatka5.show();
	}
}
