import drawing.domain.Drawing;
import drawing.domain.Oval;
import drawing.domain.Point;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class FirstController implements Initializable {
    @FXML private Canvas drawingcanvas ;

    private GraphicsContext gc;


    @Override
    public void initialize(URL location, ResourceBundle resources){
       gc = drawingcanvas.getGraphicsContext2D();
        Drawing drawing = new Drawing();

        Oval oval = new Oval(new Point(100,100),100,100,10);
        drawing.addDrawing(oval);


        drawingcanvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        drawingcanvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        drawingcanvas.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
            }
        });

    }


}
