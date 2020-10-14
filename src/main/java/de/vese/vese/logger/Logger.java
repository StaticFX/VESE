package de.vese.vese.logger;

import de.vese.vese.VESE;

import java.io.*;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Date;

public class Logger {

    //this will output to a certain file and the console
    private VESEOutStream customOutPut;

    private File latestLog;

    private Collection<File> oldLogs;

    private PrintStream latestLogPrinter;

    public Logger() {

        try {
            latestLog = new File(VESE.getInstance().getLocation().getAbsolutePath() + "/logs", "latest.log");
            customOutPut = new VESEOutStream(new File("Logger"));
            System.setOut(customOutPut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        createNewLogFile();
    }

    public boolean createNewLogFile() {
        if(!latestLog.exists()) {
            latestLog.getParentFile().mkdirs();
            try {
                latestLog.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }else{
            try {
                Files.move(latestLog.toPath(), latestLog.toPath().resolveSibling("[" + VESE.getInstance().getSavingTimeFormat().format(new Date(VESE.getInstance().getStartMillis())) + "].log"));
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            createNewLogFile();
            return true;
        }

        try {
            OutputStream out = new FileOutputStream(latestLog);
            latestLogPrinter = new PrintStream(out,true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }


    public void logToFile(Object x) {
        latestLogPrinter.println(x);
    }





}
