package com.kreckin.herobrined.impl;

import com.kreckin.herobrined.Herobrined;
import com.kreckin.herobrined.actions.BuryPlayer;
import com.kreckin.herobrined.actions.CreateGrave;
import com.kreckin.herobrined.actions.CreateRingOfFire;
import com.kreckin.herobrined.actions.CreateTNTTrap;
import com.kreckin.herobrined.actions.DestroyTorches;
import com.kreckin.herobrined.actions.PlaceSign;
import com.kreckin.herobrined.actions.PlaceTorch;
import com.kreckin.herobrined.actions.StealItem;
import com.kreckin.herobrined.api.IAction;
import com.kreckin.herobrined.api.IActionManager;
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
    }

    public final void registerAction(IAction action) {
        this.actions.add(action);
        Herobrined.log("Registered Action: " + action.getClass().getSimpleName(), Level.INFO);
    }

    public ArrayList<IAction> getRegisteredActions() {
        return this.actions;
    }
}
