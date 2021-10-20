package me.ledovec.factions.storing.sql;

import me.ledovec.factions.storing.MySQLConnector;

import java.sql.*;
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
    public void storePlayer(UUID uuid, String name, double money, String race, String firstIP, String lastIP) throws SQLException {
        PreparedStatement statement;
        statement = connection.prepareStatement("INSERT INTO factions_players VALUES (?,?,?,?,?,?)");
        statement.setString(1, String.valueOf(uuid));
        statement.setString(2, name);
        statement.setDouble(3, money);
        statement.setString(4, race);
        statement.setString(5, firstIP);
        statement.setString(6, lastIP);
        statement.execute();
        statement.close();
    }

    public void updatePlayer(UUID uuid, double money, String race,String ip) throws SQLException {
        PreparedStatement statement;
        statement = connection.prepareStatement("UPDATE factions_players SET money=?, race=?,lastIP=? WHERE uuid = ?");
        statement.setDouble(1, money);
        statement.setString(2, race);
        statement.setString(3, ip);
        statement.setString(4, String.valueOf(uuid));
        statement.execute();
        statement.close();
    }

    public String getPlayerRace(String playerName) throws SQLException {
        PreparedStatement statement;
        statement = connection.prepareStatement("SELECT `nickname` FROM `factions_players` WHERE `race` = 'not-selected' AND `nickname` = ?");
        statement.setString(1, playerName);
        ResultSet results = statement.executeQuery();
        ResultSetMetaData metaData = results.getMetaData();
        int index = results.getRow();
        String name = metaData.getColumnName(0);
        String value = results.getString(0);
        results.close();
        statement.close();
        return value;
    }

}
