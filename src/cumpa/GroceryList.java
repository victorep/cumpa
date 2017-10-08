package cumpa;

import java.util.ArrayList;
import java.util.Scanner;

public class GroceryList {


    ArrayList<GroceryItem> list = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public class GroceryItem extends cumpa.GroceryItem{

    }

    public void addItem(GroceryItem item){
        list.add(item);
    }

    public GroceryItem getItem(int id){
        return list.get(id);
    }

    public  void showAllGroceries(){
        System.out.println("=== Grocery items list ===");
        for ( int i=0;i<list.size();i++){
            list.get(i).showItemDetailsCLI();
        }
        System.out.println("==========================");
    }

    public void getMultipleGroceryItemsCLI(){

        boolean _continue = true;
        int i=0;
        while (_continue){
            i++;
            GroceryItem item = new GroceryItem();
            item.getItemDetailsCLI();
            addItem(item);
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
}
