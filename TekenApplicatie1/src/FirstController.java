import drawing.domain.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class FirstController implements Initializable {
    @FXML private Canvas drawingcanvas ;
    @FXML private ComboBox DrawItem;

    private Drawing drawing;
    public Point startingpoint;
    public Point endingpoint;
    public DrawingTool tool;


    private GraphicsContext gc;


    @Override
    public void initialize(URL location, ResourceBundle resources){

        gc = drawingcanvas.getGraphicsContext2D();
        drawing = new Drawing();

        Oval oval = new Oval(new Point(100,100),100,100,10);
        drawing.addDrawing(oval);


        drawingcanvas.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getX() + " " +event.getY());
                startingpoint = new Point(event.getX(),event.getY());
            }
        });
/*
        drawingcanvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
*/
        drawingcanvas.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                endingpoint = new Point(event.getX(),event.getY());
                System.out.println(event.getX() + " " +event.getY());
                addDrawing(startingpoint, endingpoint);
            }
        });

    }
    public boolean addDrawing(Point start, Point end ){

        switch((String)DrawItem.getValue()){
            case "Oval" :
                Oval oval = new Oval(start,end.getX()-start.getX(),end.getY()-start.getY(),1);
                drawing.addDrawing(oval);
                break;
            case "Polygon":
                break;
            case "Image":
                break;
            case "PaintedText":
                break;
        }
//        }
        Draw();
        return true;
    }
    public void Draw() {
        for (DrawingItem drawingItem : drawing.getItems()) {
            drawing.paintUsing(new JavaFXPaintable(gc));
        }
    }
 }



