package com.zykedelia.plugin;

import com.zykedelia.plugin.Candies.Candy;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

public class MobListener implements Listener {

    @EventHandler
    public void onMobKill(EntityDeathEvent event) {
        EntityType entityType = event.getEntityType();
        if (entityType == EntityType.CREEPER
                || entityType == EntityType.ZOMBIE
                || entityType == EntityType.SKELETON
                || entityType == EntityType.ENDERMAN) {

            int roll = ThreadLocalRandom.current().nextInt(100);

            if (roll < 10) {

                int itemScale = ThreadLocalRandom.current().nextInt(60);
                ItemStack item = new ItemStack(Material.AIR);
                if (itemScale >= 0 && itemScale <= 10) {
                    item = Candies.getCandy(Candy.candycorn);
                } else if (itemScale >= 11 && itemScale <= 20) {

                    item = Candies.getCandy(Candy.chocolatebar);
                } else if (itemScale >= 21 && itemScale <= 31) {
                    item = Candies.getCandy(Candy.bubblegum);
                } else if (itemScale >= 31 && itemScale <= 40) {
                    item = Candies.getCandy(Candy.kiss);
                } else if (itemScale >= 41 && itemScale <= 50) {
                    item = Candies.getCandy(Candy.licorice);
                } else if (itemScale >= 51 && itemScale <= 60) {
                    item = Candies.getCandy(Candy.sourhead);
                }

                org.bukkit.Location location = event.getEntity().getLocation();
                location.getWorld().dropItemNaturally(location, item);
            }
        }
    }
}
