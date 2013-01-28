package com.kreckin.herobrined.util;

import java.util.Random;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PlayerUtil {

    public static Location getNearbyLocation(Player player, int distance) {
        Random random = new Random();
        int addX = (random.nextBoolean() ? -random.nextInt(distance) : random.nextInt(distance));
        int addZ = (random.nextBoolean() ? -random.nextInt(distance) : random.nextInt(distance));
        return (player.getLocation().add(addX, 0, addZ));
    }
}
