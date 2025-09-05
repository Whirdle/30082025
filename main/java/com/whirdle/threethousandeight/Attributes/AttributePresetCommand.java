package com.whirdle.threethousandeight.Attributes;

import com.whirdle.threethousandeight.Attributes.Models.PresetAttributes;

import com.whirdle.threethousandeight.threethousandeight;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import static com.whirdle.threethousandeight.Misc.MiscMethods.sendFeedback;


public class AttributePresetCommand implements CommandExecutor {

    private final threethousandeight plugin;

    public AttributePresetCommand(threethousandeight plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }

        String usageError = "usage: /presetattribute save|load|info <preset>";

        if(args.length < 2) {
            sendFeedback(sender, usageError);
            return true;
        }



        Player player = (Player) sender;

        String presetuuid = String.valueOf(UUID.randomUUID());
        String playeruuid = String.valueOf(player.getUniqueId());
        java.sql.Date date = java.sql.Date.valueOf(LocalDate.now());
        double scale = player.getAttribute(Attribute.SCALE).getBaseValue();
        double stepHeight = player.getAttribute(Attribute.STEP_HEIGHT).getBaseValue();
        double blockInteractionRange = player.getAttribute(Attribute.BLOCK_INTERACTION_RANGE).getBaseValue();
        double cameraDistance = player.getAttribute(Attribute.CAMERA_DISTANCE).getBaseValue();
        double entityInteractionRange = player.getAttribute(Attribute.ENTITY_INTERACTION_RANGE).getBaseValue();
        double gravity = player.getAttribute(Attribute.GRAVITY).getBaseValue();
        double jumpStrength = player.getAttribute(Attribute.JUMP_STRENGTH).getBaseValue();
        double knockbackResistance = player.getAttribute(Attribute.KNOCKBACK_RESISTANCE).getBaseValue();
        double movementEfficiency = player.getAttribute(Attribute.MOVEMENT_EFFICIENCY).getBaseValue();
        double sneakingSpeed = player.getAttribute(Attribute.SNEAKING_SPEED).getBaseValue();
        double waterMovementEfficiency = player.getAttribute(Attribute.WATER_MOVEMENT_EFFICIENCY).getBaseValue();
        double waypointReceiveRange = player.getAttribute(Attribute.WAYPOINT_RECEIVE_RANGE).getBaseValue();
        double waypointTransmitRange = player.getAttribute(Attribute.WAYPOINT_TRANSMIT_RANGE).getBaseValue();


        String option = args[0];
        String presetName = args[1];

        PresetAttributes preset;


        if(presetName.length() > 30) {
            sendFeedback(sender, "preset name too long. (" + presetName.length() + ">30)");
        }

        if(option.equals("save") || option.equals("s")) {
            try {
                preset = plugin.getDatabase().findPresetByPlayerUUIDAndPresetName(playeruuid, presetName);

                if (preset == null){
                    preset = new PresetAttributes(presetuuid, presetName, playeruuid, scale, stepHeight, blockInteractionRange, cameraDistance, entityInteractionRange, gravity, jumpStrength, knockbackResistance, movementEfficiency, sneakingSpeed, waterMovementEfficiency, waypointReceiveRange, waypointTransmitRange, date);
                }

                this.plugin.getDatabase().createPreset(preset);

                sendFeedback(sender,"Preset " + presetName + " saved.");
            } catch (SQLException e) {
                e.printStackTrace();
                sendFeedback(sender, "Error saving preset.");
            }

        } else if (option.equals("load") || option.equals("l")) {
            try {
                preset = plugin.getDatabase().findPresetByPlayerUUIDAndPresetName(playeruuid, presetName);

                double presetScale = preset.getScale();
                double presetStepHeight = preset.getStep_height();
                double presetBlockInteractionRange = preset.getBlock_interaction_range();
                double presetCameraDistance = preset.getCamera_distance();
                double presetEntityInteractionRange = preset.getEntity_interaction_range();
                double presetGravity = preset.getGravity();
                double presetJumpStrength = preset.getJump_strength();
                double presetKnockbackResistance = preset.getKnockback_resistance();
                double presetMovementEfficiency = preset.getMovement_efficiency();
                double presetSneakingSpeed = preset.getSneaking_speed();
                double presetWaterMovementEfficiency = preset.getWater_movement_efficiency();
                double presetWaypointReceiveRange = preset.getWaypoint_receive_range();
                double presetWaypointTransmitRange = preset.getWaypoint_transmit_range();

                player.getAttribute(Attribute.SCALE).setBaseValue(presetScale);
                player.getAttribute(Attribute.STEP_HEIGHT).setBaseValue(presetStepHeight);
                player.getAttribute(Attribute.BLOCK_INTERACTION_RANGE).setBaseValue(presetBlockInteractionRange);
                player.getAttribute(Attribute.CAMERA_DISTANCE).setBaseValue(presetCameraDistance);
                player.getAttribute(Attribute.ENTITY_INTERACTION_RANGE).setBaseValue(presetEntityInteractionRange);
                player.getAttribute(Attribute.GRAVITY).setBaseValue(presetGravity);
                player.getAttribute(Attribute.JUMP_STRENGTH).setBaseValue(presetJumpStrength);
                player.getAttribute(Attribute.KNOCKBACK_RESISTANCE).setBaseValue(presetKnockbackResistance);
                player.getAttribute(Attribute.MOVEMENT_EFFICIENCY).setBaseValue(presetMovementEfficiency);
                player.getAttribute(Attribute.SNEAKING_SPEED).setBaseValue(presetSneakingSpeed);
                player.getAttribute(Attribute.WATER_MOVEMENT_EFFICIENCY).setBaseValue(presetWaterMovementEfficiency);
                player.getAttribute(Attribute.WAYPOINT_RECEIVE_RANGE).setBaseValue(presetWaypointReceiveRange);
                player.getAttribute(Attribute.WAYPOINT_TRANSMIT_RANGE).setBaseValue(presetWaypointTransmitRange);

                sendFeedback(sender, "Preset " + presetName + " loaded.");

            } catch (SQLException e) {
                e.printStackTrace();
                sendFeedback(sender, "Error loading preset.");
            } catch (NullPointerException e) {
                sendFeedback(sender, "preset not found: " + presetName);
            }
        } else if (option.equals("info") || option.equals("i")) {
            try {
                preset = plugin.getDatabase().findPresetByPlayerUUIDAndPresetName(playeruuid, presetName);

                UUID playerUUID = UUID.fromString(preset.getPlayer_uuid());

                OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(playerUUID);

                String playerName = offlinePlayer.getName();
                if (playerName == null) {
                    playerName = "Unknown Player";
                }

                double presetScale = preset.getScale();
                double presetStepHeight = preset.getStep_height();
                double presetBlockInteractionRange = preset.getBlock_interaction_range();
                double presetCameraDistance = preset.getCamera_distance();
                double presetEntityInteractionRange = preset.getEntity_interaction_range();
                double presetGravity = preset.getGravity();
                double presetJumpStrength = preset.getJump_strength();
                double presetKnockbackResistance = preset.getKnockback_resistance();
                double presetMovementEfficiency = preset.getMovement_efficiency();
                double presetSneakingSpeed = preset.getSneaking_speed();
                double presetWaterMovementEfficiency = preset.getWater_movement_efficiency();
                double presetWaypointReceiveRange = preset.getWaypoint_receive_range();
                double presetWaypointTransmitRange = preset.getWaypoint_transmit_range();

                StringBuilder message = new StringBuilder();
                message.append("&7---- &6Attribute Preset Info &7----\n");
                message.append("&7Preset Name: ").append(preset.getPreset_name()).append("\n");
                message.append("&7Player Name: ").append(playerName).append("\n");
                message.append("&7Preset UUID: ").append(preset.getPreset_uuid()).append("\n");
                message.append("Last updated: ").append(preset.getLast_update()).append("\n");
                message.append("&7--- &6Attributes &7---\n");
                message.append("&7Scale: ").append(presetScale).append("\n");
                message.append("&7Step Height: ").append(presetStepHeight).append("\n");
                message.append("&7Block Interaction Range: ").append(presetBlockInteractionRange).append("\n");
                message.append("&7Camera Distance: ").append(presetCameraDistance).append("\n");
                message.append("&7Entity Interaction Range: ").append(presetEntityInteractionRange).append("\n");
                message.append("&7Gravity: ").append(presetGravity).append("\n");
                message.append("&7Jump Strength: ").append(presetJumpStrength).append("\n");
                message.append("&7Knockback Resistance: ").append(presetKnockbackResistance).append("\n");
                message.append("&7Movement Efficiency: ").append(presetMovementEfficiency).append("\n");
                message.append("&7Sneaking Speed: ").append(presetSneakingSpeed).append("\n");
                message.append("&7Water Movement Efficiency: ").append(presetWaterMovementEfficiency).append("\n");
                message.append("&7Waypoint Receive Range: ").append(presetWaypointReceiveRange).append("\n");
                message.append("&7Waypoint Transmit Range: ").append(presetWaypointTransmitRange);

                sendFeedback(sender, message.toString(), false);



            } catch (SQLException e) {
                e.printStackTrace();
                sendFeedback(sender, "Error fetching preset.");
            } catch (NullPointerException e) {
                sendFeedback(sender, "preset not found: " + presetName);
            }
        } else {
            sendFeedback(sender, usageError);
        }
        return true;
    }
}