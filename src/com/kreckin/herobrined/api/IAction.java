package com.kreckin.herobrined.api;

import org.bukkit.entity.Player;

public interface IAction {
    
    public IActionResult checkAction(Player player, Object[] metadata);

    public IActionResult callAction(Player player, Object[] metadata);
}
