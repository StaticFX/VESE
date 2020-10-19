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
import de.vese.vese.commands.RestartCommand;
import de.vese.vese.logger.Logger;
import de.vese.vese.webservice.RouterManager;
import de.vese.vese.webservice.WebServiceApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Timer;

@SpringBootApplication
@RestController
public class VESE {
    public static final String VERSION = "1.0.0 - Alpha";

    private CAA caa;

    private Timer service;

    private static VESE INSTANCE;

    private Logger logger;

    private File location;

    //Termial via the. JLine 3 API

    public static final String VESE_ANCII_ART = "\n__   __ ___  ___  ___\n" +
            "\\ \\ / /| __|/ __|| __|\n" +
            " \\   / | _| \\__ \\| _| \n" +
            "  \\_/  |___||___/|___|\n";

    private PrintStream console = new PrintStream(new FileOutputStream(FileDescriptor.out));

    private SimpleDateFormat savingTimeFormat =  new SimpleDateFormat("dd MM yyyy HH-mm-ss");

    //timeStamp since vese is running
    private long startMillis;

    public static RouterManager routingManger;

    //VESE main startup Method
    public static void main(String[] args) {
        new VESE(args);
    }

    public static VESE getInstance() {
        return INSTANCE;
    }

    public VESE(String[] args) {
        INSTANCE = this;
        startMillis = System.currentTimeMillis();

        //this will figure out where the .jar file is located
        URL urlLocation = getClass().getProtectionDomain().getCodeSource().getLocation();
        location = new File(urlLocation.getPath()).getParentFile();

        this.logger = new Logger();

        //manger class used to rout ingoing inputs from the frontEnd
        routingManger = new RouterManager();

        System.out.println("Starting VESE " + VERSION);
        System.out.println(VESE_ANCII_ART);

        //CAA = Console Application API
        service = new Timer("Console");
        caa = new CAA(System.in,service ,true);

        System.out.println("VESE was found in: " + location.getAbsolutePath());


        registerCommands();

        System.out.println("Starting WebServie via. Spring");
        SpringApplication.run(WebServiceApplication.class, args);

        //Outputting general Information

    }

    public static void restartVese() {
        try {
            System.out.println(VESE.getInstance().location.getParent());
            Runtime.getRuntime().exec("D:");
            Runtime.getRuntime().exec("cd " + VESE.getInstance().location.getParent());
            Runtime.getRuntime().exec("mvnw spring-boot:run");
            VESE.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registerCommands() {
        caa.commandHandler.registerCommand(new EndCommand("","end","End Vese and saves all data"));
        caa.commandHandler.registerCommand(new HelpCommand("","help", "Use ?command to see a commands descirption"));
        caa.commandHandler.registerCommand(new ListCommandsCommand("","listcommands", "Lists every command"));
        caa.commandHandler.registerCommand(new RestartCommand("","restart", "Restart VESE"));
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
