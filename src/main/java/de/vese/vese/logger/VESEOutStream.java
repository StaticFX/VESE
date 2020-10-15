package de.vese.vese.logger;

import de.vese.vese.VESE;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class VESEOutStream extends PrintStream {

    public VESEOutStream(@NotNull File file) throws FileNotFoundException {
        super(file);
    }

    @Override
    public void print(boolean b) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + b);

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + b);    }

    @Override
    public void print(char c) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + c);

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + c);    }

    @Override
    public void print(int i) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + i);

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + i);    }

    @Override
    public void print(long l) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + l);

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + l);    }

    @Override
    public void print(float f) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + f);

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : "+ f);    }

    @Override
    public void print(double d) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + d);

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + d);    }

    @Override
    public void print(@NotNull char[] s) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + s);

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + s);
    }

    @Override
    public void print(@Nullable String s) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + s);

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + s);
    }

    @Override
    public void print(@Nullable Object obj) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + obj);

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + obj);
    }

    @Override
    public void println() {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : ");

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : ");
    }

    @Override
    public void println(boolean x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + x);

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + x);
    }

    @Override
    public void println(char x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + x);

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + x);
    }

    @Override
    public void println(int x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + x);

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + x);
    }

    @Override
    public void println(long x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + x);

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + x);
    }

    @Override
    public void println(float x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + x);

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + x);
    }

    @Override
    public void println(double x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + x);

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + x);
    }

    @Override
    public void println(@NotNull char[] x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + x);

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + x);
    }

    @Override
    public void println(@Nullable String x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + x);

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + x);
    }

    @Override
    public void println(@Nullable Object x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + x);

        //File logging
        VESE.getInstance().getLogger().logToFile("[" + ConsoleCollors.GREEN + "VESE " + ConsoleCollors.RESET + "] [" + ConsoleCollors.BLUE + time + ConsoleCollors.RESET + "] : " + x);
    }
}
