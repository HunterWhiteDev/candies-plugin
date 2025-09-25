package com.zykedelia.plugin;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CandyListeners implements Listener {

    @EventHandler
    public void onPlayerUseItem(PlayerInteractEvent event) {

        Action action = event.getAction();
        if (action != Action.RIGHT_CLICK_AIR && action != Action.RIGHT_CLICK_BLOCK) return;

        ItemStack item = event.getItem();
        if (item == null || !item.hasItemMeta()) return;

        // Check for your custom tag
        ItemMeta meta = item.getItemMeta();
        NamespacedKey key = new NamespacedKey(Main.getInstance(), "candy");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        NamespacedKey candyTypeKey = new NamespacedKey(Main.getInstance(), "candyType");

        if (!container.has(key, PersistentDataType.BYTE)) return;

        Player player = event.getPlayer();

        String candyType = container.get(candyTypeKey, PersistentDataType.STRING);
        switch (candyType) {
            case "chocolate_bar":
                {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 15, 3));
                    break;
                }
            case "sour_head":
                {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INSTANT_HEALTH, 1, 2));

                    player.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 20 * 7, 2));
                    break;
                }
            case "licorice":
                {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.HASTE, 20 * 10, 2));

                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 20 * 2, 1));
                    break;
                }
            case "candycorn":
                {
                    player.addPotionEffect(
                            new PotionEffect(PotionEffectType.SLOW_FALLING, 20 * 5, 1));

                    break;
                }
            case "bubblegum":
                {
                    player.addPotionEffect(
                            new PotionEffect(PotionEffectType.JUMP_BOOST, 20 * 10, 1));

                    break;
                }
            case "kiss":
                {
                    player.addPotionEffect(
                            new PotionEffect(PotionEffectType.NIGHT_VISION, 20 * 5, 1));
                    break;
                }
        }

        item.setAmount(item.getAmount() - 1);

        player.setFoodLevel(player.getFoodLevel() + 2);
        // Optional: prevent default right-click behavior (e.g. placing a bucket)
        // event.setCancelled(true);
    }
}
