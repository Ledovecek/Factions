package me.ledovec.factions.listeners;

import com.google.gson.Gson;
import me.ledovec.factions.menus.RaceSelector;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    private final String TITLE1 = "§c<§2< §c§lFACTIONS §2>§c>";
    private final String SUBTITLE = "§eHave fun!";

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Gson gson = new Gson();

        p.sendTitle(TITLE1, SUBTITLE);

        if(!p.hasPlayedBefore()) {
            gson.toJson("Factions/data/" + e.getPlayer().getName() + ".fcdata");
        }

        //TODO: Kontrola jestli hrac nema jiz vybranou roli
        p.teleport(new Location(Bukkit.getWorld("world"), 37.5, 62, 120.5, 90, 0));
        RaceSelector.open(e.getPlayer());


    }

}
