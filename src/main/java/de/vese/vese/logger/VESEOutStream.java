package de.vese.vese.logger;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.AnsiFormat;
import de.vese.vese.VESE;
import de.vese.vese.util.ColorTranslator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.boot.ansi.AnsiColor;

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class VESEOutStream extends PrintStream {

    private Ansi ansi = new Ansi();

    public VESEOutStream(@NotNull File file) throws FileNotFoundException {
        super(file);
    }

    @Override
    public void print(boolean b) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + b)));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + b)));    }

    @Override
    public void print(char c) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + c)));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + c)));    }

    @Override
    public void print(int i) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: "+ i)));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + i)));    }

    @Override
    public void print(long l) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: "+ l)));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + l)));    }

    @Override
    public void print(float f) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: "+ f)));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + f)));
    }

    @Override
    public void print(double d) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + d)));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + d)));
    }

    @Override
    public void print(@NotNull char[] s) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + s)));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + s)));
    }

    @Override
    public void print(@Nullable String s) {
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + s)));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + s)));
    }

    @Override
    public void print(@Nullable Object obj) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + obj)));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + obj)));
    }

    @Override
    public void println() {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: ")));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: ")));
    }

    @Override
    public void println(boolean x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + x)));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + x)));
    }

    @Override
    public void println(char x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + x)));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + x)));
    }

    @Override
    public void println(int x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + x)));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + x)));
    }

    @Override
    public void println(long x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + x)));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + x)));
    }

    @Override
    public void println(float x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + x)));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + x)));
    }

    @Override
    public void println(double x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + x)));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + x)));
    }

    @Override
    public void println(@NotNull char[] x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + x)));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + x)));
    }

    @Override
    public void println(@Nullable String x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));


        String[] out = cutStringToExpressions(x);




        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + x)));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + x)));
    }

    @Override
    public void println(@Nullable Object x) {
        //Logging process
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));

        //Console logging
        VESE.getInstance().getConsole().println(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + x)));

        //File logging
        VESE.getInstance().getLogger().logToFile(Ansi.colorize(ColorTranslator.translateColorToAnsi("§8[§aVESE§8] [§f"+ time + "§8] §r: " + x)));
    }


    public String[] cutStringToExpressions(String in) {
        ArrayList<String> expressions = new ArrayList<>();

        //go trough all char in the given string, but not the last one, because it cant be a valid regex
        for(int i = 0; i < in.length()-1; i++) {
            String regexCombination;

            //get the char on the current position of the loop
            char inChar = in.toCharArray()[i];
            char nextChar = in.toCharArray()[i+1];

            regexCombination = "" + inChar + nextChar;

            //first char is a valid regex expression
            if(("" + inChar + nextChar).matches("§[0-9a-f]")) {
                //loop used to scan for multiple regex usages like §6§l (gold + bold)

                int j = 0;
                System.out.print(i+3+j);
                while(i+2+j < in.length()) {

                    char firstChar = in.toCharArray()[i+2+j];
                    char secondChar = in.toCharArray()[i+3+j];

                    if(("" + firstChar + secondChar).matches("§[0-9a-f]"))
                        regexCombination = regexCombination + firstChar + secondChar;

                    j++;
                }
            }

            expressions.add(regexCombination);

        }


        String[] tests = in.split("(§[0-9a-f])+");
        for(int i = 1; i < tests.length; i++) {
            tests[i] = expressions.get(i-1) + tests[i];
        }

        System.out.println(Arrays.toString(tests));

        return tests;

    }

}
