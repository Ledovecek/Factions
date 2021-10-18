package me.ledovec.factions;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static ItemStack createItem(final Material material, String name, Enchantment enchantment, int enchantmentSize, final String... lore) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();
        Map<Enchantment, Integer> enchantments = new HashMap<>();

        enchantments.put(Enchantment.DURABILITY, 10);
        enchantments.put(enchantment, enchantmentSize);

        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.addUnsafeEnchantments(enchantments);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack createItem(final Material material, String name, final String... lore) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack createNonEnchantedItem(final Material material, String name, final String... lore) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);

        return item;
    }

}
