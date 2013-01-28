package com.kreckin.herobrined.api;

import com.kreckin.herobrined.impl.ActionType;
import org.bukkit.entity.Player;

public interface IAction {
    
    public IActionResult checkAction(Player player, Object[] metadata);

    public IActionResult callAction(Player player, Object[] metadata);
    
    public ActionType getType();
}
