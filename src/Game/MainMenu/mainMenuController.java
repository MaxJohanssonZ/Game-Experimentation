package Game.MainMenu;

import Game.Backend.Logic;
import Game.DatabaseConnector.DbConnector;
import Game.Profile.Profile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static Game.DatabaseConnector.DbConnector.observableListProfile;

public class mainMenuController implements Initializable {
    @FXML
    Button btnStartGame, btnLeaderboard, btnCreateProfile;

    @FXML
    TableView<Profile> profileList;

    @FXML
    TableColumn<Profile, String> profiles;

    public static final Logic logic = new Logic();
    public static DbConnector dbConnector = new DbConnector();
    public static Profile selectedProfile;

    public void createProfile(ActionEvent event) {
        String createProfileFXML = "/Game/CreateProfile/createProfile.fxml";
        logic.changeSceneHandler(event, createProfileFXML, false);
    }

    public void startGame(ActionEvent event) {
        Profile profile = profileList.getSelectionModel().getSelectedItem();
        if (profile != null) {
            System.out.println("Profile successfully chosen");
            selectedProfile = profile;
            System.out.println(selectedProfile.getUsername() + selectedProfile.getFirstName() + selectedProfile.getProfileID());
            logic.changeSceneHandler(event, "/Game/CharacterHandling/CharacterSelection/CharacterSelection.fxml", true);
        } else {
            System.out.println("No profile chosen");
        }
    }

    public void closeProgram() {
        System.exit(0);
        System.out.println("Program closed!");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbConnector.connect();
        dbConnector.getProfilesFromDB();
        profiles.setCellValueFactory(new PropertyValueFactory<>("username"));
        profileList.setItems(observableListProfile);
        dbConnector.disconnect();
    }
}