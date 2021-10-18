package me.ledovec.factions.storing.sql;

import me.ledovec.factions.storing.MySQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SQLStatements {

    public MySQLConnector mySQLConnector;
    public Connection connection;

    public SQLStatements() {
        this.mySQLConnector = new MySQLConnector();
        this.mySQLConnector.connect();
        this.connection = mySQLConnector.getConnection();
    }

    //TODO: First / Last login
    public void storePlayer(UUID uuid, String name, double money, String race, String ip) throws SQLException {
        PreparedStatement statement;
        statement = connection.prepareStatement("INSERT INTO factions_players VALUES (?,?,?,?,?)");
        statement.setString(1, String.valueOf(uuid));
        statement.setString(2, name);
        statement.setDouble(3, money);
        statement.setString(4, race);
        statement.setString(5, ip);
        statement.execute();
    }

    public void controlRaces() throws SQLException {
        PreparedStatement statement;
        statement = connection.prepareStatement("SELECT `nickname` FROM `factions_players` WHERE `race` = 'not-selected'");
        statement.execute();
    }

}
