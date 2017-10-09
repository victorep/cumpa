package cumpa.gui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));



        primaryStage.setTitle("Cumpa - Grocery list");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

//
//        GridPane root = new GridPane();
//        root.setAlignment(Pos.CENTER);
//        root.setVgap(10);
//        root.setHgap(10);
//        root.addColumn(0);
//        root.addRow(0);
//        root.addRow(1);
//
//        root.add(greeting,0,0);
//        // root.add(table,0,1);
//        Label greeting = new Label("Welcome to Cumpa");
//        greeting.setTextFill(Color.GREEN);
//        greeting.setFont(Font.font("Times New Roman", FontWeight.BOLD,70));
//
////        TableView<GroceryItem> table = new TableView<>();
//        TableColumn<> nameColumn - new TableColumn<>()

    }

    public static void main(String[] args) {
        launch(args);
    }
}
