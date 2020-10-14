package de.vese.vese.commands;

import de.staticred.caa.commandapi.util.Command;
import de.staticred.caa.commandapi.util.CommandSender;
import de.staticred.caa.commandapi.util.ConsoleSender;

/*
    VESE - HelpCommand
    Version: 1.0.0
    Author: David
    Alias: Dawitschi
 */

public class HelpCommand extends Command {

    public HelpCommand(String prefix, String command, String description) {
        super(prefix, command, description);
    }

    @Override
    public void execute(String prefix, String command, CommandSender commandSender, String[] strings) {

        if(!(commandSender instanceof ConsoleSender)) {
            return;
        }

        System.out.println("Use ?command to see the description of a command.");
        System.out.println("For a list of all commands use 'listcommands'");
    }
}
