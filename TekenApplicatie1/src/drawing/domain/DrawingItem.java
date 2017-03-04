package drawing.domain;

import drawing.domain.Enums.Color;

public abstract class DrawingItem {

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
