package com.whirdle.threethousandeight;

import com.whirdle.threethousandeight.Attributes.AttributeCommandTabCompletion;
import com.whirdle.threethousandeight.Attributes.PresetAttributeCommandTabCompletion;
import com.whirdle.threethousandeight.Attributes.AttributePresetCommand;
import com.whirdle.threethousandeight.Attributes.db.Database;
import com.whirdle.threethousandeight.Attributes.db.DatabaseCredentialsConfig;
import com.whirdle.threethousandeight.Misc.Commands.ReloadCommand;
import com.whirdle.threethousandeight.Misc.Commands.TestCommand;
import com.whirdle.threethousandeight.Attributes.AttributeCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import javax.xml.crypto.Data;
import java.sql.SQLException;

public final class threethousandeight extends JavaPlugin implements Listener {



    private Database database;
    public Database getDatabase() {
        return database;
    }


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

        this.getCommand("attribute").setExecutor(new AttributeCommand());
        this.getCommand("attribute").setTabCompleter(new AttributeCommandTabCompletion());

        this.getCommand("presetattribute").setExecutor(new AttributePresetCommand(this));
        this.getCommand("presetattribute").setTabCompleter(new PresetAttributeCommandTabCompletion(this));

        this.getCommand("reloadattribute").setExecutor(new ReloadCommand());

        DatabaseCredentialsConfig.setup(this);

        this.database = new Database();
        try {
            database.initializeDatabase();
        }catch(SQLException e){
            e.printStackTrace();
        }

        getServer().getLogger().info("whirdle was here, plugin started, prepare to die");
    }
}