package Interface;


import drawing.domain.Image;
import drawing.domain.Oval;
import drawing.domain.PaintedText;
import drawing.domain.Polygon;

public interface Paintable {
    void paint(Oval oval);
    void paint(Polygon polygon);
    void paint(PaintedText text);
    void paint(Image image);
}
