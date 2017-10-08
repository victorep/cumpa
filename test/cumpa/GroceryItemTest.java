package cumpa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

        assertEquals(this.name,item.getItemName());
    }

    @Test
    public void setItemName() throws Exception {
        item.setItemName("more-beer");
        assertEquals("more-beer",item.getItemName());
    }

    @Test
    public void getItemUnits() throws Exception {
        assertEquals(units,item.getItemUnits());
    }

    @Test
    public void setItemUnits() throws Exception {
        item.setItemUnits(1234);
        assertEquals(1234,item.getItemUnits());
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