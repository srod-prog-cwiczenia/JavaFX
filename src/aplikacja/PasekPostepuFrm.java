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

public class PasekPostepuFrm {

	public static ProgressBar p2;
	public static void pokaz() {
      Group root = new Group();
	  Scene scene = new Scene(root, 260, 80);
      Stage formatka4 = new Stage();
      formatka4.setTitle("Czwarta formatka");
	  formatka4.setScene(scene);

	  FlowPane g = new FlowPane();
	  Button btn1 = new Button();
      btn1.setText("Test progresbara");
	  btn1.setOnAction((event) -> {
	    testProgresa();        
	  });

	  p2 = new ProgressBar();
	  g.getChildren().add(p2);
	  g.getChildren().add(btn1);
	  
    
	  
	  scene.setRoot(g);
	  formatka4.show();	
	  System.out.println("set progress 1");
	  p2.setProgress(0.01F);
	    
//	  try {
//		    Thread.sleep(3000); 
//	  } catch (InterruptedException e) {
//		    e.printStackTrace();
//	  }
	  /*
	   * To powyżej z Thread.sleep nie działa tak jak to miało w zamierzeniu funkcjonować a to dlatego że
	   * formatka zatrzymuje działanie programu i się nie pokazuje do chwili gdy
	   * w końcu Thread.sleep się zakończy. W zamierzeniu miało to działać inaczej
	   * */
	}
	public static void testProgresa() {
	  for (int ii = 0; ii < 100; ii++) {
	    try {
		    Thread.sleep(10); 
	    } catch (InterruptedException e) {
		    e.printStackTrace();
	    }
	    p2.setProgress((float)ii * 0.005F);
	    
	  }
	}  

}
