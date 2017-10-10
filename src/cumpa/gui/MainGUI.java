package cumpa.gui;


import cumpa.App;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGUI extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        App app=new App();
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setTitle(app.getAppName()+" - "+ app.getAppVersion());
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
