package cumpa;

import cumpa.datamodel.GroceryItem;
import cumpa.datamodel.GroceryList;

import java.util.Scanner;

public class App {

    //App variables
    private  String appName = "Our Groceries";
    private  double appVersion = 0.1;


    //Array to store our items
    private  GroceryList<GroceryItem> groceryList = new GroceryList();


    public App() {
        //add some items so we don't have to do it manually
        groceryList.addItem(new GroceryItem("beer",1));
        groceryList.addItem(new GroceryItem("tomatoes",1));
        groceryList.addItem(new GroceryItem("potatoes",2));
    }

    public GroceryList<GroceryItem> getGroceryList() {
        return groceryList;
    }

    public String getAppName() {
        return appName;
    }

    public double getAppVersion() {
        return appVersion;
    }
}
