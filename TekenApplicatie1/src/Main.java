import drawing.domain.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.scene.Group;

import java.io.File;
import java.util.ArrayList;

public class Main extends Application{
    public static void main (String[]args){
        launch(args);
        
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("TekenApplicatie");
        Group root = new Group();

        ArrayList<Point>points = new ArrayList<>();
        points.add(new Point(100, 100));
        points.add(new Point(200, 100));
        points.add(new Point(200, 50));


        Oval oval = new Oval(new Point(100,100),100,100,10);
        Polygon polygon = new Polygon(points,5);
        PaintedText paintedtext = new PaintedText("hallo", "Ariel", new Point(150,150),40,50);
        Image image = new Image(new File("./res/Spoof.png"),new Point(300,300),30,50);

        Canvas canvas = new Canvas(500,500);
        Drawing drawing = new Drawing();

        //add drawings to list
        drawing.addDrawing(oval);
        drawing.addDrawing(polygon);
        drawing.addDrawing(paintedtext);
        drawing.addDrawing(image);

        DrawingTool tool = new DrawingTool(new JavaFXPaintable(canvas.getGraphicsContext2D()),drawing);
        root.getChildren().add(canvas);

        tool.Draw();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
