package com.kreckin.herobrined.actions;

import com.kreckin.herobrined.api.IActionResult;
import com.kreckin.herobrined.impl.Action;
import com.kreckin.herobrined.impl.ActionResult;
import com.kreckin.herobrined.impl.ActionType;
import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PossessPlayer extends Action {
    
    public PossessPlayer() {
        super(ActionType.STANDARD);
    }

    @Override
    public IActionResult callAction(Player player, Object[] metadata) {
        int time = (new Random().nextInt(5) + 5) * 20;
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, time, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, time, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, time, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, time, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, time, 1));
        return (new ActionResult("Done."));
    }
}
