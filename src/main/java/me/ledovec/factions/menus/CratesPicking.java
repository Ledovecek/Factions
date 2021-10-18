package me.ledovec.factions.menus;

import me.ledovec.factions.crates.CratesItemList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

import static me.ledovec.factions.Utils.*;

public class CratesPicking {

    private String TITLE = "§6Crate";
    private Inventory inv;

    public CratesPicking() {
        inv = Bukkit.createInventory(null, 27, TITLE);
        setup();
    }

    private void setup() {
        CratesItemList cratesItemList = new CratesItemList();
         ArrayList itemsArrayList = cratesItemList.getItemsArrayList();

        for (int i = 1; i < 9; i++) inv.setItem(i, createNonEnchantedItem(Material.BLACK_STAINED_GLASS_PANE, "§e"));
        for (int i = 19; i < 27; i++) inv.setItem(i, createNonEnchantedItem(Material.BLACK_STAINED_GLASS_PANE, "§e"));

        for (int i = 10; i < 18; i++) {
            inv.setItem(i, (ItemStack) cratesItemList.getItemsArrayList().get(1));
        }
    }

    public void openInventory(HumanEntity humanEntity) {
        humanEntity.openInventory(inv);
    }

}
