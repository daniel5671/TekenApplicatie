package drawing.domain;

import java.util.ArrayList;

/**
 * Created by Daniel on 14-2-2017.
 */
public class Drawing {
    private String name;
    private ArrayList<DrawingItem>items;

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
}
