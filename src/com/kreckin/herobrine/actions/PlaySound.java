package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.IActionResult;
import com.kreckin.herobrine.impl.Action;
import com.kreckin.herobrine.impl.ActionResult;
import com.kreckin.herobrine.impl.ActionType;
import java.util.ArrayList;
import java.util.Random;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class PlaySound extends Action {

    public PlaySound() {
        super(ActionType.STANDARD);
    }

    @Override
    public IActionResult callAction(Player player, Object[] metadata) {
        ArrayList<Sound> sounds = new ArrayList<Sound>();
        sounds.add(Sound.AMBIENCE_CAVE);
        sounds.add(Sound.AMBIENCE_RAIN);
        sounds.add(Sound.AMBIENCE_THUNDER);
        sounds.add(Sound.BREATH);
        sounds.add(Sound.CAT_HISS);
        sounds.add(Sound.CREEPER_HISS);
        sounds.add(Sound.BURP);
        sounds.add(Sound.DOOR_CLOSE);
        sounds.add(Sound.DOOR_OPEN);
        sounds.add(Sound.ENDERDRAGON_GROWL);
        sounds.add(Sound.GHAST_MOAN);
        sounds.add(Sound.GHAST_SCREAM);
        sounds.add(Sound.GHAST_SCREAM2);
        Sound sound = sounds.get(new Random().nextInt(sounds.size() - 1));
        player.playSound(player.getLocation(), Sound.BURP, 1F, 1F);
        return (new ActionResult("Done.", "Played: " + sound.toString()));
    }
}
