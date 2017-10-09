package cumpa.gui;

import cumpa.App;
import cumpa.GroceryItem;
import cumpa.GroceryList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import java.util.Scanner;

public class HomeController {

    @FXML
    private Button listGroceries;

    @FXML
    private Button addGroceries;

    @FXML
    private Button removeGroceries;

    @FXML
    private void buttonPress(ActionEvent e){
        if (e.getSource().equals(listGroceries)) { groceryList.showAllGroceries();}
        else if (e.getSource().equals(addGroceries)) { groceryList.getMultipleGroceryItemsCLI();}
        else if (e.getSource().equals(removeGroceries)) { groceryList.removeItemCLI();}
    }

    public HomeController(){
        groceryList.addItem(new GroceryItem("beer",1));
        groceryList.addItem(new GroceryItem("tomatoes",1));
        groceryList.addItem(new GroceryItem("potatoes",2));
    }
    //Input scanner
    private static Scanner scanner = new Scanner(System.in);

    //Array to store our items
    private static GroceryList<GroceryItem> groceryList = new GroceryList();

}
