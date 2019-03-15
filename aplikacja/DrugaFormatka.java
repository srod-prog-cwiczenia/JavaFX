package aplikacja;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DrugaFormatka {
  public static void pokaz() {
      System.out.println("Start!");
      Stage formatka2 = new Stage();
      formatka2.setTitle("Druga formatka");
      StackPane root2 = new StackPane();
      formatka2.setScene(new Scene(root2, 400, 350));
      formatka2.show();
  }
}
