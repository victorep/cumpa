package cumpa;

import cumpa.datamodel.*;

public class App {

    //App variables
    private  String appName = "Our Groceries";
    private  double appVersion = 0.1;

    private String persistenceContainer = "GroceryListItems";
    private GroceryListPersistance persistanceLayer = new GroceryListPersistanceXMLImpl(persistenceContainer);

    //Array to store our items
    private  GroceryList<GroceryItem> groceryList = new GroceryList();


    private App() {
        load();
    }
    private static App instance = new App();
    public static App getInstance(){
        return instance;
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

    public void load(){
        try { groceryList.addAll(persistanceLayer.load(persistenceContainer)); }
        catch (Exception e){ e.printStackTrace(); }
    }
    public void save(){
        try { persistanceLayer.save(persistenceContainer,groceryList); }
        catch (Exception e){ e.printStackTrace(); }
    }

    public  void exit(){
        save();
    }
}
