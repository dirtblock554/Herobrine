package com.kreckin.herobrined.listeners;

import com.kreckin.herobrined.Herobrined;
import com.kreckin.herobrined.Logger;
import com.kreckin.herobrined.api.IAction;
import com.kreckin.herobrined.api.IActionResult;
import com.kreckin.herobrined.util.Util;
import java.util.Random;
import java.util.logging.Level;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (Util.shouldAct(event.getPlayer())) {
            IAction action = Herobrined.getActionManager().getRegisteredActions().get(new Random().nextInt(Herobrined.getActionManager().getRegisteredActions().size() - 1));
            Logger.log("Running Action: " + action.getClass().getSimpleName() + " & Player: " + event.getPlayer().getName(), Level.INFO);
            IActionResult result = action.checkAction(event.getPlayer(), null);
            Logger.log(result.getMessage(), Level.INFO);
            if (result.getData() != null) {
                Logger.log("Details: " + result.getData(), Level.INFO);
            }
        }
    }
}
