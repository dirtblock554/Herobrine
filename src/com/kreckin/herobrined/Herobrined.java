package com.kreckin.herobrined;

import com.kreckin.herobrined.actions.PlaceSign;
import com.kreckin.herobrined.actions.PlaceTorch;
import com.kreckin.herobrined.impl.ActionManager;
import com.kreckin.herobrined.listeners.CommandListener;
import com.kreckin.herobrined.listeners.EventListener;
import java.io.File;
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
        Logger.log("Configuring the plugin, please wait!", Level.INFO);
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
            ex.printStackTrace();
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        Logger.log("Done configuring the plugin!", Level.INFO);
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
