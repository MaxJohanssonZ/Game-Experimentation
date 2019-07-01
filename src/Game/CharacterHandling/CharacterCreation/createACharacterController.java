package Game.CharacterHandling.CharacterCreation;

import Game.Profile.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static Game.MainMenu.mainMenuController.*;

public class createACharacterController implements Initializable {
    @FXML
    TextField characterFirstName, characterTitle;

    public void createNewCharacter(){
        String characterName= characterFirstName.getText() + " " + characterTitle.getText();
        Character newCharacter = new Character(
                characterName,
                5,
                15
        );
        dbConnector.addNewCharacterToDB(newCharacter);
        //selectedProfile.getCharacterList().add(newCharacter);
        System.out.println("Character created! " + newCharacter.getCharFirstName());
    }

    public void returnToProfile(ActionEvent event){
        logic.changeSceneHandler(event, "/Game/CharacterHandling/CharacterSelection/CharacterSelection.fxml" , true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}