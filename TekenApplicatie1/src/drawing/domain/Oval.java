package drawing.domain;


import Interface.Paintable;

import java.io.Serializable;

public class Oval extends DrawingItem implements Serializable{
    private Point anchor;
    private double width;
    private double height;
    private double weight;

    public Point getAnchor() {
        return anchor;
    }

    public void setAnchor(Point anchor) {
        this.anchor = anchor;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void paintUsing(Paintable paintable) {
        paintable.paint(this);
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Oval(){

    }

    public Oval(Point anchor, double width, double height, double weight) {
        this.anchor = anchor;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Oval{" +
                "anchor=" + anchor +
                ", width=" + width +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
