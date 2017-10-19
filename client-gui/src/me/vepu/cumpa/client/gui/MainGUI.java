package me.vepu.cumpa.client.gui;



import me.vepu.cumpa.app.App;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGUI extends Application {
    private App app = App.getInstance();

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setTitle(app.getAppName()+" - "+ app.getAppVersion());
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        app.exit();
       // super.stop();
    }
}
