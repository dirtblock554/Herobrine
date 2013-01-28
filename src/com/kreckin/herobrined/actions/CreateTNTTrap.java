package com.kreckin.herobrined.actions;

import com.kreckin.herobrined.api.IActionResult;
import com.kreckin.herobrined.impl.Action;
import com.kreckin.herobrined.impl.ActionResult;
import com.kreckin.herobrined.util.Util;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class CreateTNTTrap extends Action {

    @Override
    public IActionResult callAction(Player player, Object[] metadata) {
        Block plate = Util.getNearbyLocation(player, 5).getBlock();
        Block ground = plate.getLocation().subtract(0, 1, 0).getBlock();
        Block tnt = ground.getLocation().subtract(0, 1, 0).getBlock();
        if (Util.isValid(plate) && Util.isSolid(ground) && Util.isSolid(tnt)) {
            plate.setTypeId(new Random().nextBoolean() ? 70 : 72);
            tnt.setType(Material.TNT);
            Location loc = plate.getLocation();
            return (new ActionResult("Done.", "Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ()));
        }
        return (new ActionResult("Failed, could not find a proper location!"));
    }
}
