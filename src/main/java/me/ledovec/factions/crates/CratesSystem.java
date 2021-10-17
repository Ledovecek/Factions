package me.ledovec.factions.crates;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Random;

import static me.ledovec.factions.crates.CratesItemList.*;

public class CratesSystem {

    ArrayList<ItemStack> itemList = new ArrayList<>();
    Random random = new Random();

    public ItemStack pickRandomItem() {
        int itemListSize = itemList.size();
        int randomInt = random.nextInt(itemListSize);
        return itemList.get(randomInt);
    }

    public void setupItemList() {
        itemList.add(item1);
        itemList.add(item2);
    }

}
