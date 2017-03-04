package drawing.domain;

import drawing.domain.Paintable;
import javafx.scene.canvas.GraphicsContext;

public class JavaFXPaintable implements Paintable {

    private javafx.scene.canvas.GraphicsContext graphics;

    public JavaFXPaintable(GraphicsContext gc){
        graphics = gc;
    }

    @Override
    public void paint(Oval oval) {
        graphics.strokeOval(oval.getAnchor().getX(), oval.getAnchor().getY(),oval.getWidth(),oval.getHeight());

    }

    @Override
    public void paint(Polygon polygon) {
        int i = 0;

        double[]xcooridnaten = new double [polygon.getVertices().size()];
        double[]ycoordinaten = new double [polygon.getVertices().size()];

        for (Point point : polygon.getVertices()) {
            xcooridnaten[i] = point.getX();
            ycoordinaten[i] = point.getY();
            i++;
        }

        graphics.strokePolygon(xcooridnaten,ycoordinaten,polygon.getVertices().size());
    }

    @Override
    public void paint(PaintedText text) {

        graphics.strokeText(text.getContent(),text.getAnchor().getX(),text.getAnchor().getY(),text.getWidth());
    }

    @Override
    public void paint(Image image) {
        javafx.scene.image.Image pic = new javafx.scene.image.Image(image.getFile().toURI().toString());
        graphics.drawImage(pic,image.getAnchor().getX(),image.getAnchor().getY(),image.getWidth(),image.getHeight());
    }

}
