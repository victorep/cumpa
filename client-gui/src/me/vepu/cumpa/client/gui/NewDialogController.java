package me.vepu.cumpa.client.gui;



import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import me.vepu.cumpa.app.App;
import me.vepu.cumpa.app.datamodel.GroceryItem;


public class NewDialogController {
    @FXML
    private TextField name;

    @FXML
    private TextField units;

    public void processResults() {
        App.getInstance().getGroceryListArrayListImpl().add(new GroceryItem(name.getText(),Integer.parseInt(units.getText())));
    }
}
