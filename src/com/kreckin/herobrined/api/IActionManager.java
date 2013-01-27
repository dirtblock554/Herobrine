package com.kreckin.herobrined.api;

public interface IActionManager {

    public void registerAction(IAction action);

    public IAction[] getRegisteredActions();
}
