package com.kreckin.herobrined;

import java.util.logging.Level;
import org.bukkit.Bukkit;

public class Logger {

    public static void log(String message, Level level) {
        Bukkit.getLogger().log(level, "[Herobrined] {0}", message);
    }
}
