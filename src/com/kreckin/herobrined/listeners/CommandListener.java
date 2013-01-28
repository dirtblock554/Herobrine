package com.kreckin.herobrined.listeners;

import com.kreckin.herobrined.Herobrined;
import com.kreckin.herobrined.Logger;
import com.kreckin.herobrined.api.IAction;
import com.kreckin.herobrined.api.IActionResult;
import com.kreckin.herobrined.util.StringUtil;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandListener implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if (!(cs instanceof Player)) {
            Logger.log("You can only use these commands if you are a player!", Level.WARNING);
            return true;
        }
        if (!cs.hasPermission("herobrine.commands") && !cs.isOp()) {
            cs.sendMessage(StringUtil.formatString("Sorry, you do not have permission to do this!"));
        }
        if (strings.length == 1 && strings[0].equalsIgnoreCase("help")) {
            String knownActions = "Known actions: ";
            for (IAction action : Herobrined.getHerobrined().getActionManager().getRegisteredActions()) {
                knownActions += action.getClass().getSimpleName() + ", ";
            }
            knownActions = knownActions.substring(0, knownActions.length() - 2);
            cs.sendMessage(StringUtil.formatString(knownActions));
            return true;
        }
        if (strings.length == 2) {
            IAction foundAction = null;
            for (IAction action : Herobrined.getHerobrined().getActionManager().getRegisteredActions()) {
                if (action.getClass().getSimpleName().equalsIgnoreCase(strings[0])) {
                    foundAction = action;
                    break;
                }
            }
            if (foundAction != null) {
                Player player = Bukkit.getPlayer(strings[1]);
                if (player == null) {
                    cs.sendMessage(StringUtil.formatString("Unknown player!"));
                } else {
                    IActionResult result = foundAction.checkAction(player, null);
                    cs.sendMessage(StringUtil.formatString(result.getMessage()));
                    if (result.getData() != null) {
                        cs.sendMessage(StringUtil.formatString("Details: " + result.getData()));
                    }
                }
            } else {
                cs.sendMessage(StringUtil.formatString("Unknown action! Type \"/hb help\" for all actions!"));
            }
        } else {
            cs.sendMessage(StringUtil.formatString("Run an action with \"/hb action username\", or type \"/hb help\" for all actions!"));
        }
        return true;
    }
}
