package com.zykedelia.plugin;

import com.zykedelia.plugin.Candies.Candy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveCandyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(
            CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        if (!sender.hasPermission("candy.give")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission.");
            return true;
        }

        if (args.length < 2) {
            sender.sendMessage(ChatColor.GRAY + "Usage: /givecandy <player> <candy>");
            return true;
        }

        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }

        // Create and give candy
        ItemStack candy = Candies.getCandy(Candy.valueOf(args[1]));
        target.getInventory().addItem(candy);

        sender.sendMessage("player has been given candy");

        return true;
    }
}
