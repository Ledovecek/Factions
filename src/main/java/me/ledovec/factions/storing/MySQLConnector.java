package me.ledovec.factions.storing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {

    private Connection connection;

    public void connect() {
        String url = "jdbc:mysql://mysql.hostify.cz/db_70127_Factions?user=user_ledovec&password=Ledovec1";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
