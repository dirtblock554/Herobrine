package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.IActionResult;
import com.kreckin.herobrine.impl.Action;
import com.kreckin.herobrine.impl.ActionResult;
import com.kreckin.herobrine.impl.ActionType;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public class PlaceSign extends Action {

    public PlaceSign() {
        super(ActionType.STANDARD);
    }
    
    @Override
    public IActionResult callAction(Player player, Object[] metadata) {
        Block block = Util.getNearbyLocation(player, 5).getBlock();
        if (Util.isValid(block)) {
            String message = Util.getMessage("Herobrine.signMessages");
            if (message == null) {
                return (new ActionResult("Failed, there are no sign messages in the configuration file!"));
            }
            block.setType(Material.SIGN_POST);
            Sign sign = (Sign) block.getState();
            sign.setLine(1, message);
            sign.update();
            Location loc = block.getLocation();
            return (new ActionResult("Done.", "Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ() + " & Message: \"" + message + "\""));
        }
        return (new ActionResult("Failed, could not find a proper location!"));
    }
}
