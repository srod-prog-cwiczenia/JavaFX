package nowe;

import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout.Group;

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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import narzedzia.Pomocnicze;

public class ObiektyGraficzneFrm {
	final public static int ILE_OBIEKTOW = 5;	
	public static void pokaz() {
		Stage formatkaOG = new Stage();
		formatkaOG.setTitle("Przegląd obiektów graficznych");
		List<Rectangle> kolekcjaObiektow = new ArrayList<Rectangle>();
		for (int ii = 0; ii < ILE_OBIEKTOW; ii++) {
	      Rectangle rectangle = new Rectangle();  
	      rectangle.setX(150.0f + ii * 5); 
          rectangle.setY(75.0f + ii * 5); 
		  rectangle.setWidth(30.0f + ii * 20); 
		  rectangle.setHeight(15.0f + ii * 10); 
          rectangle.setArcWidth(35.0); 
		  rectangle.setArcHeight(25.0);  
		  kolekcjaObiektow.add(rectangle);
		}
		for (int ii = 0; ii < kolekcjaObiektow.size(); ii++) {
			Color kolor = Color.CORAL;
			switch (ii % 5) {
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
			kolekcjaObiektow.get(ii).setFill(kolor);
		}	
		VBox root = new VBox();
		root.getChildren().addAll(kolekcjaObiektow);
		Scene scene = new Scene(root, 1100, 900);
		formatkaOG.setScene(scene);
		formatkaOG.show();
	}
}
