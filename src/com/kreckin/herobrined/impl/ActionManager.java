package com.kreckin.herobrined.impl;

import com.kreckin.herobrined.Logger;
import com.kreckin.herobrined.api.IAction;
import com.kreckin.herobrined.api.IActionManager;

public class ActionManager implements IActionManager {

    private IAction[] actions;
    
    public ActionManager() {
        this.actions = new IAction[0];
    }

    public void registerAction(IAction action) {
        IAction[] newActions = new IAction[this.actions.length + 1];
        System.arraycopy(this.actions, 0, newActions, 0, this.actions.length);
        newActions[this.actions.length] = action;
        this.actions = newActions;
        Logger.getLogger().info("Registered action: " + action.getClass().getSimpleName() + " & Index: " + this.actions.length);
    }

    public IAction[] getRegisteredActions() {
        return this.actions;
    }
}
