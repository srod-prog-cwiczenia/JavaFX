package aplikacja;

import java.util.Random;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class PlotnoFrm {
  public static void pokaz(int aWersja) {
	  Stage formatka2 = new Stage();
      formatka2.setTitle("Druga formatka");
      StackPane root2 = new StackPane();
      
      int rozmiarPlotna[] = new int [2];
      switch (aWersja) {
        case 0:
        	rozmiarPlotna[0] = 300;
        	rozmiarPlotna[1] = 200;
        	break;
        case 1:
        	rozmiarPlotna[0] = 650;
        	rozmiarPlotna[1] = 600;
        	break;
    	          
      }
      Canvas canvas = new Canvas(rozmiarPlotna[0], rozmiarPlotna[1]);
    
      GraphicsContext gc = canvas.getGraphicsContext2D();

	  switch (aWersja) {
        case 0: {
            gc.setLineWidth(2.0);
            gc.setFill(Color.AQUAMARINE);
            gc.strokeRoundRect(10, 10, 50, 50, 10, 10);
            gc.fillOval(70, 10, 50, 20);        
            gc.strokeText("To jest Plotno", 150, 20);
   	        break;
        }
        case 1: {
        	double width = gc.getCanvas().getWidth();
            double height = gc.getCanvas().getHeight();

            Random random = new Random(System.currentTimeMillis());

            gc.setFill(Color.rgb(random.nextInt(255), random.nextInt(255),
              random.nextInt(255), 0.9));
            gc.translate(width / 2, height / 2);

            for (int i = 0; i < 60; i++) {
                gc.rotate(6.0);
                gc.setFill(Color.rgb(random.nextInt(255), random.nextInt(255),
                random.nextInt(255), 0.9));
                gc.fillOval(10, 60, 30, 30);
            //    random.nextInt(255),
              //  random.nextInt(255), 0.9));
                gc.strokeOval(60, 60, 30, 30);
                gc.setFill(Color.rgb(random.nextInt(255), random.nextInt(255),
                random.nextInt(255), 0.9));
                gc.fillRoundRect(110, 60, 30, 30, 10, 10);
                gc.setFill(Color.rgb(random.nextInt(255), random.nextInt(255),
                random.nextInt(255), 0.9));
                gc.fillPolygon(
                new double[] { 105, 117, 159, 123, 133, 105, 77, 87,51, 93 },
                new double[] { 150, 186, 186, 204, 246, 222, 246,204, 186, 186 }, 10);
            }
        }
      }
	  
      root2.getChildren().add(canvas);
      Scene scene2 = new Scene(root2, 550, 450);
      formatka2.setScene(scene2);
      formatka2.show();
  }
}
