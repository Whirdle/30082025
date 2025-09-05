package com.whirdle.threethousandeight.Attributes;

import com.whirdle.threethousandeight.Attributes.Models.PresetAttributes;
import com.whirdle.threethousandeight.threethousandeight;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class PresetAttributeCommandTabCompletion implements TabCompleter {

    private final threethousandeight plugin;

    public PresetAttributeCommandTabCompletion(threethousandeight plugin) {
        this.plugin = plugin;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args){

        if (args.length == 1) {

            String[] options = {"save", "load", "info"};

            return List.of(options);
        }
        if (args.length == 2 && sender instanceof Player) {
            Player player = (Player) sender;
            String playerUUID = player.getUniqueId().toString();

            List<String> allPresetNames = null;
            try {
                allPresetNames = plugin.getDatabase().getAllPresetNamesByPlayerUUID(playerUUID);
            } catch (SQLException e) {
                System.out.println("dont nag me bout shi (theres a problem with tab competion, report to whirdle)");
            }

            String partialInput = args[1].toLowerCase();
            return allPresetNames.stream()
                    .filter(presetName -> presetName.toLowerCase().startsWith(partialInput))
                    .collect(Collectors.toList());
        }

        return null;
    }
}
