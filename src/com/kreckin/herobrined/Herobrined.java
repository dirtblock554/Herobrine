package com.kreckin.herobrined;

import com.kreckin.herobrined.actions.PlaceSign;
import com.kreckin.herobrined.actions.PlaceTorch;
import com.kreckin.herobrined.impl.ActionManager;
import com.kreckin.herobrined.listeners.CommandListener;
import com.kreckin.herobrined.listeners.EventListener;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Herobrined extends JavaPlugin {

    private static Herobrined instance;
    private ActionManager actionManager;
    private YamlConfiguration config;

    @Override
    public void onEnable() {
        Herobrined.instance = this;
        this.actionManager = new ActionManager();
        this.actionManager.registerAction(new PlaceTorch());
        this.actionManager.registerAction(new PlaceSign());
        this.getCommand("hb").setExecutor(new CommandListener());
        this.getServer().getPluginManager().registerEvents(new EventListener(), this);
        try {
            if (!this.getDataFolder().exists()) {
                this.getDataFolder().mkdirs();
            }
            if (!new File(this.getDataFolder() + "/config.yml").exists()) {
                this.saveResource("config.yml", false);
            }
            this.config = YamlConfiguration.loadConfiguration(new File(this.getDataFolder() + "/config.yml"));
        } catch (Exception ex) {
            this.getLogger().severe("Failed to properly config the plugin!");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        List<String> disallowedWorlds = this.config.getStringList("Herobrined.disallowedWorlds");
        if (disallowedWorlds.isEmpty()) {
            Logger.log("Disallowed Worlds: None", Level.INFO);
        } else {
            Logger.log("Disallowed Worlds:", Level.INFO);
            for (String world : disallowedWorlds) {
                Logger.log("\t" + world, Level.INFO);
            }
        }
        List<String> disallowedActions = this.config.getStringList("Herobrined.disallowedActions");
        if (disallowedActions.isEmpty()) {
            Logger.log("Disallowed Actions: None", Level.INFO);
        } else {
            Logger.log("Disallowed Actions:", Level.INFO);
            for (String action : disallowedActions) {
                Logger.log("\t" + action, Level.INFO);
            }
        }
        Logger.log("Survival Only: " + this.config.getBoolean("Herobrined.survivalOnly"), Level.INFO);
    }
    
    public YamlConfiguration getYamlConfiguration() {
        return this.config;
    }
    
    public ActionManager getActionManager() {
        return this.actionManager;
    }
    
    public static Herobrined getHerobrined() {
        return Herobrined.instance;
    }
}
