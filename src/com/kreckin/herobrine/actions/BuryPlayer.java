package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.IActionResult;
import com.kreckin.herobrine.impl.Action;
import com.kreckin.herobrine.impl.ActionResult;
import com.kreckin.herobrine.impl.ActionType;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class BuryPlayer extends Action {
    
    public BuryPlayer() {
        super(ActionType.STANDARD);
    }

    @Override
    public IActionResult callAction(Player player, Object[] metadata) {
        final Block top = player.getLocation().subtract(0, 1, 0).getBlock();
        final Material type = top.getType();
        Block middle = player.getLocation().subtract(0, 2, 0).getBlock();
        Block bottom = player.getLocation().subtract(0, 3, 0).getBlock();
        if (Util.isSolid(top) && Util.isSolid(middle) && Util.isSolid(bottom)) {
            top.setType(Material.AIR);
            middle.setType(Material.AIR);
            bottom.setType(Material.AIR);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Herobrine.getInstance(), new Runnable() {
                
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
