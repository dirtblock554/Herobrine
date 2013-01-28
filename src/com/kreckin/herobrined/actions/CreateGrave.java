package com.kreckin.herobrined.actions;

import com.kreckin.herobrined.api.IActionResult;
import com.kreckin.herobrined.impl.Action;
import com.kreckin.herobrined.impl.ActionResult;
import com.kreckin.herobrined.impl.ActionType;
import com.kreckin.herobrined.util.Util;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public class CreateGrave extends Action {
    
    public CreateGrave() {
        super(ActionType.STANDARD);
    }

    @Override
    public IActionResult callAction(Player player, Object[] metadata) {
        Block sign = Util.getNearbyLocation(player, 5).getBlock();
        Block stone1 = sign.getLocation().add(0, -1, 1).getBlock();
        Block stone2 = sign.getLocation().add(0, -1, 2).getBlock();
        Block stone3 = sign.getLocation().add(0, -1, 0).getBlock();
        if (Util.isValid(sign) && Util.isSolid(stone1) && Util.isSolid(stone2) && Util.isSolid(stone3)) {
            sign.setType(Material.SIGN_POST);
            stone1.setType(new Random().nextBoolean() ? Material.COBBLESTONE : Material.MOSSY_COBBLESTONE);
            stone2.setType(new Random().nextBoolean() ? Material.COBBLESTONE : Material.MOSSY_COBBLESTONE);
            stone3.setType(new Random().nextBoolean() ? Material.COBBLESTONE : Material.MOSSY_COBBLESTONE);
            Sign signIn = (Sign) sign.getState();
            signIn.setLine(1, player.getName());
            signIn.update();
            Location loc = sign.getLocation();
            return (new ActionResult("Done.", "Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ()));
        }
        return (new ActionResult("Failed, could not find a proper location!"));
    }
}
