package com.kreckin.herobrined.actions;

import com.kreckin.herobrined.api.IActionResult;
import com.kreckin.herobrined.impl.Action;
import com.kreckin.herobrined.impl.ActionResult;
import com.kreckin.herobrined.util.Util;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public class PlaceSign extends Action {

    @Override
    public IActionResult callAction(Player player, Object[] metadata) {
        Block block = player.getWorld().getBlockAt(Util.getNearbyLocation(player, 5));
        if (Util.isValid(block)) {
            String message = Util.getMessage("Herobrined.signMessages");
            if (message == null) {
                return (new ActionResult("Failed, there are no sign messages in the configuration file!"));
            }
            block.setType(Material.SIGN_POST);
            Sign sign = (Sign) block.getState();
            sign.setLine(1, message);
            sign.update();
            Location loc = block.getLocation();
            return (new ActionResult("Done.", "Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ()));
        } else {
            return (new ActionResult("Failed, could not find a proper location!"));
        }
    }
}
