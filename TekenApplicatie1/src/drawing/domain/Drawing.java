package drawing.domain;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;


public class Drawing {
    private String name;
    private ArrayList<DrawingItem>items = new ArrayList<>();

    public ArrayList<DrawingItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<DrawingItem> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawing(){

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

    public void paintUsing(Paintable paintable){
        for (DrawingItem item : items) {
            item.paintUsing(paintable);
        }
    }
}
