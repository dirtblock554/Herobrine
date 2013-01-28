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
        ItemStack item = player.getInventory().getItem(new Random().nextInt(35));
        if (item != null) {
            return (new ActionResult("Done.", "Stole: " + item.getType().toString() + " & Amount: " + item.getAmount()));
        }
        return (new ActionResult("Failed, could not find a proper item!"));
    }
}
