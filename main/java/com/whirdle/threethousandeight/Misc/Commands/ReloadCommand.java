package com.whirdle.threethousandeight.Misc.Commands;

import com.whirdle.threethousandeight.Attributes.db.DatabaseCredentialsConfig;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof ConsoleCommandSender)){
            return false;
        }
        DatabaseCredentialsConfig.reload();

        return true;
    }
}