package cumpa;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class App {

    //App variables
    private static String appName = "Our Groceries";
    private static double appVersion = 0.1;

    //Input scanner
    private static Scanner scanner = new Scanner(System.in);

    private static void initApp(String name, double ver){
        System.out.println("Initializing " + name + " version " + ver);
    }

    private static GroceryItem getItemDetails(){
        GroceryItem item = new GroceryItem();

        System.out.println("=== Input item details ===");
        System.out.print("Name: ");item.setItemName( scanner.nextLine());
        System.out.print("Units : ");item.setItemUnits(itemUnits = scanner.nextInt());
        scanner.nextLine();
        System.out.println("======= End input ========");
        return item;
    }

    private static void showItemDetails(GroceryItem item){
        System.out.println("=== Our product ===");
        System.out.printf("Name: %s \n",item.getItemName());
        System.out.printf("Total units: %s \n",item.getItemUnits());
        System.out.println("===================");
    }

    public static void main(String[] args) {

        initApp(appName,appVersion);

        boolean _continue = true;
        int i=0;
        while (_continue){
            i++;
            GroceryItem item = getItemDetails();
            showItemDetails(item);
            System.out.print("Enter another one[y/N] : ");

            switch (scanner.nextLine().toLowerCase()){
                case  "y":
                    _continue=true;
                    break;
                case  "n":
                    _continue=false;
                    break;
                case "":
                    _continue=false;
                    break;
                default:
                    _continue=false;
                    System.out.println("Invalid Option");
            }
        }
        System.out.println("You entered " + i + " items.");


        System.out.println("Application finished");


    }

}
