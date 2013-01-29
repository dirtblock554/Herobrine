package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.IActionResult;
import com.kreckin.herobrine.impl.Action;
import com.kreckin.herobrine.impl.ActionResult;
import com.kreckin.herobrine.impl.ActionType;
import java.util.Random;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class BatAttack extends Action {

    public BatAttack() {
        super(ActionType.STANDARD);
    }

    @Override
    public IActionResult callAction(Player player, Object[] metadata) {
        int toSpawn = (new Random().nextInt(3)) + 3;
        for (int bat = 0; bat < toSpawn; bat++) {
            player.getWorld().spawnEntity(player.getLocation(), EntityType.BAT);
        }
        return (new ActionResult("Done.", "Spawned: " + toSpawn));
    }
}
