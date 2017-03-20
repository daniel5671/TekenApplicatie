package drawing.domain;

import Interface.Paintable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Drawing extends DrawingItem implements Serializable{
    private String name;
    private ArrayList<DrawingItem>items;
    private ObservableList<DrawingItem> observableList;

    public void setItems(ObservableList<DrawingItem> list) {
        this.observableList = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawing(){
        items = new ArrayList<>();
        observableList = FXCollections.observableList(items);
    }

    public Drawing(String name, ArrayList<DrawingItem> items) {
        this.name = name;
        this.items = items;
    }

    public boolean addDrawing(DrawingItem item){
        items.add(item);
        return true;
    }

    public boolean deleteDrawing(DrawingItem item){
        items.remove(item);
        return true;
    }

    public boolean alterDrawing(DrawingItem item){
        throw new NotImplementedException();
    }

    public List<DrawingItem> getItems(){
        return Collections.unmodifiableList(items);
    }

    public ObservableList<DrawingItem>itemsToObserve(){
        return FXCollections.unmodifiableObservableList(observableList);
    }

    @Override
    public Point getAnchor() {
        return null;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    public void paintUsing(Paintable paintable){
        for (DrawingItem item : items) {
            item.paintUsing(paintable);
        }
    }
}
