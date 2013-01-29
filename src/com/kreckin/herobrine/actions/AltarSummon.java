package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.IActionResult;
import com.kreckin.herobrine.impl.Action;
import com.kreckin.herobrine.impl.ActionResult;
import com.kreckin.herobrine.impl.ActionType;
import com.kreckin.herobrine.util.Util;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class AltarSummon extends Action {

    public AltarSummon() {
        super(ActionType.SPECIAL);
    }

    @Override
    public IActionResult callAction(Player player, Object[] metadata) {
        player.getWorld().createExplosion(((Block) metadata[0]).getLocation(), 3F);
        player.getWorld().setStorm(true);
        player.getWorld().setTime(14200);
        player.getWorld().strikeLightning(((Block) metadata[0]).getLocation());
        for (Entity entity : player.getNearbyEntities(30, 30, 30)) {
            if (entity instanceof Player) {
                ((Player) entity).sendMessage(Util.formatString(Util.getMessage("Herobrine.altarMessages")));
            }
        }
        return (new ActionResult("Done."));
    }
}
