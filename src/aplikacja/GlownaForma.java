package aplikacja;

import javafx.application.Application;
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
final static int LICZBA_ITEM_MENU = 6;
@Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Główna formatka");
/*
    Button btn1 = new Button();
    btn1.setText("Start");
    btn1.setOnAction((event) -> {
      DrugaFormatka.pokaz();        
    });
         
    Button btn2 = new Button();
    btn2.setText("Uruchomienie menu");
    btn2.setOnAction((event) -> {
        TrzeciaFormatka.pokaz();        
    });
   
    Button btn3 = new Button();
    btn3.setText("Test paska postępu");
    btn3.setOnAction((event) -> {
        CzwartaFormatka.pokaz();
    });

    Button btn4 = new Button();
    btn4.setText("Odnoga projektu nr 2");
    btn4.setOnAction((event) -> {
        GlownaKlasa2.pokaz();
    });

    Button btn5 = new Button();
    btn5.setText("Odnoga projektu nr 3");
    btn5.setOnAction((event) -> {
        GlownaKlasa3.pokaz();
    });

    Button btn6 = new Button();
    btn6.setText("Piata formatka");
    btn6.setOnAction((event) -> {
        PiataFormatka.pokaz();
    });*/ // zbedne bo juz jest menubutton
// tablica nazw opcji
    String[] nazwyOpcji = new String[] {
	"Canvas", "Uruchomienie menu", "Test paska postępu", "Odnoga projektu nr 2",
	"Odnoga projektu nr 3", "Piata formatka"};
//komponent MenuButton:
    MenuItem mITab[] = new MenuItem[LICZBA_ITEM_MENU];
    for (int ii = 0; ii < LICZBA_ITEM_MENU; ii++) {
	mITab[ii] = new MenuItem(nazwyOpcji[ii]);
    }
    MenuButton mButton = new MenuButton("Opcje", null, mITab);
    HBox hbox = new HBox(mButton);

 /*   Scene scene = new Scene(hbox, 200, 100);
    primaryStage.setScene(scene);
    primaryStage.show(); */ // to poki co zbedne bo ponizej ustawiamy to na flowpanelu:
    for (int ii = 0; ii < LICZBA_ITEM_MENU; ii++) {
	switch (ii) {
		case 0:	
			mITab[ii].setOnAction(event -> {
				DrugaFormatka.pokaz(1);        	
			}); break;
		case 1:
			mITab[ii].setOnAction(event -> {
				TrzeciaFormatka.pokaz();
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
//    StackPane root = new StackPane();
    FlowPane flow = new FlowPane();
    flow.setVgap(8);
    flow.setHgap(4);
    flow.setPrefWrapLength(300); // preferred width = 300
    flow.getChildren().addAll(/*btn1, btn2, btn3, btn4, btn5, btn6, */hbox);
    primaryStage.setScene(new Scene(flow, 500, 550));
    primaryStage.show();
  }
}
