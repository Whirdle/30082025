package com.whirdle.threethousandeight.Attributes.db;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class DatabaseCredentialsConfig {
    private static File file;
    static FileConfiguration credentialsFile;

    public static void setup(JavaPlugin plugin){

        if (!plugin.getDataFolder().exists()){
            plugin.getDataFolder().mkdirs();
        }

        file = new File(plugin.getDataFolder(), "database.yml");

        if (!file.exists()){

            try {
                file.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        credentialsFile = YamlConfiguration.loadConfiguration(file);

        if (!(credentialsFile.contains("url") || credentialsFile.contains("username") || credentialsFile.contains("password"))) {
            credentialsFile.set("url", "jdbcStringHere");
            credentialsFile.set("username", "usernameHere");
            credentialsFile.set("password", "passwordHere");


            try {
                credentialsFile.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void reload(){
        credentialsFile = YamlConfiguration.loadConfiguration(file);
    }
}
