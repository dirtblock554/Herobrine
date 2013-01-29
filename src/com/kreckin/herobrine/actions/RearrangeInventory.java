package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.IActionResult;
import com.kreckin.herobrine.impl.Action;
import com.kreckin.herobrine.impl.ActionResult;
import com.kreckin.herobrine.impl.ActionType;
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
            if (item != null) {
                player.getInventory().addItem(item);
            }
        }
        return (new ActionResult("Done."));
    }
}
