package com.kreckin.herobrined;

import com.kreckin.herobrined.impl.ActionManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Herobrined extends JavaPlugin {
    
    private static ActionManager actionManager;

    @Override
    public void onEnable() {
        Herobrined.actionManager = new ActionManager();
    }
    
    public static ActionManager getActionManager() {
        return Herobrined.actionManager;
    }
}
