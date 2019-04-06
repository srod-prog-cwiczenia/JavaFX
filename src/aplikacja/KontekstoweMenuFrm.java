package aplikacja;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KontekstoweMenuFrm {
    //TODO: zmienne w klasie ktore dotycza tylko kolka to chyba nienajlepszy pomysl?
	public static double orgSceneX, orgSceneY;
	public static double orgTranslateX, orgTranslateY;

	final public static int ILE_KOLEK = 7;
	public static void pokaz() {
		Stage formatkaMK = new Stage();
		formatkaMK.setTitle("Prezentacja menu kontekstowego");
		//StackPane rootMK = new StackPane();
		Label label = new Label();
		List<Circle> kolekcjaKolek = new ArrayList<Circle>();
		for (int ii = 0; ii < ILE_KOLEK; ii++) {
			kolekcjaKolek.add(new Circle());
		}
		for (int ii = 0; ii < kolekcjaKolek.size(); ii++) {
			kolekcjaKolek.get(ii).setRadius(20 + 7 * ii);
			Color kolor = Color.CORAL;
			switch (ii) {
			case 1:
				kolor = Color.CHOCOLATE;
				break;
			case 2:
				kolor = Color.AQUA;
				break;
			case 3:
				kolor = Color.MAGENTA;
				break;
			case 4:
				kolor = Color.BISQUE;
				break;
			}

			kolekcjaKolek.get(ii).setFill(kolor);
		}	
		VBox root = new VBox();
		root.setPadding(new Insets(5));
		root.setSpacing(5);
		root.getChildren().add(label);
		root.getChildren().addAll(kolekcjaKolek);
		
        final ColorPicker wybierakKolorow = new ColorPicker();
        wybierakKolorow.setValue(Color.CORAL);
        
        final Text napis1 = new Text("Prosze wybrac kolor");
        napis1.setFont(Font.font ("Verdana", 20));
        napis1.setFill(wybierakKolorow.getValue());
/*
        root.getChildren().add(wybierakKolorow);
        colorPicker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                text.setFill(colorPicker.getValue());               
            }
        }); */ //TODO: na razie w ukryciu bo jest stale widoczny, trzeba to potem oprogramowac		
		
		
// stworzenie ContextMenu
		ContextMenu contextMenu = new ContextMenu();
		MenuItem item1 = new MenuItem("Opcja 1");
		item1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					label.setText("Wybrano opcję 1 menu kontekstowego");
				}

		});
		MenuItem item2 = new MenuItem("Opcja 2");
		item2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				label.setText("Wybrano opcję 2 menu kontekstowego");
			}
		});
	
// dodajemy MenuItem do ContextMenu
		contextMenu.getItems().addAll(item1, item2);
// akcja kiedy klikniemy prawym przyciskiem myszki na kolko
		for (Circle kolko : kolekcjaKolek)
			kolko.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
				@Override
				public void handle(ContextMenuEvent event) {
					contextMenu.show(kolko, event.getScreenX(), event.getScreenY());
				}
			});

/**
 * handlery do przeciagania myszka:		
 */
		EventHandler<MouseEvent> kolkoOnMousePressedEventHandler = 
			new EventHandler<MouseEvent>() {
		        @Override
		        public void handle(MouseEvent t) {
		            orgSceneX = t.getSceneX();
		            orgSceneY = t.getSceneY();
		            orgTranslateX = ((Circle)(t.getSource())).getTranslateX();
		            orgTranslateY = ((Circle)(t.getSource())).getTranslateY();
		        }
		    };
		     
	    EventHandler<MouseEvent> kolkoOnMouseDraggedEventHandler = 
	    	new EventHandler<MouseEvent>() {
		        @Override
		        public void handle(MouseEvent t) {
		            double offsetX = t.getSceneX() - orgSceneX;
		            double offsetY = t.getSceneY() - orgSceneY;
		            double newTranslateX = orgTranslateX + offsetX;
		            double newTranslateY = orgTranslateY + offsetY;
		             
		            ((Circle)(t.getSource())).setTranslateX(newTranslateX);
		            ((Circle)(t.getSource())).setTranslateY(newTranslateY);
		        }
	    };		
	    for (Circle kolko : kolekcjaKolek) {
		    kolko.setOnMousePressed(kolkoOnMousePressedEventHandler);
		    kolko.setOnMouseDragged(kolkoOnMouseDraggedEventHandler);
	    }
		Scene scene = new Scene(root, 1000, 700);
		formatkaMK.setScene(scene);
		formatkaMK.show();
	}
}

