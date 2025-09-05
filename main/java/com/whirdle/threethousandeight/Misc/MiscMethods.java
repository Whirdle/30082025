package com.whirdle.threethousandeight.Misc;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class MiscMethods {

    public static void sendFeedback(CommandSender sender, String message) {
        sendFeedback(sender, message, true);
    }
    public static void sendFeedback(CommandSender sender, String message, boolean returnPrefix) {

        String feedbackPrefix = "&6[&cAttb&6] &r";
        String newLine = ": ";

        if (!returnPrefix){
            feedbackPrefix = "";
            newLine = ":\n"; // look away
        }

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', feedbackPrefix + message));
//        getServer().getLogger().info(ChatColor.stripColor("\u001B[37m" + "[" + sender.getName() + newLine + message + "]")); // player feedback logging to console
    }
}
