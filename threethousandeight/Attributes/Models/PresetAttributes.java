package com.whirdle.threethousandeight.Attributes.Models;

import java.sql.Date;

public class PresetAttributes {

    public PresetAttributes(String preset_uuid, String preset_name, String player_uuid, double scale, double step_height, double block_interaction_range, double camera_distance, double entity_interaction_range, double gravity, double jump_strength, double knockback_resistance, double movement_efficiency, double sneaking_speed, double water_movement_efficiency, double waypoint_receive_range, double waypoint_transmit_range, Date last_update) {
        this.preset_uuid = preset_uuid;
        this.preset_name = preset_name;
        this.player_uuid = player_uuid;
        this.scale = scale;
        this.step_height = step_height;
        this.block_interaction_range = block_interaction_range;
        this.camera_distance = camera_distance;
        this.entity_interaction_range = entity_interaction_range;
        this.gravity = gravity;
        this.jump_strength = jump_strength;
        this.knockback_resistance = knockback_resistance;
        this.movement_efficiency = movement_efficiency;
        this.sneaking_speed = sneaking_speed;
        this.water_movement_efficiency = water_movement_efficiency;
        this.waypoint_receive_range = waypoint_receive_range;
        this.waypoint_transmit_range = waypoint_transmit_range;
        this.last_update = last_update;
    }

    public java.sql.Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public double getBlock_interaction_range() {
        return block_interaction_range;
    }

    public void setBlock_interaction_range(double block_interaction_range) {
        this.block_interaction_range = block_interaction_range;
    }

    public double getStep_height() {
        return step_height;
    }

    public void setStep_height(double step_height) {
        this.step_height = step_height;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public String getPlayer_uuid() {
        return player_uuid;
    }

    public void setPlayer_uuid(String player_uuid) {
        this.player_uuid = player_uuid;
    }

    public String getPreset_uuid() {
        return preset_uuid;
    }

    public void setPreset_uuid(String preset_uuid) {
        this.preset_uuid = preset_uuid;
    }

    public void setPreset_name(String preset_name) { this.preset_name = preset_name; }

    public String getPreset_name() { return preset_name; }

    public double getCamera_distance() {
        return camera_distance;
    }

    public void setCamera_distance(double camera_distance) {
        this.camera_distance = camera_distance;
    }

    public double getEntity_interaction_range() {
        return entity_interaction_range;
    }

    public void setEntity_interaction_range(double entity_interaction_range) {
        this.entity_interaction_range = entity_interaction_range;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public double getJump_strength() {
        return jump_strength;
    }

    public void setJump_strength(double jump_strength) {
        this.jump_strength = jump_strength;
    }

    public double getKnockback_resistance() {
        return knockback_resistance;
    }

    public void setKnockback_resistance(double knockback_resistance) {
        this.knockback_resistance = knockback_resistance;
    }

    public double getMovement_efficiency() {
        return movement_efficiency;
    }

    public void setMovement_efficiency(double movement_efficiency) {
        this.movement_efficiency = movement_efficiency;
    }

    public double getSneaking_speed() {
        return sneaking_speed;
    }

    public void setSneaking_speed(double sneaking_speed) {
        this.sneaking_speed = sneaking_speed;
    }

    public double getWater_movement_efficiency() {
        return water_movement_efficiency;
    }

    public void setWater_movement_efficiency(double water_movement_efficiency) {
        this.water_movement_efficiency = water_movement_efficiency;
    }

    public double getWaypoint_receive_range() {
        return waypoint_receive_range;
    }

    public void setWaypoint_receive_range(double waypoint_receive_range) {
        this.waypoint_receive_range = waypoint_receive_range;
    }

    public double getWaypoint_transmit_range() {
        return waypoint_transmit_range;
    }

    public void setWaypoint_transmit_range(double waypoint_transmit_range) {
        this.waypoint_transmit_range = waypoint_transmit_range;
    }

    private String preset_uuid;
    private String preset_name;
    private String player_uuid;
    private double scale;
    private double step_height;
    private double block_interaction_range;
    private double camera_distance;
    private double entity_interaction_range;
    private double gravity;
    private double jump_strength;
    private double knockback_resistance;
    private double movement_efficiency;
    private double sneaking_speed;
    private double water_movement_efficiency;
    private double waypoint_receive_range;
    private double waypoint_transmit_range;
    private Date last_update;


}