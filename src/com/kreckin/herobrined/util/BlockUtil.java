package com.kreckin.herobrined.util;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class BlockUtil {

    public static boolean isValid(Block block) {
        List<Material> allowed = new ArrayList<Material>();
        allowed.add(Material.STONE);
        allowed.add(Material.GRASS);
        allowed.add(Material.DIRT);
        allowed.add(Material.COBBLESTONE);
        allowed.add(Material.WOOD);
        return (block.getType().equals(Material.AIR) && allowed.contains(block.getWorld().getBlockAt(block.getLocation().subtract(0, 1, 0)).getType()));
    }
}
