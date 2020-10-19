package de.vese.vese.commands;

import de.staticred.caa.commandapi.util.Command;
import de.staticred.caa.commandapi.util.CommandSender;
import de.staticred.caa.commandapi.util.ConsoleSender;
import de.vese.vese.VESE;

public class RestartCommand extends Command {


    public RestartCommand(String prefix, String command, String description) {
        super(prefix, command, description);
    }

    @Override
    public void execute(String s, String s1, CommandSender commandSender, String[] strings) {

        if(!(commandSender instanceof ConsoleSender)) {
            return;
        }

        System.out.println("Restarting VESE");
        VESE.restartVese();
    }
}
