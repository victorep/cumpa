package cumpa.gui;

import cumpa.App;
import cumpa.GroceryItem;
import cumpa.GroceryList;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.util.Scanner;

public class HomeController {

    @FXML
    private Button listGroceries;

    @FXML
    private Button addGroceries;

    @FXML
    private Button removeGroceries;

    @FXML
    private Label statusLabel;

    @FXML
    private TextArea outputArea;

    @FXML
    private void buttonPress(ActionEvent e){
        if (e.getSource().equals(listGroceries)) {

            outputArea.insertText(0,groceryList.listAllGroceriesAsText());
            //System.out.print(groceryList.listAllGroceriesAsText());}
        }
        else if (e.getSource().equals(addGroceries)) {
            Runnable task = new Runnable(){
                @Override
                public void run() {
                    String previousStatus=statusLabel.getText();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            addGroceries.setDisable(true);
                            statusLabel.setText("Running Add item");
                        }
                    });
                    groceryList.getMultipleGroceryItemsCLI();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                             statusLabel.setText(previousStatus);
                            addGroceries.setDisable(false);
                        }
                    });


                }
            };

            new Thread(task).start();

        }
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
