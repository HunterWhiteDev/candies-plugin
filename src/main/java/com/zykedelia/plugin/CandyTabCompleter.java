package com.zykedelia.plugin;

import com.zykedelia.plugin.Candies.Candy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CandyTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(
            CommandSender sender, Command command, String alias, String[] args) {

        // First argument: player names
        if (args.length == 1) {
            // Suggest online players whose name starts with what they've typed
            return Bukkit.getOnlinePlayers().stream()
                    .map(Player::getName)
                    .filter(name -> name.toLowerCase().startsWith(args[0].toLowerCase()))
                    .toList();
        }

        // Second argument: candy types
        if (args.length == 2) {
            String current = args[1].toLowerCase();
            return Arrays.stream(Candy.values())
                    .map(c -> c.name().toLowerCase())
                    .filter(c -> c.startsWith(current))
                    .toList();
        }

        // No more arguments
        return Collections.emptyList();
    }
}
