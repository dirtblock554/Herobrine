package com.kreckin.herobrine.api;

import java.util.ArrayList;

public interface IActionManager {

    public void registerAction(IAction action);

    public ArrayList<IAction> getRegisteredActions();
}
