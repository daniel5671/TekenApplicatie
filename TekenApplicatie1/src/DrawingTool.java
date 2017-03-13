import Interface.PersistencyMediator;
import drawing.domain.Drawing;
import drawing.domain.DrawingItem;
import drawing.domain.JavaFXPaintable;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import drawing.domain.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.Group;

import java.io.File;
import java.util.ArrayList;

public class DrawingTool extends Application{

    public PersistencyMediator persistencyMediator;
    private Drawing drawing;
    private JavaFXPaintable paintable;
    private javafx.scene.canvas.Canvas drawingCanvas;

    public DrawingTool(Drawing drawing) {
        this.drawing = drawing;
    }

    public static void main (String[]args){
        launch(args);
    }

    public DrawingTool(){
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Canvas canvas = new Canvas(500,500);
        // Drawing drawing = new Drawing();
        SerializationMediator serializationMediator = new SerializationMediator();


        GraphicsContext gc = canvas.getGraphicsContext2D();

        primaryStage.setTitle("TekenApplicatie");
        Group root = new Group();

        Drawing drawing = serializationMediator.load("drawing.ser");
        /*
        ArrayList<Point>points = new ArrayList<>();
        points.add(new Point(100, 100));
        points.add(new Point(200, 100));
        points.add(new Point(200, 50));


        Oval oval = new Oval(new Point(100,100),100,100,10);
        Polygon polygon = new Polygon(points,5);
        PaintedText paintedtext = new PaintedText("hallo", "Ariel", new Point(150,150),40,50);
        Image image = new Image(new File("./res/Spoof.png"),new Point(300,300),30,50);

        //add drawings to list
        drawing.addDrawing(oval);
        drawing.addDrawing(polygon);
        drawing.addDrawing(paintedtext);
        drawing.addDrawing(image);
        */
        root.getChildren().add(canvas);

        this.setPaintable(new JavaFXPaintable(canvas.getGraphicsContext2D()));
        this.setDrawing(drawing);
        Draw();

        //serializationMediator.save(drawing);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void Draw(){
        for (DrawingItem drawingItem : drawing.getItems()) {
            drawingItem.paintUsing(paintable);
        }

    }

    public Canvas getDrawingCanvas() {
        return drawingCanvas;
    }

    public void setDrawingCanvas(Canvas drawingCanvas) {
        this.drawingCanvas = drawingCanvas;
    }

    public Drawing getDrawing() {
        return drawing;
    }

    public void setDrawing(Drawing drawing) {
        this.drawing = drawing;
    }
    public PersistencyMediator getPersistencyMediator() {
        return persistencyMediator;
    }

    public void setPersistencyMediator(PersistencyMediator persistencyMediator) {
        this.persistencyMediator = persistencyMediator;
    }
    public void setPaintable(JavaFXPaintable paintable) {
        this.paintable = paintable;
    }
    public JavaFXPaintable getPaintable() {
        return paintable;
    }
}
