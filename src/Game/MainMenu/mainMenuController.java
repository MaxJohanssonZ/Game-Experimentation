package Game.MainMenu;

import Game.Backend.Logic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class mainMenuController implements Initializable {
    @FXML
    Button btnStartGame, btnLeaderboard, btnCreateProfile;

    public static final Logic logic = new Logic();

    public void createProfile (ActionEvent event){
        String createProfileFXML = "/Game/CreateProfile/createProfile.fxml";
        logic.changeSceneHandler(event, createProfileFXML, false);
    }

    public void closeProgram(){
        System.exit(0);
        System.out.println("Program closed!");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}