package de.vese.vese.commands;

import de.staticred.caa.commandapi.util.Command;
import de.staticred.caa.commandapi.util.CommandSender;
import de.staticred.caa.commandapi.util.ConsoleSender;
import de.vese.vese.VESE;

import javax.sound.midi.SysexMessage;

/*
    VESE - ListCommands
    Version: 1.0.0
    Author: David
    Alias: Dawitschi
 */
public class ListCommandsCommand extends Command {

    public ListCommandsCommand(String prefix, String command, String description) {
        super(prefix, command, description);
    }

    @Override
    public void execute(String prefix, String command, CommandSender commandSender, String[] strings) {

        if(!(commandSender instanceof ConsoleSender)) {
            return;
        }
        System.out.println("Here's a list of all commands:");
        for(Command registeredCommand : VESE.getInstance().getCaa().commandHandler.getRegisteredCommands()) {
            System.out.println("- " + registeredCommand.getPrefix() + registeredCommand.getCommand());
        }
    }
}
