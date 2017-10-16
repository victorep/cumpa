package cumpa.gui;

import cumpa.App;
import cumpa.datamodel.GroceryList;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;

import java.util.Optional;


public class HomeController {

    @FXML
    private BorderPane homePane;

    @FXML
    private Button reloadGroceries;

    @FXML
    private Button addGroceries;

    @FXML
    private Button removeGroceries;

    @FXML
    private Button save;

    @FXML
    private Button exit;

    @FXML
    private TextArea outputArea;

    @FXML
    private ListView list;

    //Array to store our items
    private App app = App.getInstance();

    private GroceryList groceryList = app.getGroceryList();

    public HomeController() { refreshList(); }

    @FXML
    private void buttonPress(ActionEvent e) {
        if (e.getSource().equals(reloadGroceries)){ refreshList(); }
        else if (e.getSource().equals(addGroceries)) {
           {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() { addGroceries.setDisable(true); }
                    });
                    showNewItemDialog();
                    refreshList();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            refreshList();
                            addGroceries.setDisable(false);
                        }
                    });

            };
            //new Thread(task).start();
        }
        else if (e.getSource().equals(removeGroceries)) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            reloadGroceries.setDisable(true);
                            if (list.getSelectionModel().getSelectedIndex() > -1) {
                                groceryList.remove(list.getSelectionModel().getSelectedIndex());
                                outputArea.insertText(0, "[Remove] Item removed\n");
                                refreshList();
                            } else outputArea.insertText(0, "[Remove] Error: no item selected\n");
                            reloadGroceries.setDisable(false);
                        }
                    });
                }
            };
            new Thread(task).start();
        }
        else if (e.getSource().equals(save)) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            reloadGroceries.setDisable(true);
                            try {
                                app.save();
                                outputArea.insertText(0, "[save] data saved\n");
                            }
                            catch (Exception e) { e.printStackTrace(); }
                            finally { reloadGroceries.setDisable(false);}
                        }
                    });
                }
            };
            new Thread(task).start();
        }
        else if (e.getSource().equals(exit)) { Platform.exit(); }
    }

    public void refreshList() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        reloadGroceries.setDisable(true);
                        try {
                            list.getItems().setAll(groceryList);
                            outputArea.insertText(0, "[List] List (re)loaded\n");
                        }
                        catch (Exception e) { e.printStackTrace(); }
                        finally { reloadGroceries.setDisable(false); }
                    }
                });
            }
        };
        new Thread(task).start();
    }

    @FXML
    public void showNewItemDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(homePane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("newDialog.fxml"));
        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (Exception e){
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            NewDialogController controller = fxmlLoader.getController();
            controller.processResults();
            refreshList();
        }


    }
}
