package cumpa;

import java.util.Scanner;

public class GroceryItem implements IGroceryItem{
    private  String itemName;
    private  int itemUnits;

    Scanner scanner = new Scanner(System.in);

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
    public void showItemDetailsCLI(){
        System.out.println("=== item ===");
        System.out.printf("Name: %s \n",getItemName());
        System.out.printf("Total units: %s \n",getItemUnits());
        System.out.println("============");
    }

    public void getItemDetailsCLI(){
        System.out.println("=== Input item details ===");
        System.out.print("Name: ");setItemName( scanner.nextLine());
        System.out.print("Units : ");setItemUnits(scanner.nextInt());
        scanner.nextLine();
        System.out.println("======= End input ========");
    }
}
