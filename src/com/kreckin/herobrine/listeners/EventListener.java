package com.kreckin.herobrine.listeners;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.actions.AltarSummon;
import com.kreckin.herobrine.api.IAction;
import com.kreckin.herobrine.impl.ActionType;
import com.kreckin.herobrine.util.Util;
import java.util.Random;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventListener implements Listener {
    
    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent event) {
        if (!event.getCause().equals(BlockIgniteEvent.IgniteCause.FLINT_AND_STEEL)) {
            return;
        }
        Block nether = event.getBlock().getLocation().subtract(0D, 1D, 0D).getBlock();
        Block moss = nether.getLocation().subtract(0D, 1D, 0D).getBlock();
        if (nether.getType().equals(Material.NETHERRACK) && moss.getType().equals(Material.MOSSY_COBBLESTONE)) {
            new AltarSummon().checkAction(event.getPlayer(), new Object[] { nether });
        }
    }

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
