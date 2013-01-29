package com.kreckin.herobrine.impl;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.IAction;
import com.kreckin.herobrine.api.IActionResult;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public abstract class Action implements IAction {

    private final ActionType type;
    
    public Action(ActionType type) {
        this.type = type;
    }
    
    @Override
    public IActionResult checkAction(Player player, Object[] metadata) {
        if (Herobrine.getConfigFile().getStringList("Herobrine.disallowedActions").contains(this.getClass().getSimpleName())) {
            return (new ActionResult("Sorry, that action has been disallowed in the configuration file!"));
        }
        if (Herobrine.getConfigFile().getStringList("Herobrine.disallowedWorlds").contains(player.getWorld().getName())) {
            return (new ActionResult("Sorry, that world has been disallowed in the configuration file!"));
        }
        if (!player.getGameMode().equals(GameMode.SURVIVAL) && Herobrine.getConfigFile().getBoolean("Herobrine.survivalOnly")) {
            return (new ActionResult("Sorry, the player must be in survival mode."));
        }
        return this.callAction(player, metadata);
    }
    
    @Override
    public ActionType getType() {
        return this.type;
    }
}
