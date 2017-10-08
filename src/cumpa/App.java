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
    private static ArrayList<GroceryItem> groceryItems = new ArrayList<>();


    private static void initApp(String name, double ver){
        System.out.println("Initializing " + name + " version " + ver);
    }

    private static GroceryItem getItemDetails(){
        GroceryItem item = new GroceryItem();

        System.out.println("=== Input item details ===");
        System.out.print("Name: ");item.setItemName( scanner.nextLine());
        System.out.print("Units : ");item.setItemUnits(scanner.nextInt());
        scanner.nextLine();
        System.out.println("======= End input ========");
        return item;
    }

    private static void showItemDetails(GroceryItem item){
        System.out.println("=== item ===");
        System.out.printf("Name: %s \n",item.getItemName());
        System.out.printf("Total units: %s \n",item.getItemUnits());
        System.out.println("============");
    }
    private static void showAllGroceries(ArrayList<GroceryItem> list){
        System.out.println("=== Grocery items list ===");
        for ( int i=0;i<list.size();i++){
            showItemDetails(list.get(i));
        }
        System.out.println("==========================");
    }

    private static void addMultipleGroceryItems(ArrayList<GroceryItem> list){

        boolean _continue = true;
        int i=0;
        while (_continue){
            i++;
            GroceryItem item = getItemDetails();
            list.add(item);
            System.out.print("Enter another one[Y/n] : ");
            boolean validOption=false;
            while (!validOption)
                switch (scanner.nextLine().toLowerCase()){
                    case  "y":
                        _continue=true;
                        validOption=true;
                        break;
                    case  "n":
                        _continue=false;
                        validOption=true;
                        break;
                    case "":
                        _continue=true;
                        validOption=true;
                        break;
                    default:
                        _continue=false;
                        System.out.println("Invalid Option");
                }
        }


        System.out.println("You entered " + i + " items.");
    }

    public static void main(String[] args) {

        initApp(appName,appVersion);

        addMultipleGroceryItems(groceryItems);

        showAllGroceries(groceryItems);

        System.out.println("Application finished");


    }

}
