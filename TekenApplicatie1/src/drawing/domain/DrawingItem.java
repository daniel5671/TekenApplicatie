package drawing.domain;

import Interface.Paintable;
import drawing.domain.Enums.Color;

import java.io.Serializable;

public abstract class DrawingItem implements Serializable {

    private Color color;
    private DrawingItem previousstate;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public DrawingItem getPreviousstate() {
        return previousstate;
    }

    public abstract Point getAnchor();

    public abstract double getWidth();

    public abstract double getHeight();

    public abstract void paintUsing(Paintable paintable);


}
