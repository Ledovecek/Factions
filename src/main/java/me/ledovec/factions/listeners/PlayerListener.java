package me.ledovec.factions.listeners;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import me.ledovec.factions.currency.Money;
import me.ledovec.factions.menus.CratesPicking;
import me.ledovec.factions.menus.RaceSelector;
import me.ledovec.factions.storing.sql.SQLStatements;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    private final String TITLE1 = "§c<§2< §c§lFACTIONS §2>§c>";
    private final String SUBTITLE = "§eHave fun!";

    private Money money = new Money();
    SQLStatements sqlStatements = new SQLStatements();

    @SneakyThrows
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        p.sendTitle(TITLE1, SUBTITLE);
        if(!p.hasPlayedBefore()) {
            sqlStatements.storePlayer(p.getUniqueId(), p.getName(), 10000, "not-selected", p.getAddress().getHostString());
        }

        //TODO: Kontrola jestli hrac nema jiz vybranou roli
        p.teleport(new Location(Bukkit.getWorld("world"), 37.5, 62, 120.5, 90, 0));
        RaceSelector.open(e.getPlayer());

    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        CratesPicking cratesPicking = new CratesPicking();
        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getClickedBlock().equals(Material.CHEST)) {
            if(e.getClickedBlock().getLocation().equals(new Location(Bukkit.getWorld("world"), 0, 60, 0))) {
                e.setCancelled(true);
                cratesPicking.openInventory(player);
            }
        }
    }

}
