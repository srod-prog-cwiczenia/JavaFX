package aplikacja;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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

public class TrzeciaFormatka {
	final static int LICZBA_ITEM_MENU = 6;
	public static void pokaz() {
		Stage formatka3 = new Stage();
	    formatka3.setTitle("Trzecia formatka");
		BorderPane root = new BorderPane();
	    Scene scene = new Scene(root, 600, 650, Color.LIGHTGREEN);

	    MenuBar menuBar = new MenuBar();
	    menuBar.prefWidthProperty().bind(formatka3.widthProperty());
	    root.setTop(menuBar);
	    
	 // tablica nazw opcji
	    String[] nazwyOpcji = new String[] {
		  "Canvas", "Uruchomienie menu", "Test paska postępu", "Odnoga projektu nr 2",
		  "Odnoga projektu nr 3", "Piata formatka"};
	//komponent MenuButton:
	    MenuItem mITab[] = new MenuItem[LICZBA_ITEM_MENU];
	    for (int ii = 0; ii < LICZBA_ITEM_MENU; ii++) {
	    	mITab[ii] = new MenuItem(nazwyOpcji[ii]);
	    }
	    for (int ii = 0; ii < LICZBA_ITEM_MENU; ii++) {
		  switch (ii) {
			case 0:	
				mITab[ii].setOnAction(event -> {
					DrugaFormatka.pokaz(0);
					DrugaFormatka.pokaz(1);
				}); break;
			case 1:
				mITab[ii].setOnAction(event -> {
					//TrzeciaFormatka.pokaz(); - to jest ona sama, więc na razie wyłączamy ten item
				}); break;
			case 2:
				mITab[ii].setOnAction(event -> {
			        CzwartaFormatka.pokaz();
				}); break;
			case 3:	   
				mITab[ii].setOnAction(event -> {
					GlownaKlasa2.pokaz();
	    			}); break;
			case 4:
				mITab[ii].setOnAction(event -> {
					GlownaKlasa3.pokaz();
	    			}); break;
			case 5:
				mITab[ii].setOnAction((event) -> {
					PiataFormatka.pokaz();
				}); break;
		  }
	    } 	    
	    	    
	    // File menu - new, save, exit
	    Menu fileMenu = new Menu("Opcje skopiowane z glownej formatki");
	    MenuItem exitMenuItem = new MenuItem("Wyjscie");
	    exitMenuItem.setOnAction(actionEvent -> formatka3.close());

	    fileMenu.getItems().addAll(mITab);
	    fileMenu.getItems().addAll(new SeparatorMenuItem(), exitMenuItem);

	    Menu webMenu = new Menu("Checkouty");
	    CheckMenuItem opcja1MenuItem = new CheckMenuItem("Opcja 1");
	    opcja1MenuItem.setSelected(true);
	    webMenu.getItems().add(opcja1MenuItem);

	    CheckMenuItem opcja2MenuItem = new CheckMenuItem("Opcja 2");
	    opcja2MenuItem.setSelected(true);
	    webMenu.getItems().add(opcja2MenuItem);

	    Menu sqlMenu = new Menu("SQL");
	    ToggleGroup tGroup = new ToggleGroup();
	    RadioMenuItem mysqlItem = new RadioMenuItem("MySQL");
	    mysqlItem.setToggleGroup(tGroup);

	    RadioMenuItem oracleItem = new RadioMenuItem("Oracle");
	    oracleItem.setToggleGroup(tGroup);
	    oracleItem.setSelected(true);

	    sqlMenu.getItems().addAll(mysqlItem, oracleItem,
	        new SeparatorMenuItem());

	    Menu podmenuMnu = new Menu("Podmenu");
	    podmenuMnu.getItems().addAll(
	        new CheckMenuItem("Opcja 1"),
	        new CheckMenuItem("Opcja 2"),
	        new CheckMenuItem("Opcja 3"));

	    sqlMenu.getItems().add(podmenuMnu);

	    menuBar.getMenus().addAll(fileMenu, webMenu, sqlMenu);

	    formatka3.setScene(scene);
	    formatka3.show();	
	  }
}
