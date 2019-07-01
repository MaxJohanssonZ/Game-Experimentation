package Game.DatabaseConnector;

import Game.Profile.Character;
import Game.Profile.Profile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

import static Game.MainMenu.mainMenuController.selectedProfile;

public class DbConnector {
    public Connection connection = null;
    public Statement statement;
    public ResultSet resultSet;
    public static ObservableList<Profile> observableListProfile = FXCollections.observableArrayList();

    public void connect() {
        try {
            String url = "jdbc:mysql://den1.mysql5.gear.host:3306/gameprojectrpg?verifyServerCertificate=false&useSSL=false&allowPublicKeyRetrieval=true&user=gameprojectrpg&password=Wm8NZ85F7?j-&serverTimeZone=UTF-8";
            connection = DriverManager.getConnection(url);
        } catch (SQLException sql) {
            System.err.println("Connection failed" + sql);
        }
    }

    public void disconnect() {
        try {
            if (connection != null)
                connection.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException ex) {
            System.out.println("Failed to disconnect");
        }
    }

    public void getProfileData(){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM profile WHERE username = ?");
            resultSet = preparedStatement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getProfilesFromDB(){
        observableListProfile.clear();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM profile");
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                Profile profile = new Profile(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                );
                observableListProfile.add(profile);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public void addNewProfileToDB(Profile profile){
        connect();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO `profile`(profileID, username, firstName, lastName, points) VALUES (?,?,?,?,?)");
            ps.setInt(1, profile.getProfileID());
            ps.setString(2, profile.getUsername());
            ps.setString(3, profile.getFirstName());
            ps.setString(4, profile.getLastName());
            ps.setInt(5, profile.getPoint());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error when creating new profile");
        } finally {
            disconnect();
        }
    }

    public void addNewCharacterToDB(Character character){
        connect();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO `character`(characterID, characterName, dps, health, profile_profileID) VALUES (?,?,?,?,?)");
            ps.setInt(1, character.getCharacterID());
            ps.setString(2, character.getCharFirstName());
            ps.setDouble(3, character.getDamageDone());
            ps.setInt(4, character.getHealth());
            ps.setInt(5, selectedProfile.getProfileID());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error creating new character");
        } finally {
            disconnect();
        }
    }
}