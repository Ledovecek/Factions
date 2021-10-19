package me.ledovec.factions;

import lombok.SneakyThrows;
import me.ledovec.factions.commands.LookupCommand;
import me.ledovec.factions.crates.CratesItemList;
import me.ledovec.factions.listeners.PlayerListener;
import me.ledovec.factions.storing.MySQLConnector;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

import static me.ledovec.factions.Checker.checkRunningPlugins;

public class Factions extends JavaPlugin {

    CratesItemList cratesItemList = new CratesItemList();
    MySQLConnector mySQLConnector = new MySQLConnector();

    @SneakyThrows
    @Override
    public void onEnable() {
        File file = new File("plugins/Factions/data");
        file.mkdirs();
        checkRunningPlugins();
        cratesItemList.setup();
        mySQLConnector.connect();
        commandRegister();

        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @SneakyThrows
    @Override
    public void onDisable() {
        HandlerList.unregisterAll();
        mySQLConnector.connection.close();
        cratesItemList.getItemsArrayList().clear();
    }

    private void commandRegister() {
        getCommand("lookup").setExecutor(new LookupCommand());
    }

}
