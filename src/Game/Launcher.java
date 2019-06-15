package Game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu/mainMenu.fxml"));
        primaryStage.setTitle("Launcher");
        primaryStage.setScene(new Scene(root, 480, 360));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}