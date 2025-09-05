package com.whirdle.threethousandeight.Attributes;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.whirdle.threethousandeight.Misc.MiscMethods.sendFeedback;

public class AttributeCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String usageError = "usage: /attribute <attribute> <value>";

        if (args.length < 2) {
        sendFeedback(sender,usageError);
        return true;
    }
        String attributeArg = args[0];


        Player player = (Player) sender;

        try {
            double valueArg;


            // Get the appropriate attribute instance first
            AttributeInstance attributeInstance = null;
            if (attributeArg.equalsIgnoreCase("SCALE")) {
                attributeInstance = player.getAttribute(Attribute.SCALE);

            } else if (attributeArg.equalsIgnoreCase("STEP_HEIGHT")) {
                attributeInstance = player.getAttribute(Attribute.STEP_HEIGHT);

            } else if (attributeArg.equalsIgnoreCase("BLOCK_INTERACTION_RANGE")) {
                attributeInstance = player.getAttribute(Attribute.BLOCK_INTERACTION_RANGE);

            } else if (attributeArg.equalsIgnoreCase("CAMERA_DISTANCE")) {
                attributeInstance = player.getAttribute(Attribute.CAMERA_DISTANCE);

            } else if (attributeArg.equalsIgnoreCase("ENTITY_INTERACTION_RANGE")) {
                attributeInstance = player.getAttribute(Attribute.ENTITY_INTERACTION_RANGE);

            } else if (attributeArg.equalsIgnoreCase("GRAVITY")) {
                attributeInstance = player.getAttribute(Attribute.GRAVITY);

            } else if (attributeArg.equalsIgnoreCase("JUMP_STRENGTH")) {
                attributeInstance = player.getAttribute(Attribute.JUMP_STRENGTH);

            } else if (attributeArg.equalsIgnoreCase("KNOCKBACK_RESISTANCE")) {
                attributeInstance = player.getAttribute(Attribute.KNOCKBACK_RESISTANCE);

            } else if (attributeArg.equalsIgnoreCase("MOVEMENT_EFFICIENCY")) {
                attributeInstance = player.getAttribute(Attribute.MOVEMENT_EFFICIENCY);

            } else if (attributeArg.equalsIgnoreCase("SNEAKING_SPEED")) {
                attributeInstance = player.getAttribute(Attribute.SNEAKING_SPEED);

            } else if (attributeArg.equalsIgnoreCase("WATER_MOVEMENT_EFFICIENCY")) {
                attributeInstance = player.getAttribute(Attribute.WATER_MOVEMENT_EFFICIENCY);

            } else if (attributeArg.equalsIgnoreCase("WAYPOINT_RECEIVE_RANGE")) {
                attributeInstance = player.getAttribute(Attribute.WAYPOINT_RECEIVE_RANGE);

            } else if (attributeArg.equalsIgnoreCase("WAYPOINT_TRANSMIT_RANGE")) {
                attributeInstance = player.getAttribute(Attribute.WAYPOINT_TRANSMIT_RANGE);

            } else {
                sendFeedback(sender, "Invalid attribute: " + attributeArg);
                return true;
            }

            if(args[1].equals("default")) {
                valueArg = attributeInstance.getDefaultValue();
            } else {
                valueArg = Double.parseDouble(args[1]);
            }

            attributeInstance.setBaseValue(valueArg);
            sendFeedback(sender, attributeArg + " set to " + valueArg);

            return true;
        } catch (NumberFormatException e1) {
            sendFeedback(sender, "Invalid attribute value: " + args[1]);
            return true;
        }
    }
}