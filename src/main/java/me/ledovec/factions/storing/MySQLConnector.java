package me.ledovec.factions.storing;

import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {

    public Connection connection;

    public void connect() {
        String url = "jdbc:mysql://mysql.hostify.cz/db_70127_Factions?user=user_ledovec&password=Ledovec1";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url);
            if (connection != null && !connection.isClosed()) {
                System.out.println("[LedSQLAdapter] Database successfully connected.");
            } else {
                System.out.println("[LedSQLAdapter] Database is not connected - server shutdown.");
                Bukkit.shutdown();
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("[LedSQLAdapter] Could not connect to the database - server shutdown.");
            Bukkit.shutdown();
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
