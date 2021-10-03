package me.ledovec.factions.listeners;

import me.ledovec.factions.menus.RaceSelector;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        //TODO: Kontrola jestli hrac nema jiz vybranou roli
        p.teleport(new Location(Bukkit.getWorld("world"), 0, 60, 0, 90, 0));
        RaceSelector.open(e.getPlayer());
    }

}
