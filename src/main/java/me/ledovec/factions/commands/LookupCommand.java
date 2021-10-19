package me.ledovec.factions.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LookupCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;
        if (!(p instanceof Player)) {
            p.sendMessage("§c§l[!] §cCould not invoke this command from console.");
        }
        if (label.equalsIgnoreCase("lookup")) {
            p.sendMessage("§a§l[!] §fLooking for results..");
            if (args.length == 0) {
                p.sendMessage("§c§l[!] §fBad command usage! Use §e/lookup <player>");
            }
            if (args.length >= 1) {
                for (int i = 0; i < args.length; i++) {
                    p.sendMessage("\n" + args[i]);
                }
            }
        }
        return true;
    }
}
