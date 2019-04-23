package nowe;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TextAreaConsoleFrm {
	Stage formatka;
	TextArea obszarTxt;
    Tooltip ttEnter;
    Button btnEnter;
    VBox vbox;
    Scene scena;
    boolean nacisnietoEnter;
	public TextAreaConsoleFrm() {
    	  nacisnietoEnter = false;
    	  formatka = new Stage();
	      formatka.setTitle("emulacja konsoli w trybie graficznym");
	      obszarTxt = new TextArea();

	      ttEnter = new Tooltip("Akceptacja wpisanego tekstu");
	      btnEnter = new Button("Enter");
	      btnEnter.setMinWidth(50);
	      btnEnter.setTooltip(ttEnter);
	      
	      btnEnter.setOnAction(action -> {
	    	  nacisnietoEnter = true;
	      });
      
	      vbox = new VBox(obszarTxt, btnEnter);
	      scena = new Scene(vbox, 500, 300);
	      formatka.setScene(scena);
	      formatka.show();
	  }
	  public void pokaz(List<String> kolekcja) {
	      for (String linia : kolekcja) {
	    	  obszarTxt.appendText(linia);
	      }
	  }
	  
	  public void zamkniecieFormatki() {
		  formatka.close();	  
	  }
	  public String czytajLinie() {
		  /**
		   * to na razie nie dziala :)
		   */
//		  while (!nacisnietoEnter) {};
//		  nacisnietoEnter = false;
		  return "TAK";
	  }
}
