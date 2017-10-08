package cumpa;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class App {

    private static void initApp(String name, double ver){
        System.out.println("Initializing " + name + " version " + ver);
    }

    //our grocery item
    private static String itemName;
    private static String itemCategory;
    private static double itemUnitPrice;
    private static int itemUnits;
    private static double itemTotalPrice;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String appName = "Our Groceries";
        double appVersion = 0.1;



        initApp(appName,appVersion);

        System.out.println("Initializing " + appName + " version " + appVersion);
        System.out.println("=== Input item details ===");
        System.out.print("Name: ");itemName = scanner.nextLine();
        System.out.print("Category: ");itemCategory = scanner.next();
        System.out.print("Unit Price: ");itemUnitPrice = scanner.nextDouble();
        System.out.print("Units : ");itemUnits = scanner.nextInt();
        System.out.println("======= End input ========");

        // some logig after input
        itemTotalPrice = itemUnitPrice * itemUnits;

        System.out.println("=== Our product ===");
        System.out.printf("Name: %s \n",itemName);
        System.out.printf("Category: %s \n",itemCategory);
        System.out.printf("Unit proice: %s \n",itemUnitPrice);
        System.out.printf("Total units: %s \n",itemUnits);
        System.out.printf("Total price: %s \n",itemTotalPrice);
        System.out.println("===================");

        System.out.println("Application finished");


    }

}
