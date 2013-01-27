package com.kreckin.herobrined.api;

import org.bukkit.entity.Player;

public interface IAction {

    public IActionResult callAction(Player player);
    
    public boolean callCommand(String[] command, Player player) throws Exception;
}
