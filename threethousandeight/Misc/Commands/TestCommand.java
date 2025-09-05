package com.whirdle.threethousandeight.Misc.Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;

public class TestCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack killItem = new ItemStack(Material.DIAMOND_SWORD);
            killItem.setAmount(69);
            killItem.setLore(Collections.singletonList("supa kewal sord"));

            player.getInventory().addItem(killItem);

        }
        return true;
    }
}
