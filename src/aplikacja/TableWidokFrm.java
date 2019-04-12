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

import aplikacja.EdycjaOsobyFrm.OsobaKlasaWewn;

import java.util.Collections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TableWidokFrm {
	/**
	 * To jest nieuzywana zmienna, tylko do testow
	 */
  private final static ObservableList<OsobaKlasaWewn> data =
    FXCollections.observableArrayList(
	  new OsobaKlasaWewn("Anna", "Zajdel", "stud"),
      new OsobaKlasaWewn("Beata", "Xyros", "prac"),
      new OsobaKlasaWewn("Celica", "Wyka", "uczen"),
      new OsobaKlasaWewn("Dorota", "Ypsylon", "prac"),
      new OsobaKlasaWewn("Ewa", "Vitali", "stud")
    );   
	
public static void pokaz(ObservableList<OsobaKlasaWewn> persony) {
      Stage formatka6 = new Stage();
      formatka6.setTitle("Przegladanie grida z osobami");
      StackPane root6 = new StackPane();

      TableView<OsobaKlasaWewn> tableView = new TableView<>();
      TableColumn<OsobaKlasaWewn, String> column1 = new TableColumn<OsobaKlasaWewn, String>("Imie");
      column1.setCellValueFactory(new PropertyValueFactory<OsobaKlasaWewn, String>("imie"));

      TableColumn<OsobaKlasaWewn, String> column2 = new TableColumn<OsobaKlasaWewn, String>("Nazwisko");
      column2.setCellValueFactory(new PropertyValueFactory<OsobaKlasaWewn, String>("nazwisko"));

      TableColumn<OsobaKlasaWewn, String> column3 = new TableColumn<OsobaKlasaWewn, String>("Komentarz");
      column3.setCellValueFactory(new PropertyValueFactory<OsobaKlasaWewn, String>("komentarz"));
     
      tableView.getColumns().add(column1);
      tableView.getColumns().add(column2);
      tableView.getColumns().add(column3);
      tableView.setEditable(true);
/**TODO: jak dalem setAll(columna1,...) to wymagal 
      //@SuppressWarnings("unchecked") aby nie wychodzil warning - dlaczego?
      
* 
*/
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
