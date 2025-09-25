package com.zykedelia.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Candies started");
        getCommand("givecandy").setExecutor(new GiveCandyCommand());

        getServer().getPluginManager().registerEvents(new CandyListeners(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Candies disabled");
    }

    public static Main getInstance() {
        return instance;
    }
}
