package com.kreckin.herobrined.listeners;

import com.kreckin.herobrined.Herobrined;
import com.kreckin.herobrined.api.IAction;
import com.kreckin.herobrined.api.IActionResult;
import com.kreckin.herobrined.util.Util;
import java.util.Random;
import java.util.logging.Level;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventListener implements Listener {
    
    private int sinceCheck;
    
    public EventListener() {
        this.sinceCheck = 0;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        this.sinceCheck++;
        if (this.sinceCheck < 100) {
            return;
        }
        this.sinceCheck = 0;
        if (Util.shouldAct(event.getPlayer())) {
            IAction action = Herobrined.getActionManager().getRegisteredActions().get(new Random().nextInt(Herobrined.getActionManager().getRegisteredActions().size() - 1));
            Herobrined.log("Running Action: " + action.getClass().getSimpleName() + " & Player: " + event.getPlayer().getName(), Level.INFO);
            IActionResult result = action.checkAction(event.getPlayer(), null);
            Herobrined.log(result.getMessage(), Level.INFO);
            if (result.getData() != null) {
                Herobrined.log("Details: " + result.getData(), Level.INFO);
            }
        }
    }
}
