package me.vepu.cumpa.app;


import me.vepu.cumpa.app.datamodel.GroceryListArrayListImpl;
import me.vepu.cumpa.app.datamodel.GroceryItem;
import me.vepu.cumpa.app.datamodel.IGroceryListPersistance;
import me.vepu.cumpa.app.datamodel.GroceryListPersistanceXMLImpl;

public class App {

    //App variables
    private  String appName = "Our Groceries";
    private  double appVersion = 0.1;

    private String persistenceContainer = "GroceryListItems";
    private IGroceryListPersistance persistanceLayer = new GroceryListPersistanceXMLImpl(persistenceContainer);

    //Array to store our items
    private GroceryListArrayListImpl<GroceryItem> groceryListArrayListImpl = new GroceryListArrayListImpl();


    private App() {
        load();
    }
    private static App instance = new App();
    public static App getInstance(){
        return instance;
    }

    public GroceryListArrayListImpl<GroceryItem> getGroceryListArrayListImpl() {
        return groceryListArrayListImpl;
    }

    public String getAppName() {
        return appName;
    }

    public double getAppVersion() {
        return appVersion;
    }

    public void load(){
        try {
            groceryListArrayListImpl=new GroceryListArrayListImpl<>();
            groceryListArrayListImpl.addAll(persistanceLayer.load(persistenceContainer)); }
        catch (Exception e){ e.printStackTrace(); }
    }
    public void save(){
        try { persistanceLayer.save(persistenceContainer, groceryListArrayListImpl); }
        catch (Exception e){ e.printStackTrace(); }
    }

    public  void exit(){
        save();
    }
}
