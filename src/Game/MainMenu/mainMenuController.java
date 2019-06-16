package Game.MainMenu;

import Game.Backend.Logic;
import Game.DatabaseConnector.DbConnector;
import Game.Profile.Profile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.net.URL;
import java.util.ResourceBundle;

import static Game.DatabaseConnector.DbConnector.observableListProfile;

public class mainMenuController implements Initializable {
    @FXML
    Button btnStartGame, btnLeaderboard, btnCreateProfile;

    @FXML
    ListView<Profile> profileList;

    public static final Logic logic = new Logic();
    public static DbConnector dbConnector = new DbConnector();

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
        dbConnector.connect();
        dbConnector.getProfilesFromDB();
        profileList.setItems(observableListProfile);
        dbConnector.disconnect();
    }
}