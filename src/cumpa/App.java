package cumpa;

public class App {

    public static void main(String[] args) {
        String appName = "Our Groceries";
        double appVersion = 0.1;

        //our grocery item
        String itemName = "Milk 1L";
        String itemCategory = "Food";
        double itemUnitPrice = 5.6;
        int itemUnits = 2;
        double itemTotalPrice = itemUnits*itemUnitPrice;

        System.out.println("Initializing " + appName + " version " + appVersion);

        System.out.println("=== Our product ===");
        System.out.printf("Name: %s \n",itemName);
        System.out.printf("category: %s \n",itemCategory);
        System.out.printf("Unit proice: %s \n",itemUnitPrice);
        System.out.printf("Total units: %s \n",itemUnits);
        System.out.printf("Total price: %s \n",itemTotalPrice);
        System.out.println("===================");

        System.out.println("Application finished");

    }

}
