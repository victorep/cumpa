package cumpa.gui;

import cumpa.App;
import cumpa.datamodel.GroceryItem;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class NewDialogController {
    @FXML
    private TextField name;

    @FXML
    private TextField units;

    public void processResults() {
        App.getInstance().getGroceryList().add(new GroceryItem(name.getText(),Integer.parseInt(units.getText())));
    }
}
