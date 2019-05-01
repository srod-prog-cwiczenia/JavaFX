package aplikacja;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javajava.JavaJava;
import narzedzia.Pomocnicze;
import nowe.ObiektyGraficzneFrm;
import nowe.TextAreaConsoleFrm;
import nowe.TextAreaZTextEdit2Frm;
import przyklady.PobranieHTTP;

public class GlowneMenuFrm {
	public static void pokaz(Stage glowneStage) {
		Stage formatka3;
		if (glowneStage == null) {
			formatka3 = new Stage();
		} else {
			formatka3 = glowneStage;
		}
		formatka3.setTitle("Glowna formatka programu");
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 600, 650, Color.LIGHTGREEN);

		MenuBar menuBar = new MenuBar();
		menuBar.prefWidthProperty().bind(formatka3.widthProperty());
		root.setTop(menuBar);
//block checkoutow:
		Menu checkoutMenu = new Menu("Opcje programu");
		CheckMenuItem opcja1MenuItem = new CheckMenuItem("Tilepane w Odnodze 2 programu");
		opcja1MenuItem.setSelected(true);
		checkoutMenu.getItems().add(opcja1MenuItem);

		CheckMenuItem opcja2MenuItem = new CheckMenuItem("Opcja 2");
		opcja2MenuItem.setSelected(true);
		checkoutMenu.getItems().add(opcja2MenuItem);

		// tablica nazw opcji
		String[] nazwyOpcji = new String[] { "Pobranie danych z Sieci", 
				"Menu kontekstowe (przyklad)", "Test paska postępu",
				"Odnoga projektu nr 2", "Komponent Suwak", "Edycja danych osoby" };
		int liczbaItemMenu = nazwyOpcji.length;
		// komponent MenuButton:
		MenuItem mITab[] = new MenuItem[liczbaItemMenu];
		for (int ii = 0; ii < liczbaItemMenu; ii++) {
			mITab[ii] = new MenuItem(nazwyOpcji[ii]);
		}
		for (int ii = 0; ii < liczbaItemMenu; ii++) {
			switch (ii) {
			case 0:
				mITab[ii].setOnAction(event -> {
					PobranieHTTP te2frm = new PobranieHTTP("Pobranie zrodla strony");
				});
				break;
			case 1:
				mITab[ii].setOnAction(event -> {
					KontekstoweMenuFrm.pokaz();
				});
				break;
			case 2:
				mITab[ii].setOnAction(event -> {
					PasekPostepuFrm.pokaz();
				});
				break;
			case 3:
				mITab[ii].setOnAction(event -> {
					GlownaKlasa2.pokaz(opcja1MenuItem.isSelected());
				});
				break;
			case 4:
				mITab[ii].setOnAction(event -> {
					GlownaKlasa3.pokaz();
				});
				break;
			case 5:
				mITab[ii].setOnAction((event) -> {
					EdycjaOsobyFrm.pokaz();
				});
				break;
			}
		}

		// File menu - new, save, exit
		Menu fileMenu = new Menu("Przeglad komponentow");
		MenuItem exitMenuItem = new MenuItem("Wyjscie");
		exitMenuItem.setOnAction(actionEvent -> formatka3.close());

		fileMenu.getItems().addAll(mITab);
		fileMenu.getItems().addAll(new SeparatorMenuItem(), exitMenuItem);

		Menu plotnoMenu = new Menu("Grafika");
		ToggleGroup tGroup = new ToggleGroup();
		RadioMenuItem plotno1Item = new RadioMenuItem("Grafika 1");
		plotno1Item.setToggleGroup(tGroup);

		RadioMenuItem plotno2Item = new RadioMenuItem("Grafika 2");
		plotno2Item.setToggleGroup(tGroup);
		plotno2Item.setSelected(true);

		MenuItem plotnoPokazMenu = new MenuItem("Wybrana grafika (pokaz)");
		plotnoMenu.getItems().addAll(plotno1Item, plotno2Item, new SeparatorMenuItem(), plotnoPokazMenu);

		plotnoPokazMenu.setOnAction(event -> {
			// TODO: do wypelnienia
			if (plotno1Item.isSelected()) {
				PlotnoFrm.pokaz(0);
			}
			if (plotno2Item.isSelected()) {
				PlotnoFrm.pokaz(1);
			}
		});

		Menu mnuPodmenuGrafikaMnu = new Menu("Podmenu (różne przyklady)"); 
		plotnoMenu.getItems().add(mnuPodmenuGrafikaMnu);
		MenuItem mnuPodmenuGrafikaMnu1 = new MenuItem("Obiekty graficzne"); 
		mnuPodmenuGrafikaMnu1.setOnAction((event) -> {
			ObiektyGraficzneFrm.pokaz();
		});
		MenuItem mnuPodmenuGrafikaMnu2 = new MenuItem("Opcja pusta"); 
		mnuPodmenuGrafikaMnu2.setOnAction((event) -> {
			Pomocnicze.komunikat("Do napisania");		
		});
		mnuPodmenuGrafikaMnu.getItems().addAll(mnuPodmenuGrafikaMnu1, mnuPodmenuGrafikaMnu2);
		
		Menu mnuPrzykladyJava = new Menu("Przyklady Java"); 
		Menu mnuPrzykladyJava1 = new Menu("Podmenu"); 
		mnuPrzykladyJava.getItems().add(mnuPrzykladyJava1);

		MenuItem mnuItemJavaJava = new MenuItem("JavaJava"); 
		mnuItemJavaJava.setOnAction((event) -> {
			JavaJava.start();
		});
		mnuPrzykladyJava1.getItems().add(mnuItemJavaJava);

		MenuItem mnuGraphConsole = new MenuItem("Graficzna emulacja konsoli - prezentacja"); 
		mnuGraphConsole.setOnAction((event) -> {
			TextAreaConsoleFrm cons = new TextAreaConsoleFrm();
			List<String> kolekcja = new ArrayList<String>();
			kolekcja.add("Napis nr 1");
			kolekcja.add("Napis nr 2");
			cons.pokaz(kolekcja);
			String wprowadzonyLancuch;
			do {
				wprowadzonyLancuch = cons.czytajLinie();
				if (!wprowadzonyLancuch.isEmpty())
					Pomocnicze.komunikat(wprowadzonyLancuch);
			} while (!wprowadzonyLancuch.isEmpty());
		});
		mnuPrzykladyJava1.getItems().add(mnuGraphConsole);
		

		Menu przykladCheckMenuMnu = new Menu("Przyklad checkmenu");
		przykladCheckMenuMnu.getItems().addAll(new CheckMenuItem("Opcja 1"), new CheckMenuItem("Opcja 2"),
				new CheckMenuItem("Opcja 3"));
		mnuPrzykladyJava.getItems().add(przykladCheckMenuMnu);
		
		
		menuBar.getMenus().addAll(fileMenu, checkoutMenu, plotnoMenu, mnuPrzykladyJava);

		formatka3.setScene(scene);
		formatka3.show();
	}
}
