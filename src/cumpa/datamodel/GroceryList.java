package cumpa.datamodel;

import java.util.ArrayList;
import java.util.Scanner;

public class GroceryList<T extends GroceryItem> extends ArrayList<T>{

    Scanner scanner = new Scanner(System.in);

    public void removeCLI(){
        int id;
        System.out.print("Enter the item id: ");id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("=======Removing item=====");

        if (id >0 &&
                id<=this.size()){
            id--;
            System.out.println("Removing Item "+get(id).getName());
            remove(id);
            System.out.println("Removed succesfully");
        }else {
            System.out.printf("Item %s not found %s\n", id,this.size());
        }
        System.out.println("=========================");

    }

    public void addCLI(){

        boolean _continue = true;
        int i=0;
        while (_continue){
            i++;
            T item =(T) new GroceryItem();
            item.getItemDetailsCLI();
            add(item);
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

    @Override
    public String toString(){
        String output=new String();
        output+="=== Grocery items list ===\n";
        for ( int i=0;i<this.size();i++){
            output+="("+(i+1)+") " +this.get(i).toString()+ "\n";
        }
        output+="==========================\n";
        return output;
    }
}
