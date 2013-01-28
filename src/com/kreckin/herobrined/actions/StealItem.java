package com.kreckin.herobrined.actions;

import com.kreckin.herobrined.api.IActionResult;
import com.kreckin.herobrined.impl.Action;
import com.kreckin.herobrined.impl.ActionResult;
import com.kreckin.herobrined.impl.ActionType;
import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class StealItem extends Action {
    
    public StealItem() {
        super(ActionType.STANDARD);
    }

    @Override
    public IActionResult callAction(Player player, Object[] metadata) {
        int size = 0;
        for (ItemStack item : player.getInventory().getContents()) {
            if (item != null) {
                size++;
            }
        }
        if (size <= 0) {
            size = 1;
        }
        ItemStack item = player.getInventory().getItem(new Random().nextInt(size));
        if (item != null) {
            return (new ActionResult("Done.", "Stole: " + item.getType().toString() + " & Amount: " + item.getAmount()));
        }
        return (new ActionResult("Failed, could not find a proper item!"));
    }
}
