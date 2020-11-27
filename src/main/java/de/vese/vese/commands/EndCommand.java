package de.vese.vese.commands;

import de.staticred.caa.commandapi.util.Command;
import de.staticred.caa.commandapi.util.CommandSender;
import de.staticred.caa.commandapi.util.ConsoleSender;
import de.vese.vese.VESE;
import de.vese.vese.logger.ConsoleColors;

public class EndCommand extends Command {

    public EndCommand(String prefix, String command, String description) {
        super(prefix, command, description);
    }

    @Override
    public void execute(String prefix, String command, CommandSender commandSender, String[] strings) {


        if(!(commandSender instanceof ConsoleSender)) {
            return;
        }

        System.out.println(ConsoleColors.GREEN_BRIGHT + "Stopping VESE");
        VESE.stop();
    }
}
