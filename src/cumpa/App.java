package cumpa;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class App {

    //App variables
    private static String appName = "Our Groceries";
    private static double appVersion = 0.1;

    //Input scanner
    private static Scanner scanner = new Scanner(System.in);

    //our grocery item
    private static String itemName;
    private static String itemCategory;
    private static double itemUnitPrice;
    private static int itemUnits;
    private static double itemTotalPrice;

    private static void initApp(String name, double ver){
        System.out.println("Initializing " + name + " version " + ver);
    }

    private static void getItemDetails(){
        System.out.println("Initializing " + appName + " version " + appVersion);
        System.out.println("=== Input item details ===");
        System.out.print("Name: ");itemName = scanner.nextLine();
        System.out.print("Category: ");itemCategory = scanner.next();
        System.out.print("Unit Price: ");itemUnitPrice = scanner.nextDouble();
        System.out.print("Units : ");itemUnits = scanner.nextInt();
        System.out.println("======= End input ========");

        // some logic after input
        itemTotalPrice = itemUnitPrice * itemUnits;

    }

    private static void showItemDetails(){
        System.out.println("=== Our product ===");
        System.out.printf("Name: %s \n",itemName);
        System.out.printf("Category: %s \n",itemCategory);
        System.out.printf("Unit proice: %s \n",itemUnitPrice);
        System.out.printf("Total units: %s \n",itemUnits);
        System.out.printf("Total price: %s \n",itemTotalPrice);
        System.out.println("===================");
    }

    public static void main(String[] args) {

        initApp(appName,appVersion);

        //getItemDetails();
        //showItemDetails();

        getItemDetails();

        for (int i=0;i<10;i++){

            System.out.println("I am " + i);
            showItemDetails();

        }

        System.out.println("Application finished");


    }

}
