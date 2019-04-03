package aplikacja;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class KontekstoweMenuFrm {
    //TODO: zmienne w klasie ktore dotycza tylko kolka to chyba nienajlepszy pomysl?
	public static double orgSceneX, orgSceneY;
	public static double orgTranslateX, orgTranslateY;
	     
	public static void pokaz() {
		Stage formatkaMK = new Stage();
		formatkaMK.setTitle("Prezentacja menu kontekstowego");
		//StackPane rootMK = new StackPane();
		Label label = new Label();
		Circle kolko = new Circle();
		kolko.setRadius(80);
		kolko.setFill(Color.CORAL);
		VBox root = new VBox();
		root.setPadding(new Insets(5));
		root.setSpacing(5);
		root.getChildren().addAll(label, kolko);

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
	    kolko.setOnMousePressed(kolkoOnMousePressedEventHandler);
	    kolko.setOnMouseDragged(kolkoOnMouseDraggedEventHandler);
		Scene scene = new Scene(root, 600, 300);
		formatkaMK.setScene(scene);
		formatkaMK.show();
	}
}

