package me.ledovec.factions.board;

import me.ledovec.factions.Factions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class Board {

    public void updateBoard(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("Factions", "dummy", "Factions Test");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score online = objective.getScore("§7eOnline: ");

        Bukkit.getScheduler().runTaskAsynchronously(Factions.getPlugin(Factions.class), new BukkitRunnable() {
            @Override
            public void run() {
                online.setScore(Bukkit.getOnlinePlayers().size());
                player.setScoreboard(scoreboard);
            }
        });
    }
}