package cumpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    //App variables
    private static String appName = "Our Groceries";
    private static double appVersion = 0.1;

    //Input scanner
    private static Scanner scanner = new Scanner(System.in);

    //Array to store our items
    private static GroceryList groceryList = new GroceryList();


    private static void initApp(String name, double ver){
        System.out.println("Initializing " + name + " version " + ver);
    }

    public static void main(String[] args) {

        initApp(appName,appVersion);

        groceryList.getMultipleGroceryItemsCLI();

        groceryList.showAllGroceries();

        System.out.println("Application finished");


    }

}
