package com.kreckin.herobrine.api;

import com.kreckin.herobrine.impl.ActionType;
import org.bukkit.entity.Player;

public interface IAction {
    
    public IActionResult checkAction(Player player, Object[] metadata);

    public IActionResult callAction(Player player, Object[] metadata);
    
    public ActionType getType();
}
