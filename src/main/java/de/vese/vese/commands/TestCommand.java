package de.vese.vese.commands;

import de.staticred.caa.commandapi.util.Command;
import de.staticred.caa.commandapi.util.CommandSender;
import de.staticred.caa.commandapi.util.ConsoleSender;
import de.vese.vese.simulation.company.Company;
import de.vese.vese.simulation.market.Item;
import de.vese.vese.simulation.participant.Job;
import de.vese.vese.simulation.participant.Need;
import de.vese.vese.simulation.participant.Needs;
import de.vese.vese.simulation.participant.Participant;

import java.util.ArrayList;
import java.util.List;

/**
 * Command used debug
 * Will be removed later
 *
 * @author David
 * @version 1.0.0
 */
public class TestCommand extends Command {
    public TestCommand(String prefix, String command, String description) {
        super(prefix, command, description);
    }

    @Override
    public void execute(String prefix, String command, CommandSender commandSender, String[] strings) {
        if(!(commandSender instanceof ConsoleSender)) {
            return;
        }
        //Testing: getWorstParticipant()
        //Creates random Participant
        List<Double> listNeeds = new ArrayList<>();
        for(Need need : Need.values()) {
            listNeeds.add(100.0);
        }
        Needs needs = new Needs(listNeeds, 100);
        Participant participant = new Participant(null,1000, needs, null,true);
        Participant participant1 = new Participant(null,1000, needs, null,true);
        participant.randomizePersonality();
        participant1.randomizePersonality();
        //Creates random item
        Item product = new Item(needs,100);
        //Creates Company
        List<Job> emptyjob = new ArrayList<>();
        Company company = new Company(emptyjob,product, 0, 0.1,0,1000000,1000);
        //Create a Job
        Job job = new Job(company, participant, 1000);
        Job job1 = new Job(company, participant1, 1000);
        company.getJobs().add(job);
        company.getJobs().add(job1);
        //Test

    }
}
