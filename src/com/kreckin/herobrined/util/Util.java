package com.kreckin.herobrined.util;

import com.kreckin.herobrined.Herobrined;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Util {
    
    public static String getMessage(String path) {
        List<String> strings = Herobrined.getHerobrined().getYamlConfiguration().getStringList(path);
        if (strings.isEmpty()) {
            return null;
        }
        if (strings.size() == 1) {
            return strings.get(0);
        }
        return strings.get(new Random().nextInt(strings.size() - 1));
    }

    public static Location getNearbyLocation(Player player, int distance) {
        Random random = new Random();
        int addX = (random.nextBoolean() ? -random.nextInt(distance) : random.nextInt(distance));
        int addZ = (random.nextBoolean() ? -random.nextInt(distance) : random.nextInt(distance));
        return (player.getLocation().add(addX, 0, addZ));
    }
    
    public static boolean isValid(Block block) {
        List<Material> allowed = new ArrayList<Material>();
        allowed.add(Material.STONE);
        allowed.add(Material.GRASS);
        allowed.add(Material.DIRT);
        allowed.add(Material.COBBLESTONE);
        allowed.add(Material.WOOD);
        return (block.getType().equals(Material.AIR) && allowed.contains(block.getWorld().getBlockAt(block.getLocation().subtract(0, 1, 0)).getType()));
    }
    
    public static String formatString(String message) {
        return ("[" + ChatColor.RED + "Herobrined" + ChatColor.WHITE + "] " + message);
    }
}