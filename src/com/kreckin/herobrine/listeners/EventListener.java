package com.kreckin.herobrine.listeners;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.IAction;
import com.kreckin.herobrine.impl.ActionType;
import com.kreckin.herobrine.util.Util;
import java.util.Random;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (Util.shouldAct(event.getPlayer())) {
            IAction action = Herobrine.getActionManager().getActions().get(new Random().nextInt(Herobrine.getActionManager().getActions().size() - 1));
            if (!action.getType().equals(ActionType.STANDARD)) {
                return;
            }
            action.checkAction(event.getPlayer(), null);
        }
    }
}
