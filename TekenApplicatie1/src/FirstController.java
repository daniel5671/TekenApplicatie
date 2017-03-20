import drawing.domain.*;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FirstController implements Initializable {
    @FXML private Canvas drawingcanvas ;
    @FXML private ComboBox DrawItem;
    @FXML private ListView listview;
    @FXML private Button BtnDelete;
    @FXML private Button Save;
    @FXML private Button Load;

    private Drawing drawing;
    public Point startingpoint;
    public Point endingpoint;
    public ArrayList<Point>points = new ArrayList<>();

    private GraphicsContext gc;
    private SerializationMediator serializationMediator = new SerializationMediator();
    private DatabaseMediator databaseMediator = new DatabaseMediator();

    @Override
    public void initialize(URL location, ResourceBundle resources){

        gc = drawingcanvas.getGraphicsContext2D();
        drawing = new Drawing();

        drawingcanvas.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getX() + " " +event.getY());
                startingpoint = new Point(event.getX(),event.getY());
            }
        });

        drawingcanvas.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                endingpoint = new Point(event.getX(),event.getY());
                System.out.println(event.getX() + " " +event.getY());
                addDrawing(startingpoint, endingpoint);
            }
        });
        BtnDelete.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                deleteDrawingItem(event);
            }
        });

        Save.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                try {
                    databaseMediator.save(drawing);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Load.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                try {
                    drawing = serializationMediator.load("drawing.ser");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
    });}

        private void deleteDrawingItem(javafx.event.ActionEvent event){
             DrawingItem todeleteitem = (DrawingItem) listview.getSelectionModel().getSelectedItem();
             drawing.deleteDrawing(todeleteitem);
             Draw();
    }

    public boolean addDrawing(Point start, Point end ){
        switch((String)DrawItem.getValue()){
            case "Oval" :
                Oval oval = new Oval(start,end.getX()-start.getX(),end.getY()-start.getY(),1);
                if (drawing.getItems().size()>0){
                    if (checkoverlap(oval)){
                        System.out.println("Overlap");
                    }
                    else{
                        drawing.addDrawing(oval);
                    }
                }
                else {
                    drawing.addDrawing(oval);
                }
                break;
            case "Polygon":
                points.add(new Point(100, 100));
                points.add(new Point(200, 100));
                points.add(new Point(200, 50));
                Polygon polygon = new Polygon(points,5);
                drawing.addDrawing(polygon);
                break;
            case "Image":
                Image image = new Image(new File("./res/Spoof.png"),start,start.getX() + end.getX(),start.getY() + end.getY());
                if (drawing.getItems().size()>0){
                    if (checkoverlap(image)){
                        System.out.println("Overlap");
                    }
                    else{
                        drawing.addDrawing(image);
                    }
                }
                else drawing.addDrawing(image);

                break;
            case "PaintedText":
                PaintedText paintedtext = new PaintedText("hallo", "Ariel", new Point(150,150),40,50);
                drawing.addDrawing(paintedtext);
                break;
        }
        Draw();
        return true;
    }

    public boolean checkoverlap(DrawingItem overlappingitem){
        if (drawing.getItems().size() >0){
            for(DrawingItem t  : drawing.getItems()) {
                if (t.overlaps(overlappingitem)) {
                    System.out.println("overlapping");
                    return true;
                }
            }
        }
            return false;
    }

    public void Draw() {
        gc.clearRect(0, 0, drawingcanvas.getWidth(), drawingcanvas.getHeight());
        drawing.paintUsing(new JavaFXPaintable(gc));
        listview.setItems(drawing.itemsToObserve());
    }
 }



