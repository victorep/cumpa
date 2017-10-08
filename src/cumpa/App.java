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
        //add some items so we don't have to do it manually
        groceryList.addItem(new GroceryItem("beer",1));
        groceryList.addItem(new GroceryItem("tomatoes",1));
        groceryList.addItem(new GroceryItem("potatoes",2));
        boolean exit=false;
        int option=0;
        while (!exit){

            switch (option){
                case 0:
                    System.out.println("======OPTIONS LIST=====");
                    System.out.println(">1. List required groceries");
                    System.out.println(">2. Add required groceries");
                    System.out.println(">3. Delete a required grocery");
                    System.out.println(">9. EXIT");
                    System.out.println("=== END OPTIONS LIST===");
                    break;
                case 1:
                    groceryList.showAllGroceries( );
                    break;
                case 2:
                    groceryList.getMultipleGroceryItemsCLI( );
                    break;
                case 3:
                    groceryList.removeItemCLI();
            }
            System.out.println("What do you want to do ? [0 for options] ");
            option = scanner.nextInt();
            scanner.nextLine();
        }

       // boughtList.getMultipleGroceryItemsCLI( );


        //groceryList.showAllGroceries();
        boughtList.showAllGroceries();

        System.out.println("Application finished");


    }

}
