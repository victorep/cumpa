package cumpa.datamodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroceryList<T extends GroceryItem> extends ArrayList<T>{

    Scanner scanner = new Scanner(System.in);

    public void addItem(T item){
        this.add(item);
    }

    public void removeItem(int id){
        this.remove(id);
    }
    public T getItem(int id){
        return this.get(id);
    }

    public String listAllGroceriesAsText(){
        String output=new String();
        output+="=== Grocery items list ===\n";
        for ( int i=0;i<this.size();i++){
            output+="("+(i+1)+") " +this.get(i).showItemDetailsAsText()+ "\n";
        }
        output+="==========================\n";
        return output;
    }
    public void removeItemCLI(){
        int id;
        System.out.print("Enter the item id: ");id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("=======Removing item=====");

        if (id >0 &&
                id<=this.size()){
            id--;
            System.out.println("Removing Item "+getItem(id).getItemName());
            removeItem(id);
            System.out.println("Removed succesfully");
        }else {
            System.out.printf("Item %s not found %s\n", id,this.size());
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

    public ArrayList<T> getList() {
        return this;
    }
}
