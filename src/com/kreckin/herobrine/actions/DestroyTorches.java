package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.IActionResult;
import com.kreckin.herobrine.impl.Action;
import com.kreckin.herobrine.impl.ActionResult;
import com.kreckin.herobrine.impl.ActionType;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DestroyTorches extends Action {

    public DestroyTorches() {
        super(ActionType.STANDARD);
    }
    
    @Override
    public IActionResult callAction(Player player, Object[] metadata) {
        int torchTotal = 0;
        for (int x = -5; x < 5; x++) {
            for (int z = -5; z < 5; z++) {
                for (int y = -5; y < 5; y++) {
                    Block block = player.getWorld().getBlockAt(x, y, z);
                    if (block.getType().equals(Material.TORCH)) {
                        block.setType(Material.AIR);
                        block.getWorld().dropItem(block.getLocation(), new ItemStack(Material.TORCH));
                        torchTotal++;
                    }
                }
            }
        }
        return (new ActionResult("Done.", "Destroyed " + torchTotal + " torches."));
    }
}
