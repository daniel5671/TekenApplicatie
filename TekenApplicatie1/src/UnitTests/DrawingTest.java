package UnitTests;

import drawing.domain.Drawing;
import drawing.domain.DrawingItem;
import drawing.domain.Oval;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Daniel on 13-3-2017.
 */
class DrawingTest {
    @Test
    void getName() {
        Drawing tekening = new Drawing("mooispull", null);
        assertEquals(tekening.getName(),"mooispull");
    }

    @Test
    void addDrawing(){
        ArrayList<DrawingItem>DrawingItemList = new ArrayList<DrawingItem>();
        Oval oval =  new Oval();
        Oval oval2 = new Oval();

        Drawing tekening = new Drawing("mooispull", new ArrayList<DrawingItem>());
        tekening.addDrawing(oval);
        tekening.addDrawing(oval2);

        assertEquals(tekening.getItems().size(),2);

    }

}