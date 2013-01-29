package com.kreckin.herobrine.impl;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.actions.BatAttack;
import com.kreckin.herobrine.actions.BuryPlayer;
import com.kreckin.herobrine.actions.CreateGrave;
import com.kreckin.herobrine.actions.CreatePyramid;
import com.kreckin.herobrine.actions.CreateRingOfFire;
import com.kreckin.herobrine.actions.CreateTNTTrap;
import com.kreckin.herobrine.actions.DestroyTorches;
import com.kreckin.herobrine.actions.PlaceSign;
import com.kreckin.herobrine.actions.PlaceTorch;
import com.kreckin.herobrine.actions.PlaySound;
import com.kreckin.herobrine.actions.PossessPlayer;
import com.kreckin.herobrine.actions.RearrangeInventory;
import com.kreckin.herobrine.actions.StealItem;
import com.kreckin.herobrine.actions.WolfAttack;
import com.kreckin.herobrine.api.IAction;
import com.kreckin.herobrine.api.IActionManager;
import java.util.ArrayList;
import java.util.logging.Level;

public class ActionManager implements IActionManager {

    private final ArrayList<IAction> actions;
    
    public ActionManager() {
        this.actions = new ArrayList<IAction>();
        this.registerAction(new PlaceTorch());
        this.registerAction(new PlaceSign());
        this.registerAction(new DestroyTorches());
        this.registerAction(new CreateRingOfFire());
        this.registerAction(new BuryPlayer());
        this.registerAction(new CreateGrave());
        this.registerAction(new CreateTNTTrap());
        this.registerAction(new StealItem());
        this.registerAction(new RearrangeInventory());
        this.registerAction(new PossessPlayer());
        this.registerAction(new WolfAttack());
        this.registerAction(new BatAttack());
        this.registerAction(new CreatePyramid());
        this.registerAction(new PlaySound());
    }

    public final void registerAction(IAction action) {
        this.actions.add(action);
        Herobrine.log("Registered Action: " + action.getClass().getSimpleName(), Level.INFO);
    }

    public ArrayList<IAction> getActions() {
        return this.actions;
    }
}
