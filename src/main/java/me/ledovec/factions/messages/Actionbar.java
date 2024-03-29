package me.ledovec.factions.messages;

import com.google.common.collect.Lists;
import me.ledovec.factions.Factions;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Actionbar {

    private String PLAYER_ACTIONBAR_MESSAGE = "§cFactions §8| ";

    private static final List<String> MESSAGES = Lists.newArrayList(
            "§eHave you tried our crates yet? §e§lTRY IT",
            "§eVisit your website §6www.fc-server.net§e!"
    );

    private final long interval = 10*20L;
    private long uptime = 0L;
    private int currentIndex = 0;

    private final Random r = new Random();

    public void start(final Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if(!player.isOnline()) {
                    cancel();
                    return;
                }
                tick(player);
            }
        }.runTaskTimer(Bukkit.getPluginManager().getPlugin("Factions"), 0L, 20L);
    }

    public void tick(final Player player) {
        if(MESSAGES.isEmpty()) return;
        if(uptime % interval == 0) {
            currentIndex = currentIndex >= MESSAGES.size() - 1
                    ? 0
                    : currentIndex + 1;
        }
        String current = MESSAGES.get(r.nextInt(MESSAGES.size()));
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(PLAYER_ACTIONBAR_MESSAGE + current));
        uptime += 20L;
    }

}
