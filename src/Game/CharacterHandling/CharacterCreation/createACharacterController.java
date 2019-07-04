package Game.CharacterHandling.CharacterCreation;

import Game.Profile.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

import static Game.MainMenu.mainMenuController.*;

public class createACharacterController implements Initializable {
    @FXML
    TextField characterFirstName, characterTitle;
    @FXML
    ComboBox<String> genderSelection;
    @FXML
    Button randomizeFirstName, randomizeTitle;

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

    public void randomizeName() throws FileNotFoundException {
        ArrayList<String> firstName = new ArrayList<>();
        Scanner scanner;
        if (genderSelection.getSelectionModel().isSelected(0)){
            System.out.println(genderSelection.getSelectionModel().getSelectedItem());
            scanner = new Scanner(new File("/Game/Backend/NameGeneration/MaleName.txt"));
            while(scanner.hasNext()){
                firstName.add(scanner.nextLine());
            }
        } else if (genderSelection.getSelectionModel().isSelected(1)){
            System.out.println(genderSelection.getSelectionModel().getSelectedItem());
            scanner = new Scanner(new File("/Game/Backend/NameGeneration/FemaleName.txt"));
            while(scanner.hasNext()){
                firstName.add(scanner.nextLine());
            }
        }

        Collections.shuffle(firstName);
        String pickWord = firstName.get(0);
        System.out.println(pickWord);
    }

    public void returnToProfile(ActionEvent event){
        logic.changeSceneHandler(event, "/Game/CharacterHandling/CharacterSelection/CharacterSelection.fxml" , true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genderSelection.getItems().add("Male");
        genderSelection.getItems().add("Female");
    }
}