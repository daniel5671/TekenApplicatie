import drawing.domain.*;

import java.util.ArrayList;

/**
 * Created by Daniel on 14-2-2017.
 */
public class Main {
    public static void main(String[]args){
        System.out.println("Hello World");

        ArrayList<DrawingItem> items = new ArrayList<DrawingItem>();
        Drawing drawing = new Drawing();

        Oval oval = new Oval();
        Polygon polygon = new Polygon();
        PaintedText paintedtext = new PaintedText();
        Image image = new Image();

        drawing.addDrawing(oval);
        drawing.addDrawing(polygon);
        drawing.addDrawing(paintedtext);
        drawing.addDrawing(image);

        drawing.setItems(items);
    }
}
