package Game.DatabaseConnector;

import java.sql.*;

public class DbConnector {
    public Connection connection = null;
    public Statement statement;
    public ResultSet resultSet;

    public void connect() {
        try {
            String url = "jdbc:mysql://den1.mysql3.gear.host:3306/bustblockerdb?verifyServerCertificate=false&useSSL=false&allowPublicKeyRetrieval=true&user=bustblockerdb&password=bustblocker!&serverTimeZone=UTF-8";
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
}