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
import de.vese.vese.backendrouting.webservice.RouterManager;
import de.vese.vese.backendrouting.webservice.WebServiceApplication;
import de.vese.vese.commands.EndCommand;
import de.vese.vese.commands.HelpCommand;
import de.vese.vese.commands.ListCommandsCommand;
import de.vese.vese.db.admin.AccountDAO;
import de.vese.vese.db.admin.AdminDataBaseConnection;
import de.vese.vese.exceptions.CantReadFileException;
import de.vese.vese.exceptions.IllegalCreationException;
import de.vese.vese.filemanager.ConfigFileManager;
import de.vese.vese.logger.ConsoleColors;
import de.vese.vese.logger.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.sql.SQLException;
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

    public static final String PREFIX = "VESE\\> ";

    private PrintStream console;

    private SimpleDateFormat savingTimeFormat =  new SimpleDateFormat("dd MM yyyy HH-mm-ss");

    //timeStamp since vese is running
    private long startMillis;

    public static RouterManager routingManger;

    private ConfigFileManager config;

    private AccountDAO accountDAO;

    //Connection to the SQL_ADMIN_DATABASE point
    private AdminDataBaseConnection adminDataBaseConnection;

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

        //vese will always return to this stream as the out for the console
        console = System.out;


        //CAA = Console Application API
        service = new Timer("Console");
        caa = new CAA(System.in,service ,true);

        //this will figure out where the .jar file is located
        URL urlLocation = getClass().getProtectionDomain().getCodeSource().getLocation();
        location = new File(urlLocation.getPath()).getParentFile();

        this.logger = new Logger();
        //manger class used to rout ingoing inputs from the frontEnd
        routingManger = new RouterManager();


        System.out.println("Starting VESE " +ConsoleColors.CYAN_BRIGHT + VERSION);
        System.out.println(ConsoleColors.GREEN_BRIGHT + "__   __ ___  ___  ___");
        System.out.println(ConsoleColors.GREEN_BRIGHT +"\\ \\ / /| __|/ __|| __|");
        System.out.println(ConsoleColors.GREEN_BRIGHT +" \\   / | _| \\__ \\| _|");
        System.out.println(ConsoleColors.GREEN_BRIGHT +"  \\_/  |___||___/|___|");
        System.out.println();

        System.out.println("VESE was found in: " + ConsoleColors.YELLOW_BRIGHT + location.getAbsolutePath());


        registerCommands();

        System.out.println("Starting WebServie via. Spring");
        SpringApplication.run(WebServiceApplication.class, args);

        //Outputting general Information


        //config.json file
        config = new ConfigFileManager(new File(location.getAbsolutePath() + "/VESEFiles/config.json"));
        try {
            config.loadFile();
        } catch (CantReadFileException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Trying to connect to database");
        try {
            adminDataBaseConnection = new AdminDataBaseConnection();
        } catch (IllegalCreationException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Loading table Accounts");
        accountDAO = new AccountDAO();
        try {
            accountDAO.loadDataBase();
        } catch (SQLException throwables) {
            System.out.println(ConsoleColors.RED_BRIGHT + "Failed while loading database.");
            throwables.printStackTrace();
            return;
        }


        //setting console prefix
        caa.setPrefix(PREFIX);
        System.out.println(ConsoleColors.GREEN_BRIGHT + "VESE is now ready to use. Type 'help' for help");
        System.out.print(PREFIX);

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

    public ConfigFileManager getConfig() {
        return config;
    }

    public AdminDataBaseConnection getAdminDataBaseConnection() {
        return adminDataBaseConnection;
    }
}
