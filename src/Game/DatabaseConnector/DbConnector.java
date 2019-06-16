package Game.DatabaseConnector;

import Game.Profile.Profile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

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
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO `profile`(profileID, username, firstName, lastName, points) VALUES (?,?,?,?,?)");
            ps.setInt(1, profile.getProfileID());
            ps.setString(2, profile.getUsername());
            ps.setString(3, profile.getFirstName());
            ps.setString(4, profile.getLastName());
            ps.setInt(5, profile.getPoint());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error when loading to database");
        }
    }
}