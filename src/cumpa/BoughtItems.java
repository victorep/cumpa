package cumpa;

public class BoughtItems extends GroceryItem {

    private double unitPrice;
    private double totalPrice;

    public BoughtItems() {
    }

    public BoughtItems(String itemName, int itemUnits, double unitPrice, double totalPrice) {
        super(itemName, itemUnits);
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }


}
