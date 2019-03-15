package aplikacja;

import java.awt.Insets;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Scena2 {

	public static void pokaz1(Stage stage) {
    	GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    //grid.setPadding(new Insets(25, 25, 25, 25));
     	
		Scene scene = new Scene(grid, 300, 275);
		StackPane layout = new StackPane();
		
		

		stage.setScene(scene);
		stage.show();
	}
}
