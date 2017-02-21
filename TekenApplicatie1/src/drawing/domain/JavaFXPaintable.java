package drawing.domain;

import drawing.domain.Paintable;
import javafx.scene.canvas.GraphicsContext;

public class JavaFXPaintable implements Paintable {

    javafx.scene.canvas.GraphicsContext graphics;

    public JavaFXPaintable(GraphicsContext gc){
        graphics = gc;
    }

    @Override
    public void paint(Oval oval) {
        graphics.strokeOval(oval.getAnchor().getX(), oval.getAnchor().getY(),oval.getWidth(),oval.getHeight());

    }

    @Override
    public void paint(Polygon polygon) {
        for (Point point : polygon.getVertices()) {
            double[]xcooridnaten = polygon.;
            double[]ycoordinaten = ;
        }


        graphics.strokePolygon();
    }

    @Override
    public void paint(PaintedText text) {

    }

    @Override
    public void paint(Image image) {

    }

}
