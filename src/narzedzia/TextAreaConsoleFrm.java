package narzedzia;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TextAreaConsoleFrm {
	Stage formatka;
	TextArea obszarTxt;
    Tooltip ttEnter;
    Button btnWyjscie;
    VBox vbox;
    Scene scena;
	public TextAreaConsoleFrm() {
    	  formatka = new Stage();
    	  formatka.initModality(Modality.APPLICATION_MODAL);
	      formatka.setTitle("emulacja konsoli w trybie graficznym");
	      obszarTxt = new TextArea();
	      
/**   to rozwinięta obudowa dla komponentów, niestety w tym kontekście akurat nie sprawdza się (biały ekran)  
  	      Group root = new Group();
	      GridPane gridpane = new GridPane();
	      gridpane.setPadding(new Insets(5));
	      gridpane.setHgap(10);
	      gridpane.setVgap(10); 
	      GridPane.setHalignment(obszarTxt, HPos.CENTER);
	      gridpane.add(obszarTxt, 0, 1);
          root.getChildren().add(gridpane); */    	      
	      
	      obszarTxt.setPrefRowCount(100);
	      obszarTxt.setPrefColumnCount(100);
	      obszarTxt.setWrapText(true);
	      obszarTxt.setPrefWidth(150);
	      
	      Tooltip ttWyjscie = new Tooltip("Wyjscie z konsoli graficznej");
	      btnWyjscie = new Button("Wyjscie");
	      btnWyjscie.setMinWidth(50);
	      btnWyjscie.setTooltip(ttWyjscie);
	      
	      btnWyjscie.setOnAction(action -> {
	    	  formatka.close();
	      });
	      vbox = new VBox(obszarTxt, btnWyjscie);
	      //scena = new Scene(vbox, 500, 300);
	      Scene scena = new Scene(vbox, 800, 630);
	      formatka.setScene(scena);
	      formatka.show();
	  }
	  public void pokaz(List<String> kolekcja) {
	      for (String linia : kolekcja) {
	    	  obszarTxt.appendText(linia + "\n");
	      }
	  }
//łańcuchy:
	  public void pokaz(String linia) {
		  obszarTxt.appendText(linia + "\n");
	  }
	  public void println(String linia) {
		  pokaz(linia);
	  }
	  public void print(String linia) {
		  obszarTxt.appendText(linia);		  
	  }
//liczby:	  
	  public void pokaz(int aLiczba) {
		  pokaz("" + aLiczba);
	  }
	  public void println(int aLiczba) {
		  pokaz(aLiczba);
	  }
	  public void print(int aLiczba) {
		  obszarTxt.appendText("" + aLiczba);		  
	  }
//char:
	  public void pokaz(char aZnak) {
		  pokaz("" + aZnak);
	  }
	  public void println(char aZnak) {
		  pokaz(aZnak);
	  }
	  public void print(char aZnak) {
		  obszarTxt.appendText("" + aZnak);		  
	  }
	  public void zamkniecieFormatki() {
		  formatka.close();	  
	  }
	  public String czytajLinie() {
		  /**
		   * TODO: to jeszcze nie działa tak jak powinno
		   * na razie używamy dialogu, póki co jakoś to działa
		   */
/*		  formatka.hide();
		  formatka.showAndWait();
*/
		  TextInputDialog dialog = new TextInputDialog("Podaj treść");
		  dialog.setX(formatka.getX());
		  dialog.setY(formatka.getY() + formatka.getHeight());
		  dialog.setTitle("Podaj treść");
		  dialog.setHeaderText("Podaj treść");
		  dialog.setContentText("Podaj treść");

		  // Typowa droga do otrzymania odpowiedzi (tryb modalny):
		  Optional<String> result = dialog.showAndWait();
		  /** TODO: Nalezy ustalic jak wywolac formatke dialogu nie w trybie modalnym 
		   * (aby moc np. przewijac textedit).
		   *  
		   */
		  if (result.isPresent()) {
/*TODO: zmiana koloru tekstu w ten sposób niestety nie działa - dlaczego?
 * 			  Region region = (Region) obszarTxt.lookup(".content");
			  region.setStyle("-fx-background-color:red;");
			  region.setStyle("-fx-text-color:red;");
*/			  obszarTxt.appendText(result.get() + "\n");
		      return result.get();
		  } else {
			  return "";
		  }
	  }
}
