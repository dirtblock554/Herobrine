package com.kreckin.herobrined.actions;

import com.kreckin.herobrined.api.IActionResult;
import com.kreckin.herobrined.impl.Action;
import com.kreckin.herobrined.impl.ActionResult;
import com.kreckin.herobrined.util.BlockUtil;
import com.kreckin.herobrined.util.PlayerUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class PlaceTorch extends Action {

    @Override
    public IActionResult callAction(Player player, Object[] metadata) {
        Block block = player.getWorld().getBlockAt(PlayerUtil.getNearbyLocation(player, 10));
        if (BlockUtil.isValid(block)) {
            block.setType(Material.REDSTONE_TORCH_ON);
            Location loc = block.getLocation();
            return (new ActionResult("Done.", "Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ()));
        } else {
            return (new ActionResult("Failed, could not find a proper location!"));
        }
    }
}
