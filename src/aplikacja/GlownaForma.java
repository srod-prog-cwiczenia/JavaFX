package aplikacja;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;

public class GlownaForma extends Application {
	public static void main(String[] args) {
	    launch(args);
	}
@Override
  public void start(Stage primaryStage) {
	GlowneMenuFrm.pokaz(primaryStage);
  }
/**
 * stara wersja glownej formatki, obecnie do wykorzystania, bo jest nieuzywana 
 * @primaryStage - poczatkowa stage aplikacji
 */
  public void startPoprzednia(Stage primaryStage) {
    primaryStage.setTitle("Główna formatka");
// tablica nazw opcji
    String[] nazwyOpcji = new String[] {
	"Canvas", "Uruchomienie menu", "Test paska postępu", 
	"Odnoga projektu nr 2",
	"Komponent Suwak", "Wprowadzanie danych osob", "Koniec programu"};
    int liczbaItemMenu = nazwyOpcji.length;
//komponent MenuButton:
    MenuItem mITab[] = new MenuItem[liczbaItemMenu];
    for (int ii = 0; ii < liczbaItemMenu; ii++) {
	  mITab[ii] = new MenuItem(nazwyOpcji[ii]);
    }
    MenuButton mButton = new MenuButton("Opcje", null, mITab);
    HBox hbox = new HBox(mButton);

 /*   Scene scene = new Scene(hbox, 200, 100);
    primaryStage.setScene(scene);
    primaryStage.show(); */ // to poki co zbedne bo ponizej ustawiamy to na flowpanelu:
    for (int ii = 0; ii < liczbaItemMenu; ii++) {
	switch (ii) {
		case 0:	
			mITab[ii].setOnAction(event -> {
				PlotnoFrm.pokaz(1);        	
			}); break;
		case 1:
			mITab[ii].setOnAction(event -> {
				GlowneMenuFrm.pokaz(null);
			}); break;
		case 2:
			mITab[ii].setOnAction(event -> {
		        PasekPostepuFrm.pokaz();
			}); break;
		case 3:	   
			mITab[ii].setOnAction(event -> {
				GlownaKlasa2.pokaz(false);
    			}); break;
		case 4:
			mITab[ii].setOnAction(event -> {
				GlownaKlasa3.pokaz();
    			}); break;
		case 5:
			mITab[ii].setOnAction((event) -> {
				EdycjaOsobyFrm.pokaz();
			}); break;
		case 6:
			mITab[ii].setOnAction((event) -> {
				Platform.exit();
			}); break;
	}
    } 
//    StackPane root = new StackPane();
    FlowPane flow = new FlowPane();
    flow.setVgap(8);
    flow.setHgap(4);
    flow.setPrefWrapLength(300); // preferred width = 300
    flow.getChildren().addAll(hbox);
    primaryStage.setScene(new Scene(flow, 500, 550));
    primaryStage.show();
  }
}
