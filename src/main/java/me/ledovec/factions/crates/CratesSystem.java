package me.ledovec.factions.crates;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Random;

public class CratesSystem {

    Random random = new Random();
    CratesItemList cratesItemList = new CratesItemList();

    public ItemStack pickRandomItem() {
        int itemListSize = cratesItemList.getItemsArrayList().size();
        int randomInt = random.nextInt(itemListSize);
        return cratesItemList.itemStackArrayList.get(randomInt);
    }

}
