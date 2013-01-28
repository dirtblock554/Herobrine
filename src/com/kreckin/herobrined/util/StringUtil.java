package com.kreckin.herobrined.util;

import org.bukkit.ChatColor;

public class StringUtil {

    public static String formatString(String message) {
        return ("[" + ChatColor.RED + "Herobrined" + ChatColor.WHITE + "] " + message);
    }
}
