package com.kreckin.herobrined.actions;

import com.kreckin.herobrined.api.IActionResult;
import com.kreckin.herobrined.impl.Action;
import com.kreckin.herobrined.impl.ActionResult;
import com.kreckin.herobrined.impl.ActionType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RearrangeInventory extends Action {
    
    public RearrangeInventory() {
        super(ActionType.STANDARD);
    }

    @Override
    public IActionResult callAction(Player player, Object[] metadata) {
        List<ItemStack> items = Arrays.asList(player.getInventory().getContents());
        Collections.shuffle(items);
        player.getInventory().clear();
        for (ItemStack item : items) {
            player.getInventory().addItem(item);
        }
        return (new ActionResult("Done."));
    }
}
