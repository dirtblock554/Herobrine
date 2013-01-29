package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.IActionResult;
import com.kreckin.herobrine.impl.Action;
import com.kreckin.herobrine.impl.ActionResult;
import com.kreckin.herobrine.impl.ActionType;
import java.util.ArrayList;
import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class StealItem extends Action {
    
    public StealItem() {
        super(ActionType.STANDARD);
    }

    @Override
    public IActionResult callAction(Player player, Object[] metadata) {
        ArrayList<Integer> slots = new ArrayList<Integer>();
        for (int index = 0; index < 35; index++) {
            if (player.getInventory().getItem(index) != null) {
                slots.add(index);
            }
        }
        if (slots.isEmpty()) {
            return (new ActionResult("Failed, could not find a proper item!"));
        }
        ItemStack item = player.getInventory().getItem(slots.get(0));
        if (slots.size() > 1) {
            item = player.getInventory().getItem(new Random().nextInt(slots.size() - 1));
        }
        if (item != null) {
            player.getInventory().remove(item);
            player.updateInventory();
            return (new ActionResult("Done.", "Stole: " + item.getType().toString() + " & Amount: " + item.getAmount()));
        }
        return (new ActionResult("Failed, could not find a proper item!"));
    }
}
