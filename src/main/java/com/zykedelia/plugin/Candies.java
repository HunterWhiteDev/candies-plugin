package com.zykedelia.plugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.List;

public class Candies {
    public static ItemStack getCandy(String candyName) {

        ItemStack candyItem = new ItemStack(Material.WHITE_DYE);
        candyItem.addUnsafeEnchantment(Enchantment.UNBREAKING, 1);
        ItemMeta candyMeta = candyItem.getItemMeta();
        candyMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        PersistentDataContainer container = candyMeta.getPersistentDataContainer();

        container.set(
                new NamespacedKey(Main.getInstance(), "candy"), PersistentDataType.BYTE, (byte) 1);

        List<String> lore = Arrays.asList();

        switch (candyName) {
            case "chocolatebar":
                {
                    candyMeta.setDisplayName(ChatColor.GOLD + "Chocolate Bar");
                    candyItem.setType(Material.BROWN_DYE);

                    lore =
                            Arrays.asList(
                                    ChatColor.LIGHT_PURPLE
                                            + "Speed IV"
                                            + " "
                                            + ChatColor.GRAY
                                            + ChatColor.ITALIC
                                            + "15 seconds",
                                    " ",
                                    ChatColor.GRAY + "Right click to eat");
                    candyMeta.setItemModel(new NamespacedKey(Main.getInstance(), "chocolate_bar"));
                    container.set(
                            new NamespacedKey(Main.getInstance(), "candyType"),
                            PersistentDataType.STRING,
                            "chocolate_bar");
                    break;
                }
            case "sourhead":
                {
                    candyMeta.setDisplayName(ChatColor.GREEN + "Sour Head");
                    candyItem.setType(Material.LIME_DYE);

                    lore =
                            Arrays.asList(
                                    ChatColor.LIGHT_PURPLE
                                            + "+4 Health"
                                            + " "
                                            + ChatColor.GRAY
                                            + ChatColor.ITALIC
                                            + "15 seconds",
                                    ChatColor.RED
                                            + "Nausea"
                                            + " "
                                            + ChatColor.GRAY
                                            + ChatColor.ITALIC
                                            + "7 seconds",
                                    " ",
                                    ChatColor.GRAY + "Right click to eat");
                    container.set(
                            new NamespacedKey(Main.getInstance(), "candyType"),
                            PersistentDataType.STRING,
                            "sour_head");

                    candyMeta.setItemModel(new NamespacedKey(Main.getInstance(), "sour_head"));
                    break;
                }
            case "licorice":
                {
                    candyMeta.setDisplayName(ChatColor.DARK_AQUA + "Licorice");
                    candyItem.setType(Material.BLACK_DYE);

                    lore =
                            Arrays.asList(
                                    ChatColor.LIGHT_PURPLE
                                            + "Haste II"
                                            + " "
                                            + ChatColor.GRAY
                                            + ChatColor.ITALIC
                                            + "10 seconds",
                                    ChatColor.RED
                                            + "Slowness I"
                                            + " "
                                            + ChatColor.GRAY
                                            + ChatColor.ITALIC
                                            + "2 seconds",
                                    " ",
                                    ChatColor.GRAY + "Right click to eat");
                    container.set(
                            new NamespacedKey(Main.getInstance(), "candyType"),
                            PersistentDataType.STRING,
                            "licorice");

                    candyMeta.setItemModel(new NamespacedKey(Main.getInstance(), "licorice"));
                    break;
                }
            case "candycorn":
                {
                    candyMeta.setDisplayName(ChatColor.YELLOW + "Candy Corn");
                    candyItem.setType(Material.YELLOW_DYE);

                    lore =
                            Arrays.asList(
                                    ChatColor.LIGHT_PURPLE
                                            + "Slow Falling"
                                            + " "
                                            + ChatColor.GRAY
                                            + ChatColor.ITALIC
                                            + "5 seconds",
                                    " ",
                                    ChatColor.GRAY + "Right click to eat");
                    container.set(
                            new NamespacedKey(Main.getInstance(), "candyType"),
                            PersistentDataType.STRING,
                            "candycorn");

                    candyMeta.setItemModel(new NamespacedKey(Main.getInstance(), "candy_corn"));
                    break;
                }
            case "bubblegum":
                {
                    candyMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Bubble Gum");
                    candyItem.setType(Material.ORANGE_DYE);

                    lore =
                            Arrays.asList(
                                    ChatColor.LIGHT_PURPLE
                                            + "Jump boost"
                                            + " "
                                            + ChatColor.GRAY
                                            + ChatColor.ITALIC
                                            + "10 seconds",
                                    " ",
                                    ChatColor.GRAY + "Right click to eat");
                    container.set(
                            new NamespacedKey(Main.getInstance(), "candyType"),
                            PersistentDataType.STRING,
                            "bubblegum");

                    candyMeta.setItemModel(new NamespacedKey(Main.getInstance(), "bubble_gum"));
                    break;
                }
            case "kiss":
                {
                    candyMeta.setDisplayName(ChatColor.AQUA + "Kiss");
                    candyItem.setType(Material.WHITE_DYE);

                    lore =
                            Arrays.asList(
                                    ChatColor.LIGHT_PURPLE
                                            + "Night Vision"
                                            + " "
                                            + ChatColor.GRAY
                                            + ChatColor.ITALIC
                                            + "10 seconds",
                                    " ",
                                    ChatColor.GRAY + "Right click to eat");
                    container.set(
                            new NamespacedKey(Main.getInstance(), "candyType"),
                            PersistentDataType.STRING,
                            "kiss");

                    candyMeta.setItemModel(new NamespacedKey(Main.getInstance(), "kiss"));
                    break;
                }
        }
        candyMeta.setLore(lore);

        candyItem.setItemMeta(candyMeta);

        return candyItem;
    }
}
