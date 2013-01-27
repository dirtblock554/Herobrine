package com.kreckin.herobrined;

import com.kreckin.herobrined.actions.PlaceSign;
import com.kreckin.herobrined.actions.PlaceTorch;
import com.kreckin.herobrined.impl.ActionManager;
import java.util.logging.Level;
import org.bukkit.plugin.java.JavaPlugin;

public class Herobrined extends JavaPlugin {

    private static ActionManager actionManager;

    @Override
    public void onEnable() {
        Logger.log("Registering actions...", Level.INFO);
        Herobrined.actionManager = new ActionManager();
        Herobrined.actionManager.registerAction(new PlaceTorch());
        Herobrined.actionManager.registerAction(new PlaceSign());
        Logger.log("Done registering actions!", Level.INFO);
        Logger.log("Registering commands...", Level.INFO);
        this.getCommand("hb").setExecutor(new CommandListener());
        Logger.log("Done registering commands!", Level.INFO);
    }
    
    public static ActionManager getActionManager() {
        return Herobrined.actionManager;
    }
}
