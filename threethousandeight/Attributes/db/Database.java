package com.whirdle.threethousandeight.Attributes.db;

import com.whirdle.threethousandeight.Attributes.Models.PresetAttributes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.whirdle.threethousandeight.Attributes.db.DatabaseCredentialsConfig.credentialsFile;
import static org.bukkit.Bukkit.getServer;

public class Database {

    private Connection connection;

    public Connection getConnection() throws SQLException{

        if (connection != null){
            return connection;
        }

        String url = credentialsFile.getString("url");
        String user = credentialsFile.getString("username");
        String password = credentialsFile.getString("password");

        this.connection = DriverManager.getConnection(url, user, password);

        getServer().getLogger().info("Connected to presets database");

        return this.connection;

    }

    public void initializeDatabase() throws SQLException{

        Statement statement = getConnection().createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS preset_attributes(" +
                "preset_uuid varchar(36) primary key, " +
                "preset_name varchar(100), " +
                "player_uuid varchar(36), " +
                "last_updated DATE, " +
                "scale double, " +
                "step_height double, " +
                "block_interaction_range double, " +
                "camera_distance double, " +
                "entity_interaction_range double, " +
                "gravity double, " +
                "jump_strength double, " +
                "knockback_resistance double, " +
                "movement_efficiency double, " +
                "sneaking_speed double, " +
                "water_movement_efficiency double, " +
                "waypoint_receive_range double, " +
                "waypoint_transmit_range double" +
                ")";
        statement.execute(sql);
        statement.close();

    }
/*
                // unused, "vulnerable" method
    public PresetAttributes findPresetByUUID(String presetUUID) throws SQLException{
        Statement statement = getConnection().createStatement();
    String sql = "SELECT * FROM preset_attributes WHERE preset_uuid = " + presetUUID;
    statement.executeQuery(sql);
    ResultSet results = statement.executeQuery(sql);

    if (results.next()){

        String presetName = results.getString("preset_name");
        String playerUUID = results.getString("player_uuid");
        double scale = results.getDouble("scale");
        double stepHeight = results.getDouble("step_height");
        double blockInteractionRange = results.getDouble("block_interaction_range");
        Date lastUpdated = results.getDate("last_updated");



        PresetAttributes presetAttributes = new PresetAttributes(presetUUID, presetName, playerUUID, scale, stepHeight, blockInteractionRange, lastUpdated);

        statement.close();

        return presetAttributes;
    }
    statement.close();


    return null;

    }

 */


    public List<String> getAllPresetNamesByPlayerUUID(String playerUUID) throws SQLException {
        List<String> presetNames = new ArrayList<>();

        String sql = "SELECT preset_name FROM preset_attributes WHERE player_uuid = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setString(1, playerUUID);

        ResultSet results = statement.executeQuery();

        while (results.next()) {
            String presetName = results.getString("preset_name");
            presetNames.add(presetName);
        }

        results.close();
        statement.close();

        return presetNames;
    }

    public PresetAttributes findPresetByPlayerUUIDAndPresetName(String playerUUID, String presetName) throws SQLException {
        PreparedStatement statement = getConnection()
                .prepareStatement("SELECT * FROM preset_attributes WHERE player_uuid = ? AND preset_name = ?");

//        Statement statement = getConnection().createStatement();
//        String sql = "SELECT * FROM preset_attributes WHERE player_uuid = '" + playerUUID + "' AND preset_name = '" + presetName + "'";


        statement.setString(1, playerUUID);
        statement.setString(2, presetName);

        ResultSet results = statement.executeQuery();


        if (results.next()) {
            String foundPresetName = results.getString("preset_name");
            String presetUUID = results.getString("preset_uuid");
            double scale = results.getDouble("scale");
            double stepHeight = results.getDouble("step_height");
            double blockInteractionRange = results.getDouble("block_interaction_range");
            double cameraDistance = results.getDouble("camera_distance");
            double entityInteractionRange = results.getDouble("entity_interaction_range");
            double gravity = results.getDouble("gravity");
            double jumpStrength = results.getDouble("jump_strength");
            double knockbackResistance = results.getDouble("knockback_resistance");
            double movementEfficiency = results.getDouble("movement_efficiency");
            double sneakingSpeed = results.getDouble("sneaking_speed");
            double waterMovementEfficiency = results.getDouble("water_movement_efficiency");
            double waypointReceiveRange = results.getDouble("waypoint_receive_range");
            double waypointTransmitRange = results.getDouble("waypoint_transmit_range");
            Date lastUpdated = results.getDate("last_updated");

            PresetAttributes presetAttributes = new PresetAttributes(presetUUID, foundPresetName, playerUUID, scale, stepHeight, blockInteractionRange, cameraDistance, entityInteractionRange, gravity, jumpStrength, knockbackResistance, movementEfficiency, sneakingSpeed, waterMovementEfficiency, waypointReceiveRange, waypointTransmitRange, lastUpdated);

            statement.close();
            return presetAttributes;
        }

        statement.close();
        return null;
    }

    public void createPreset(PresetAttributes presetAttributes) throws SQLException{
        PreparedStatement statement = getConnection()
                .prepareStatement("INSERT INTO preset_attributes(preset_uuid, preset_name, player_uuid, scale, step_height, block_interaction_range, camera_distance, entity_interaction_range, gravity, jump_strength, knockback_resistance, movement_efficiency, sneaking_speed, water_movement_efficiency, waypoint_receive_range, waypoint_transmit_range, last_updated) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        statement.setString(1, presetAttributes.getPreset_uuid());
        statement.setString(2, presetAttributes.getPreset_name());
        statement.setString(3, presetAttributes.getPlayer_uuid());
        statement.setDouble(4, presetAttributes.getScale());
        statement.setDouble(5, presetAttributes.getStep_height());
        statement.setDouble(6, presetAttributes.getBlock_interaction_range());
        statement.setDouble(7, presetAttributes.getCamera_distance());
        statement.setDouble(8, presetAttributes.getEntity_interaction_range());
        statement.setDouble(9, presetAttributes.getGravity());
        statement.setDouble(10, presetAttributes.getJump_strength());
        statement.setDouble(11, presetAttributes.getKnockback_resistance());
        statement.setDouble(12, presetAttributes.getMovement_efficiency());
        statement.setDouble(13, presetAttributes.getSneaking_speed());
        statement.setDouble(14, presetAttributes.getWater_movement_efficiency());
        statement.setDouble(15, presetAttributes.getWaypoint_receive_range());
        statement.setDouble(16, presetAttributes.getWaypoint_transmit_range());
        statement.setDate(17, presetAttributes.getLast_update());

        statement.executeUpdate();

        statement.close();
    }






}