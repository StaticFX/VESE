package de.vese.vese.commands;

import de.staticred.caa.commandapi.util.Command;
import de.staticred.caa.commandapi.util.CommandSender;
import de.staticred.caa.commandapi.util.ConsoleSender;
import de.vese.vese.simulation.Simulation;

import java.util.UUID;

/*
    VESE - InitSimulationCommand
    Version: 1.0.0
    Author: David
    Alias: Dawitschi
 */
public class InitSimulationCommand extends Command {
    public InitSimulationCommand(String prefix, String command, String description) {
        super(prefix, command, description);
    }

    @Override
    public void execute(String prefix, String command, CommandSender commandSender, String[] strings) {
        if(!(commandSender instanceof ConsoleSender)) {
            return;
        }
        //Create a new Simulation
        Simulation simp = new Simulation(UUID.randomUUID());
        //Initialize the Simulation
        int amountParticipants = 10;
        int amountItems = 2;
        int companiesPerItem = 1;
        simp.initSimulation(amountParticipants,companiesPerItem,amountItems);


    }
}
