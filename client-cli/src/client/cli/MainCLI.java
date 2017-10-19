package client.cli;

import me.vepu.cumpa.app.App;
import me.vepu.cumpa.app.datamodel.GroceryListArrayListImpl;

import java.util.Scanner;

public class MainCLI {
    private static void initApp(String name, double ver){
        System.out.println("Initializing " + name + " version " + ver);
    }

    //Input scanner
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        App app=App.getInstance();
        GroceryListArrayListImpl groceryListArrayListImpl =app.getGroceryListArrayListImpl();
        initApp(app.getAppName(),app.getAppVersion());
        boolean exit=false;
        int option=0;
        while (!exit){
            System.out.println("What do you want to do ? [0 for options] ");
            option = scanner.nextInt();
            scanner.nextLine();
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
                    System.out.print(groceryListArrayListImpl.toString( ));
                    break;
                case 2:
                    groceryListArrayListImpl.addCLI( );
                    break;
                case 3:
                    groceryListArrayListImpl.removeCLI();
                case 9:
                    exit=true;
                    break;
            }

        }

        System.out.println("Application finished");


    }
}
