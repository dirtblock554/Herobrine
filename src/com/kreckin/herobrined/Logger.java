package com.kreckin.herobrined;

import com.kreckin.herobrined.util.StringUtil;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Logger {

    public static void log(String message, Level level) {
        Bukkit.getLogger().log(level, ChatColor.stripColor(StringUtil.formatString(message)));
    }
}
