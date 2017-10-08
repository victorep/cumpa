package cumpa;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Scanner;

public class GroceryList<T extends GroceryItem> {


    ArrayList<T> list = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);


    public GroceryList(){


    }

    public void addItem(T item){
        list.add(item);
    }

    public void removeItem(int id){
        list.remove(id);
    }
    public T getItem(int id){
        return list.get(id);
    }

    public  void showAllGroceries(){
        System.out.println("=== Grocery items list ===");
        for ( int i=0;i<list.size();i++){
            System.out.printf("(%s) ",i+1); list.get(i).showItemDetailsCLI();
        }
        System.out.println("==========================");
    }
    public void removeItemCLI(){
        int id;
        System.out.print("Enter the item id: ");id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("=======Removing item=====");

        if (id >0 &&
                id<=list.size()){
            id--;
            System.out.println("Removing Item "+getItem(id).getItemName());
            removeItem(id);
            System.out.println("Removed succesfully");
        }else {
            System.out.printf("Item %s not found %s\n", id,list.size());
        }
        System.out.println("=========================");

    }

    public void getMultipleGroceryItemsCLI(){

        boolean _continue = true;
        int i=0;
        while (_continue){
            i++;
            T item =(T) new GroceryItem();
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
