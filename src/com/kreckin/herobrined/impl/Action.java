package com.kreckin.herobrined.impl;

import com.kreckin.herobrined.Herobrined;
import com.kreckin.herobrined.api.IAction;
import com.kreckin.herobrined.api.IActionResult;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public abstract class Action implements IAction {

    private final ActionType type;
    
    public Action(ActionType type) {
        this.type = type;
    }
    
    @Override
    public IActionResult checkAction(Player player, Object[] metadata) {
        if (Herobrined.getConfigFile().getStringList("Herobrined.disallowedActions").contains(this.getClass().getSimpleName())) {
            return (new ActionResult("Sorry, that action has been disallowed in the configuration file!"));
        }
        if (Herobrined.getConfigFile().getStringList("Herobrined.disallowedWorlds").contains(player.getWorld().getName())) {
            return (new ActionResult("Sorry, that world has been disallowed in the configuration file!"));
        }
        if (!player.getGameMode().equals(GameMode.SURVIVAL) && Herobrined.getConfigFile().getBoolean("Herobrined.survivalOnly")) {
            return (new ActionResult("Sorry, the player must be in survival mode."));
        }
        return this.callAction(player, metadata);
    }
    
    @Override
    public ActionType getType() {
        return this.type;
    }
}
