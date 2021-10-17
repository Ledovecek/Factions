package me.ledovec.factions.currency;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class Money {

    private Economy economy;

    public void depositMoney(OfflinePlayer player, double amount) {
        economy.depositPlayer(player, amount);
    }

    public void createPlayerAccount(Player player) {
        economy.createPlayerAccount(player);
    }

    public void withdrawMoney(OfflinePlayer offlinePlayer, double amount) {
        economy.withdrawPlayer(offlinePlayer, amount);
    }

    public double getMoneyBalance(OfflinePlayer offlinePlayer) {
        double balance = economy.getBalance(offlinePlayer);
        return balance;
    }

}
