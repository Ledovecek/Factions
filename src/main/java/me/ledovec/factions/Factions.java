package me.ledovec.factions;

import lombok.SneakyThrows;
import me.ledovec.factions.listeners.PlayerListener;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import static me.ledovec.factions.Checker.*;

import java.io.File;

public class Factions extends JavaPlugin {

    @SneakyThrows
    @Override
    public void onEnable() {
        File file = new File("plugins/Factions/data");
        file.mkdirs();
        checkRunningPlugins();

        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll();
    }

}
