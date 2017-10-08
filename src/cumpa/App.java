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
        System.out.println("=== Input item details ===");
        System.out.print("Name: ");itemName = scanner.nextLine();
        //System.out.print("Category: ");itemCategory = scanner.nextLine();
        //System.out.print("Unit Price: ");itemUnitPrice = scanner.nextDouble();
        System.out.print("Units : ");itemUnits = scanner.nextInt();
        scanner.nextLine();
        System.out.println("======= End input ========");

        // some logic after input
        //itemTotalPrice = itemUnitPrice * itemUnits;

    }

    private static void showItemDetails(){
        System.out.println("=== Our product ===");
        System.out.printf("Name: %s \n",itemName);
        //System.out.printf("Category: %s \n",itemCategory);
        //System.out.printf("Unit proice: %s \n",itemUnitPrice);
        System.out.printf("Total units: %s \n",itemUnits);
        //System.out.printf("Total price: %s \n",itemTotalPrice);
        System.out.println("===================");
    }

    public static void main(String[] args) {

        initApp(appName,appVersion);

        //getItemDetails();
        //showItemDetails();


        /*
        int numberOfItems;
        System.out.print("How many items do you want to input: "); numberOfItems=scanner.nextInt();
        scanner.nextLine(); // this is needed because nextInt does not consume the new line character and the next input will be skipped
        for (int i=0;i<numberOfItems;i++){

            System.out.println("### Enter item  " + i);
            getItemDetails();
            showItemDetails();

        }
        */
        boolean _continue = true;
        int i=0;
        while (_continue){
            i++;
            getItemDetails();
            showItemDetails();
            System.out.print("Enter another one[y/N] : ");

            /*
            if (scanner.nextLine().toLowerCase().equals("y")){
                _continue=true;

            }else{
                _continue=false;
            }
            */

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
