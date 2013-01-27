package com.kreckin.herobrined;

import com.kreckin.herobrined.actions.ActionPlaceSign;
import com.kreckin.herobrined.actions.ActionPlaceTorch;
import com.kreckin.herobrined.impl.ActionManager;
import java.util.logging.Level;
import org.bukkit.plugin.java.JavaPlugin;

public class Herobrined extends JavaPlugin {

    private static ActionManager actionManager;

    @Override
    public void onEnable() {
        Logger.log("Registering actions...", Level.INFO);
        Herobrined.actionManager = new ActionManager();
        Herobrined.actionManager.registerAction(new ActionPlaceTorch());
        Herobrined.actionManager.registerAction(new ActionPlaceSign());
        Logger.log("Done registering actions!", Level.INFO);
    }
    
    public static ActionManager getActionManager() {
        return Herobrined.actionManager;
    }
}
