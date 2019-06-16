package Game.CreateProfile;

import Game.DatabaseConnector.DbConnector;
import Game.Profile.Profile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

import static Game.MainMenu.mainMenuController.dbConnector;
import static Game.MainMenu.mainMenuController.logic;

public class CreateProfileController {
    @FXML
    Label lblUsername, lblFirstName, lblLastName, lblConfirmation;

    @FXML
    TextField txtUsername, txtFirstName, txtLastName;

    @FXML
    Button btnCreate, btnReturnToMM;

    public static ArrayList<Profile> profiles = new ArrayList<>();


    public void profileCreationBTS(){
        dbConnector.connect();
        Profile newProfile = new Profile(
                txtUsername.getText(),
                txtFirstName.getText(),
                txtLastName.getText(),
                0
        );

        dbConnector.addNewProfileToDB(newProfile);
        profiles.add(newProfile);
        dbConnector.disconnect();

        System.out.println(newProfile.getUsername());

        txtUsername.clear();
        txtFirstName.clear();
        txtLastName.clear();
        lblConfirmation.setText("Profile successfully created!");
    }

    public void returnToMainMenu(ActionEvent event){
        logic.changeSceneHandler(event, "/Game/MainMenu/mainMenu.fxml", false);
    }
}