package com.whirdle.threethousandeight.Attributes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class AttributeCommandTabCompletion implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args){

        if (args.length == 1) {

            String[] attributes = {
                    "SCALE",
                    "STEP_HEIGHT",
                    "BLOCK_INTERACTION_RANGE",
                    "CAMERA_DISTANCE",
                    "ENTITY_INTERACTION_RANGE",
                    "GRAVITY",
                    "JUMP_STRENGTH",
                    "KNOCKBACK_RESISTANCE",
                    "MOVEMENT_EFFICIENCY",
                    "SNEAKING_SPEED",
                    "WATER_MOVEMENT_EFFICIENCY",
                    "WAYPOINT_RECEIVE_RANGE",
                    "WAYPOINT_TRANSMIT_RANGE"
            };

            return List.of(attributes);
        }
        if (args.length == 2) {

            String[] values = {"default", "0", "0.5", "1", "2", "5", "10", "50", "67", "100"};

            return List.of(values);
        }

        return null;
    }
}