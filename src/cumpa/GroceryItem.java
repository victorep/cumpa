package cumpa;

public class GroceryItem implements IGroceryItem{
    private  String itemName;
    private  int itemUnits;



    public GroceryItem() {
    }

    public GroceryItem(String itemName, int itemUnits) {
        this.itemName = itemName;
        this.itemUnits = itemUnits;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemUnits() {
        return itemUnits;
    }

    public void setItemUnits(int itemUnits) {
        this.itemUnits = itemUnits;
    }
}
