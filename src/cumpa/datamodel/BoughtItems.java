package cumpa.datamodel;

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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        setTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private void setTotalPrice() {
        this.totalPrice = getUnitPrice()*getItemUnits();
    }
}
