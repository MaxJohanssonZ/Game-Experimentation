package Game.CharacterHandling.CharacterSelection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import static Game.MainMenu.mainMenuController.logic;
import static Game.MainMenu.mainMenuController.selectedProfile;

public class CharacterSelectionController implements Initializable {
    @FXML
    Label showUsername = new Label();

    public void returnToMainMenu(ActionEvent event){
        logic.changeSceneHandler(event, "/Game/MainMenu/mainMenu.fxml", false);
    }

    public void goToCharCreation(ActionEvent event){
        logic.changeSceneHandler(event, "/Game/CharacterHandling/CharacterCreation/createACharacter.fxml", false);
    }

    public void closeProgram(){
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showUsername.setText(selectedProfile.getUsername());
    }
}