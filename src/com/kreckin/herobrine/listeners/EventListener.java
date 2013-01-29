package com.kreckin.herobrine.listeners;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.IAction;
import com.kreckin.herobrine.api.IActionResult;
import com.kreckin.herobrine.impl.ActionType;
import com.kreckin.herobrine.util.Util;
import java.util.Random;
import java.util.logging.Level;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (Util.shouldAct(event.getPlayer())) {
            IAction action = Herobrine.getActionManager().getRegisteredActions().get(new Random().nextInt(Herobrine.getActionManager().getRegisteredActions().size() - 1));
            if (!action.getType().equals(ActionType.STANDARD)) {
                return;
            }
            Herobrine.log("Running Action: " + action.getClass().getSimpleName() + " & Player: " + event.getPlayer().getName(), Level.INFO);
            IActionResult result = action.checkAction(event.getPlayer(), null);
            Herobrine.log(result.getMessage(), Level.INFO);
            if (result.getData() != null) {
                Herobrine.log("Details: " + result.getData(), Level.INFO);
            }
        }
    }
}
