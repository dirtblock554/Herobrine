package com.kreckin.herobrined.impl;

import com.kreckin.herobrined.Herobrined;
import com.kreckin.herobrined.api.IAction;
import com.kreckin.herobrined.api.IActionResult;
import org.bukkit.entity.Player;

public abstract class Action implements IAction {

    @Override
    public IActionResult checkAction(Player player, Object[] metadata) {
        if (Herobrined.getHerobrined().getYamlConfiguration().getStringList("Herobrined.disallowedActions").contains(this.getClass().getSimpleName())) {
            return (new ActionResult("Sorry, that action has been disallowed in the configuration file!"));
        }
        if (Herobrined.getHerobrined().getYamlConfiguration().getStringList("Herobrined.disallowedWorlds").contains(player.getWorld().getName())) {
            return (new ActionResult("Sorry, that world has been disallowed in the configuration file!"));
        }
        return this.callAction(player, metadata);
    }
}
