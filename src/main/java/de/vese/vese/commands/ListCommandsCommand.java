package de.vese.vese.commands;

import de.staticred.caa.commandapi.util.Command;
import de.staticred.caa.commandapi.util.CommandSender;
import de.staticred.caa.commandapi.util.ConsoleSender;
import de.vese.vese.VESE;
import de.vese.vese.logger.ConsoleColors;

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
        for(Command registeredCommand : VESE.getInstance().getCaa().commandHandler.getRegisteredCommands()) {
            System.out.println(ConsoleColors.BLACK_BRIGHT + "- " + ConsoleColors.YELLOW_BRIGHT + registeredCommand.getPrefix() + registeredCommand.getCommand());
        }
    }
}
