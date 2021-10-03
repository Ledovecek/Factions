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
        inv = Bukkit.createInventory(null, 27, "§eChoose your race §8| §cFactions");

        ItemStack human = createItem(Material.WOODEN_SWORD, "§6Human §8| §eCivilization", "§7(Right click)\n\n§eSpecials:\n  §7• §eTODO");

        inv.setItem(11, human);

        p.openInventory(inv);
    }

}
