package aplikacja;

import java.time.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SzostaFormatka {
  public static void pokaz() {
      Stage formatka6 = new Stage();
      formatka6.setTitle("6 formatka");
      StackPane root6 = new StackPane();

      TableView tableView = new TableView();
      TableColumn<String, Person> column1 = new TableColumn<String, Person>("Imie");
      column1.setCellValueFactory(new PropertyValueFactory<String, Person>("getImie"));

      TableColumn<String, Person> column2 = new TableColumn<String, Person>("Nazwisko");
      column2.setCellValueFactory(new PropertyValueFactory<String, Person>("getNazwisko"));
//to do wyjasnienia czemu wychodzi SzostaFormatka.java uses unchecked or unsafe operations
//po odkomentowaniu tego co ponizej:
      tableView.getColumns().add(column1);
      tableView.getColumns().add(column2);

      tableView.getItems().add(new Person("Anna", "Kowalska"));
      tableView.getItems().add(new Person("Dorota", "Nowak"));

      VBox vbox = new VBox(tableView);

      Scene scene = new Scene(vbox);
      formatka6.setScene(scene);
      formatka6.show();
  }
}
