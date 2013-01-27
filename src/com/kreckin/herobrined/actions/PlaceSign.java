package com.kreckin.herobrined.actions;

import com.kreckin.herobrined.api.IAction;
import com.kreckin.herobrined.api.IActionResult;
import com.kreckin.herobrined.impl.ActionResult;
import org.bukkit.entity.Player;

public class PlaceSign implements IAction {

    @Override
    public IActionResult callAction(Player player) {
        return ActionResult.BASIC;
    }
}
