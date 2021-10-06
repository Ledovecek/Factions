package me.ledovec.factions.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.ledovec.factions.Utils.*;

public class RaceSelector {

    private static Inventory inv;

    //races: Human, Elf, Dwarf, Orc, Dragonborn
    public static void open(Player p) {
        inv = Bukkit.createInventory(null, 45, "§eChoose your race §8| §cFactions");

        ItemStack human = createItem(Material.WOODEN_SWORD, "§7§l☄ §6Human §8| §eCivilization", "§7(Right click)\n\n§eSpecials:\n  §7• §eTODO");
        ItemStack elf = createItem(Material.WOODEN_SWORD, "§7§l✿ §6Elf §8| §eCivilization", "§7(Right click)\n\n§eSpecials:\n  §7• §eTODO");
        ItemStack dwarf = createItem(Material.WOODEN_SWORD, "§7§lΨ §9Dwarf §8| §eTribe", "§7(Right click)\n\n§eSpecials:\n  §7• §eTODO");
        ItemStack orc = createItem(Material.WOODEN_SWORD, "§7§l₪ §aOrc §8| §eHorde", "§7(Right click)\n\n§eSpecials:\n  §7• §eTODO");
        ItemStack dragonborn = createItem(Material.WOODEN_SWORD, "§7§l❂ §cDragonborn §8| §eCivilization", "§7(Right click)\n\n§eSpecials:\n  §7• §eTODO");

        inv.setItem(10, human);
        inv.setItem(12, elf);
        inv.setItem(14, dwarf);
        inv.setItem(16, orc);
        inv.setItem(18, dragonborn);

        p.openInventory(inv);
    }

}
