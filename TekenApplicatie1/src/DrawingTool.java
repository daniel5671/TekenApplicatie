import Interface.PersistencyMediator;
import drawing.domain.Drawing;
import drawing.domain.DrawingItem;
import drawing.domain.JavaFXPaintable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import sun.applet.Main;

public class DrawingTool extends Application{

    public PersistencyMediator persistencyMediator;
    private Drawing drawing;
    private JavaFXPaintable paintable;
    private javafx.scene.canvas.Canvas drawingCanvas;
    private DatabaseMediator databaseMediator;

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

        Parent parent =  FXMLLoader.load(getClass().getClassLoader().getResource("guilayout.fxml"));
        Scene scene = new Scene(parent,950,500);
        primaryStage.setTitle("TekenApplicatie");
        primaryStage.setScene(scene);
        primaryStage.show();


 /*
        Drawing drawing = new Drawing();
        SerializationMediator serializationMediator = new SerializationMediator();
        DatabaseMediator databaseMediator = new DatabaseMediator();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Group root = new Group();
*/
        //Drawing drawing = serializationMediator.load("drawing.ser");

/*
        root.getChildren().add(canvas);

        this.setPaintable(new JavaFXPaintable(canvas.getGraphicsContext2D()));
        this.setDrawing(drawing);
        Draw();

        serializationMediator.save(drawing);
        databaseMediator.save(drawing);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
*/
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

    public DatabaseMediator getDatabaseMediator() {
        return databaseMediator;
    }

    public void setDatabaseMediator(DatabaseMediator databaseMediator) {
        this.databaseMediator = databaseMediator;
    }
}

