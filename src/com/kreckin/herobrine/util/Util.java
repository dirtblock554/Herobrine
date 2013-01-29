package com.kreckin.herobrine.util;

import com.kreckin.herobrine.Herobrine;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Util {
    
    public static boolean shouldAct(Player player) {
        int actionChance = Herobrine.getConfigFile().getInt("Herobrine.actionChance");
        if (player.getWorld().getTime() >= 13000 && player.getWorld().getTime() <= 14200) {
            actionChance /= 4;
        }
        if (player.getNearbyEntities(10, 10, 10).size() <= 3) {
            actionChance /= 4;
        }
        return (new Random().nextInt(actionChance) == 0);
    }
    
    public static String getMessage(String path) {
        List<String> strings = Herobrine.getConfigFile().getStringList(path);
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
        return ((block.getType().equals(Material.AIR) || block.getType().equals(Material.LONG_GRASS)) && Util.isSolid(block.getWorld().getBlockAt(block.getLocation().subtract(0, 1, 0))));
    }
    
    public static boolean isSolid(Block block) {
        List<Material> allowed = new ArrayList<Material>();
        allowed.add(Material.STONE);
        allowed.add(Material.GRASS);
        allowed.add(Material.DIRT);
        allowed.add(Material.COBBLESTONE);
        allowed.add(Material.WOOD);
        return allowed.contains(block.getType());
    }
    
    public static String formatString(String message) {
        return ("[" + ChatColor.RED + "Herobrine" + ChatColor.WHITE + "] " + message);
    }
}
