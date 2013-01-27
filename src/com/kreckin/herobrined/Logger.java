package com.kreckin.herobrined;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Logger {

    public static java.util.logging.Logger getLogger() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("Herobrined");
        if (plugin == null) {
            return Bukkit.getLogger();
        }
        return plugin.getLogger();
    }
}
