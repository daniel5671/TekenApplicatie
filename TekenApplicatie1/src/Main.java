import drawing.domain.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.scene.Group;

public class Main extends Application{
    public static void main (String[]args){
        launch(args);
        
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("XIE XIE");
        Group root = new Group();

        Oval oval = new Oval(new Point(100,100),10,10,10);
        Polygon polygon = new Polygon();
        PaintedText paintedtext = new PaintedText();
        Image image = new Image();

        Canvas canvas = new Canvas(500,500);
        Drawing drawing = new Drawing();
        drawing.addDrawing(oval);

        DrawingTool tool = new DrawingTool(new JavaFXPaintable(canvas.getGraphicsContext2D()),drawing);
        root.getChildren().add(canvas);

        tool.Draw();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
