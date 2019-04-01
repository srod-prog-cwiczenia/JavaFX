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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class KontekstoweMenuFrm {
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

		Scene scene = new Scene(root, 600, 300);
		formatkaMK.setScene(scene);
		formatkaMK.show();
	}
}

