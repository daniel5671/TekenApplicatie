package drawing.domain;

import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class DrawingTool extends javafx.application.Application {

    private Drawing drawing;
    private JavaFXPaintable paintable;
    private javafx.scene.canvas.Canvas drawingCanvas;

    public DrawingTool(Drawing drawing) {
        this.drawing = drawing;
    }

    public JavaFXPaintable getPaintable() {
        return paintable;
    }

    public void setPaintable(JavaFXPaintable paintable) {
        this.paintable = paintable;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GraphicsContext gc = this.drawingCanvas.getGraphicsContext2D();
        this.paintable = new JavaFXPaintable(gc);
        this.drawing.paintUsing(this.paintable);
    }

    public void Draw(){
        for (DrawingItem drawingItem : drawing.getItems()) {
            drawingItem.paintUsing(paintable);
        }

    }

    public DrawingTool(JavaFXPaintable paintable, Drawing drawing){

        this.paintable = paintable;
        this.drawing = drawing;
    }
}
