package de.vese.vese;



/*
    VESE - VESE
    Version: 1.0.0
    Author: Devin, David
    Alias: StaticRed, Dawitschi
 */

/*
    VESE (Virtual Economy Simulation Enviroment) is a backend bases simulation of a more or less realistic economy.
    The program is based on primitive buying and selling of products and or shares.
    Its to demonstrate how a market reacts,when something changes.
    It also simulates the development of a participant and its decision making, with respect to its "Personality".

    The program is separated in a BackEnd (JAVA) and a FrontEnd (C#). The 2 systems are then connected over a webservice.
    
 */


import de.staticred.caa.CAA;
import de.vese.vese.commands.EndCommand;
import de.vese.vese.commands.HelpCommand;
import de.vese.vese.commands.ListCommandsCommand;
import de.vese.vese.logger.Logger;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Timer;

public class VESE {
    private String version = "1.0.0 - Alpha";

    private CAA caa;

    private Timer service;

    private static VESE INSTANCE;

    private Logger logger;

    private File location;

    private PrintStream console = new PrintStream(new FileOutputStream(FileDescriptor.out));

    private SimpleDateFormat savingTimeFormat =  new SimpleDateFormat("dd MM yyyy HH-mm-ss");

    private long startMillis;

    //VESE main startup Method
    public static void main(String[] args) {
        new VESE();
    }

    public static VESE getInstance() {
        return INSTANCE;
    }

    public VESE() {
        INSTANCE = this;
        startMillis = System.currentTimeMillis();

        //CAA = Console Application API
        service = new Timer("Console");
        caa = new CAA(System.in,service ,true);

        //this will figure out where the .jar file is located
        URL urlLocation = getClass().getProtectionDomain().getCodeSource().getLocation();
        location = new File(urlLocation.getPath()).getParentFile();

        this.logger = new Logger();

        registerCommands();

        //Outputting general Information



    }

    private void registerCommands() {
        caa.commandHandler.registerCommand(new EndCommand("","end","End Vese and saves all data"));
        caa.commandHandler.registerCommand(new HelpCommand("","help", "Use ?command to see a commands descirption"));
        caa.commandHandler.registerCommand(new ListCommandsCommand("","listcommands", "Lists every command"));
    }

    public static void stop() {
        System.exit(0);
    }

    public Logger getLogger() {
        return logger;
    }

    public PrintStream getConsole() {
        return console;
    }

    public File getLocation() {
        return location;
    }

    public SimpleDateFormat getSavingTimeFormat() {
        return savingTimeFormat;
    }

    public long getStartMillis() {
        return startMillis;
    }

    public CAA getCaa() {
        return caa;
    }
}
