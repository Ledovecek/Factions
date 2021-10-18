package me.ledovec.factions.crates;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

import static me.ledovec.factions.Utils.*;

public class CratesItemList {

    public ArrayList<ItemStack> itemStackArrayList = new ArrayList<>();

    public ItemStack item1 = createItem(Material.GOLDEN_AXE, "§eBlitz axe §8(§9Rare§8)", Enchantment.FIRE_ASPECT, 3);
    public ItemStack item2 = createItem(Material.LEATHER_HELMET, "Safety helmet", Enchantment.PROTECTION_ENVIRONMENTAL, 5);


    public void setup() {
        itemStackArrayList.add(item1);
        itemStackArrayList.add(item2);
    }

    public ArrayList getItemsArrayList() {
        return itemStackArrayList;
    }

}
