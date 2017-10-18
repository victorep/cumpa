package me.vepu.cumpa.tests;

import me.vepu.cumpa.app.datamodel.GroceryItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GroceryItemTest {
    private GroceryItem item ;

    public String name="beer";
    private int units=100;

    @Before
    public void setUp() throws Exception {

        item = new GroceryItem(this.name,this.units);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getItemName() throws Exception {

        assertEquals(this.name,item.getName());
    }

    @Test
    public void setItemName() throws Exception {
        item.setName("more-beer");
        assertEquals("more-beer",item.getName());
    }

    @Test
    public void getItemUnits() throws Exception {
        assertEquals(units,item.getUnits());
    }

    @Test
    public void setItemUnits() throws Exception {
        item.setUnits(1234);
        assertEquals(1234,item.getUnits());
    }

//    @Test
//    public void showItemDetailsCLI() throws Exception {
//
//    }
//
//    @Test
//    public void getItemDetailsCLI() throws Exception {
//    }

}