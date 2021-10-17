package me.ledovec.factions;

import org.bukkit.Bukkit;

import java.util.logging.Logger;

public class Checker {

    public static void checkRunningPlugins() {
        if(Bukkit.getServer().getPluginManager().getPlugin("Vault") == null) Bukkit.getServer().shutdown();
    }

}
