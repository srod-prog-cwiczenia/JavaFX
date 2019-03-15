package nowe;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class ObszarTekstowy {
	  public static void pokaz() {
	      Stage formatkaN1 = new Stage();
	      formatkaN1.setTitle("formatka z pakietu nowe");
	      TextArea textArea = new TextArea();

	      Button button = new Button("Click to get text");
	      button.setMinWidth(50);

	      button.setOnAction(action -> {
	          System.out.println(textArea.getText());

	          textArea.setText("Clicked!");
	      });

	      VBox vbox = new VBox(textArea, button);

	      Scene scene = new Scene(vbox, 200, 100);
	      formatkaN1.setScene(scene);
	      formatkaN1.show();
	  }

}




   
