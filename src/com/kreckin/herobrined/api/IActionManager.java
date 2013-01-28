package com.kreckin.herobrined.api;

import java.util.ArrayList;

public interface IActionManager {

    public void registerAction(IAction action);

    public ArrayList<IAction> getRegisteredActions();
}
