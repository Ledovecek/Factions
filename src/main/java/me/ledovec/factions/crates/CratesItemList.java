package me.ledovec.factions.crates;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

import static me.ledovec.factions.Utils.*;

public class CratesItemList {

    public static ArrayList<ItemStack> itemStackArrayList = new ArrayList<>();

    public static ItemStack item1 = createItem(Material.GOLDEN_AXE, "§eBlitz axe §8(§9Rare§8)", Enchantment.FIRE_ASPECT, 3);
    public static ItemStack item2 = createItem(Material.LEATHER_HELMET, "Safety helmet", Enchantment.PROTECTION_ENVIRONMENTAL, 5);


    public ArrayList getItemsArrayList() {
        itemStackArrayList.add(item1);
        itemStackArrayList.add(item2);

        return itemStackArrayList;
    }

}
