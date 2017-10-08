package cumpa;

import java.util.Scanner;

public class App {

    //App variables
    private static String appName = "Our Groceries";
    private static double appVersion = 0.1;

    //Input scanner
    private static Scanner scanner = new Scanner(System.in);

    //Array to store our items
    private static GroceryList<GroceryItem> groceryList = new GroceryList();

    private static GroceryList<GroceryItem> boughtList = new GroceryList();

    private static void initApp(String name, double ver){
        System.out.println("Initializing " + name + " version " + ver);
    }

    public static void main(String[] args) {

        initApp(appName,appVersion);


        groceryList.getMultipleGroceryItemsCLI( );
        boughtList.getMultipleGroceryItemsCLI( );


        groceryList.showAllGroceries();
        boughtList.showAllGroceries();

        System.out.println("Application finished");


    }

}
