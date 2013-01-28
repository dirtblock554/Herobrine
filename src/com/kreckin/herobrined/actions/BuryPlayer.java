package com.kreckin.herobrined.actions;

import com.kreckin.herobrined.Herobrined;
import com.kreckin.herobrined.api.IActionResult;
import com.kreckin.herobrined.impl.Action;
import com.kreckin.herobrined.impl.ActionResult;
import com.kreckin.herobrined.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class BuryPlayer extends Action {

    @Override
    public IActionResult callAction(Player player, Object[] metadata) {
        final Block top = player.getWorld().getBlockAt(player.getLocation().subtract(0, 1, 0));
        final Material type = top.getType();
        Block middle = player.getWorld().getBlockAt(player.getLocation().subtract(0, 2, 0));
        Block bottom = player.getWorld().getBlockAt(player.getLocation().subtract(0, 3, 0));
        if (Util.isSolid(top) && Util.isSolid(middle) && Util.isSolid(bottom)) {
            top.setType(Material.AIR);
            middle.setType(Material.AIR);
            bottom.setType(Material.AIR);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Herobrined.getInstance(), new Runnable() {
                
                @Override
                public void run() {
                    top.setType(type);
                }
            }, 60L);
            Location loc = top.getLocation();
            return (new ActionResult("Done.", "Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ()));
        }
        return (new ActionResult("Failed, could not find a proper location!"));
    }
}
