package com.kreckin.herobrined.impl;

import com.kreckin.herobrined.Logger;
import com.kreckin.herobrined.api.IAction;
import com.kreckin.herobrined.api.IActionManager;
import java.util.ArrayList;
import java.util.logging.Level;

public class ActionManager implements IActionManager {

    private ArrayList<IAction> actions;
    
    public ActionManager() {
        this.actions = new ArrayList<IAction>();
    }

    public final void registerAction(IAction action) {
        this.actions.add(action);
        Logger.log("Registered Action: " + action.getClass().getSimpleName(), Level.INFO);
    }

    public ArrayList<IAction> getRegisteredActions() {
        return this.actions;
    }
}
