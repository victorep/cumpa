package cumpa.gui;

import cumpa.App;
import cumpa.datamodel.GroceryItem;
import cumpa.datamodel.GroceryList;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
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
    private TextArea outputArea;

    @FXML
    private ListView list;

    //Array to store our items
    private App app = new App();

    @FXML
    private void buttonPress(ActionEvent e){
        if (e.getSource().equals(listGroceries)) {

           Runnable task = new Runnable(){
                @Override
                public void run() {

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            listGroceries.setDisable(true);
                            outputArea.insertText(0,"[List] Start\n");

                            outputArea.insertText(0,app.getGroceryList().listAllGroceriesAsText());
                            list.getItems().setAll(app.getGroceryList().getList());
                            outputArea.insertText(0,"[List] finish\n");
                            listGroceries.setDisable(false);
                        }
                    });


                }
            };

            new Thread(task).start();

        }
        else if (e.getSource().equals(addGroceries)) {
            Runnable task = new Runnable(){
                @Override
                public void run() {

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            addGroceries.setDisable(true);

                        }
                    });
                    app.getGroceryList().getMultipleGroceryItemsCLI();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {

                            addGroceries.setDisable(false);
                        }
                    });


                }
            };

            new Thread(task).start();

        }
        else if (e.getSource().equals(removeGroceries)) { app.getGroceryList().removeItemCLI();}
    }

    public HomeController(){
        app.getGroceryList().addItem(new GroceryItem("beer",1));
        app.getGroceryList().addItem(new GroceryItem("tomatoes",1));
        app.getGroceryList().addItem(new GroceryItem("potatoes",2));
    }


}
