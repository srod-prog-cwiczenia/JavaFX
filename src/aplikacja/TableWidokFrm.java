package aplikacja;

import java.time.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class TableWidokFrm {
	/**
	 * To jest nieuzywana zmienna, tylko do testow
	 */
  private final static ObservableList<OsobaKlasaZewn> data =
    FXCollections.observableArrayList(
	  new OsobaKlasaZewn("Anna", "Zajdel", "stud"),
      new OsobaKlasaZewn("Beata", "Xyros", "prac"),
      new OsobaKlasaZewn("Celica", "Wyka", "uczen"),
      new OsobaKlasaZewn("Dorota", "Ypsylon", "prac"),
      new OsobaKlasaZewn("Ewa", "Vitali", "stud")
    );   
	
  public static void pokaz(ObservableList<OsobaKlasaZewn> persony) {
      Stage formatka6 = new Stage();
      formatka6.setTitle("6 formatka");
      StackPane root6 = new StackPane();

      TableView tableView = new TableView();
      TableColumn<String, OsobaKlasaZewn> column1 = new TableColumn<String, OsobaKlasaZewn>("Imie");
      column1.setCellValueFactory(new PropertyValueFactory<String, OsobaKlasaZewn>("imie"));

      TableColumn<String, OsobaKlasaZewn> column2 = new TableColumn<String, OsobaKlasaZewn>("Nazwisko");
      column2.setCellValueFactory(new PropertyValueFactory<String, OsobaKlasaZewn>("nazwisko"));

      TableColumn<String, OsobaKlasaZewn> column3 = new TableColumn<String, OsobaKlasaZewn>("Komentarz");
      column3.setCellValueFactory(new PropertyValueFactory<String, OsobaKlasaZewn>("komentarz"));

//to do wyjasnienia czemu wychodzi SzostaFormatka.java uses unchecked or unsafe operations
//po odkomentowaniu tego co ponizej:
      
      tableView.getColumns().addAll(column1, column2, column3);
      tableView.setEditable(true);
      //tableView.setItems(data);
      tableView.setItems(persony);
      
      /*tableView.getItems().add(new Person("Anna", "Kowalska"));
      tableView.getItems().add(new Person("Dorota", "Nowak"));*/
     
      
      VBox vbox = new VBox(tableView);

      Scene scene = new Scene(vbox);
      formatka6.setScene(scene);
      formatka6.show();
  }
}
