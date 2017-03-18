package UnitTests;
import drawing.domain.DrawingItem;
import drawing.domain.Oval;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class OvalTest {

    @org.junit.jupiter.api.Test
    public void Test1(){
        ArrayList<DrawingItem> drawinglist = new ArrayList<DrawingItem>();
        Oval ovaal = new Oval();
        drawinglist.add(ovaal);

        assertEquals(drawinglist.size(), 1);

    }

}