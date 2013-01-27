package com.kreckin.herobrined.actions;

import com.kreckin.herobrined.api.IActionResult;
import com.kreckin.herobrined.impl.Action;
import com.kreckin.herobrined.impl.ActionResult;
import org.bukkit.entity.Player;

public class PlaceSign extends Action {

    @Override
    public IActionResult callAction(Player player, Object[] metadata) {
        return ActionResult.BASIC;
    }
}
