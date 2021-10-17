package me.ledovec.factions.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.ledovec.factions.Utils.*;

public class Crates {

    private String CRATES_MENU_1_NAME = "Menu 1";
    private String CRATES_MENU_2_NAME = "Menu 2";
    private String CRATES_MENU_3_NAME = "Menu 3";

    private Inventory inv;
    private int chestType;

    public Crates(int chestType) {
        this.chestType = chestType;
        switch (chestType) {
            case 1:
                inv = Bukkit.createInventory(null, 54, CRATES_MENU_1_NAME);
                break;
            case 2:
                inv = Bukkit.createInventory(null, 54, CRATES_MENU_2_NAME);
                break;
            case 3:
                inv = Bukkit.createInventory(null, 54, CRATES_MENU_3_NAME);
                break;
        }

        inv = Bukkit.createInventory(null, 54, "");

        setup();
    }

    public void setup() {
        ItemStack chest1 = createNonEnchantedItem(Material.CHEST, "§eBasic Chest", "", "§eKeys: §b0");
        ItemStack chest2 = createNonEnchantedItem(Material.TRAPPED_CHEST, "§6Advanced Chest", "", "§eKeys: §b0");
        ItemStack chest3 = createNonEnchantedItem(Material.ENDER_CHEST, "§5Epic Chest", "", "§eKeys: 0");

        switch (chestType) {
            case 1:
                inv.setItem(27, chest1);
                break;
            case 2:
                inv.setItem(27, chest2);
                break;
            case 3:
                inv.setItem(27, chest3);
                break;
        }
    }

}
