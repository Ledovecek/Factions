package me.ledovec.factions.messages;

import com.google.common.collect.Lists;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Boss;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

public class Bossbar {

    private static final List<String> MESSAGES = Lists.newArrayList(
            "§6§lWWW.SERVER.NET",
            "§a§lSTORE.SERVER.NET"
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
        BossBar bossbar = Bukkit.getServer().createBossBar(current, BarColor.BLUE, BarStyle.SOLID);
        bossbar.setVisible(true);
        bossbar.setProgress(100);
        uptime += 20L;
    }

}
