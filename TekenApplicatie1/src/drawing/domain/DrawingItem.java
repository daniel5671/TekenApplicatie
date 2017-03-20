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

    public boolean insideBoundingBox(Point point){
        if(point.getX() >= this.getAnchor().getX() && point.getX()<= (this.getAnchor().getX() + this.getWidth()) || point.getY() >= this.getAnchor().getY() && point.getY() <= (this.getAnchor().getY() + this.getHeight())){

            return true;
        }
        return false;
    }

    public boolean overlaps(DrawingItem item){
        Point Startingpoint = item.getAnchor();
        Point Endpoint = new Point(item.getAnchor().getX() + item.getWidth(),item.getAnchor().getY() + item.getHeight());
        if (insideBoundingBox(Startingpoint) && insideBoundingBox(Endpoint)){
            return true;
        }
        return false;
    }


}
