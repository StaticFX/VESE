package de.vese.vese.logger;

import de.vese.vese.VESE;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class VESEOutStream extends PrintStream {


    public VESEOutStream(@NotNull File file) throws FileNotFoundException {
        super(file);
    }



    @Override
    public void print(boolean x) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().print(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);    }

    @Override
    public void print(char x) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().print(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);    }

    @Override
    public void print(int x) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().print(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);    }

    @Override
    public void print(long x) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().print(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);    }

    @Override
    public void print(float x) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().print(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);
    }

    @Override
    public void print(double x) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().print(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);
    }

    @Override
    public void print(@NotNull char[] x) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().print(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);
    }

    @Override
    public void print(@Nullable String x) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));



        //Console logging
        VESE.getInstance().getConsole().print(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] " + ConsoleColors.RESET + x + ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] " + ConsoleColors.RESET + x + ConsoleColors.RESET);
    }

    @Override
    public void print(@Nullable Object x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().print(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);
    }

    @Override
    public void println() {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET +ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET  + ConsoleColors.RESET);
    }

    @Override
    public void println(boolean x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);
    }

    @Override
    public void println(char x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);
    }

    @Override
    public void println(int x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);
    }

    @Override
    public void println(long x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);
    }

    @Override
    public void println(float x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);
    }

    @Override
    public void println(double x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);
    }

    @Override
    public void println(@NotNull char[] x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);
    }

    @Override
    public void println(@Nullable String x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);
    }

    @Override
    public void println(@Nullable Object x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);

        //File logging
        VESE.getInstance().getLogger().logToFile(ConsoleColors.BLACK_BRIGHT+ "[" + ConsoleColors.GREEN_BRIGHT + "VESE" + ConsoleColors.BLACK_BRIGHT + "] ["+ ConsoleColors.RED_BRIGHT + time + ConsoleColors.BLACK_BRIGHT + "] : " + ConsoleColors.RESET + x + ConsoleColors.RESET);
    }


    public String[] cutStringToExpressions(String in) {
        return in.split("§[0-9a-f]+");
    }
}
