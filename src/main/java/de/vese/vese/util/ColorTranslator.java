package de.vese.vese.util;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.AnsiFormat;
import org.springframework.boot.ansi.AnsiColor;

public class ColorTranslator {

    public static String translateColorToAnsi(String input) {
        return input.replaceAll("§1", AnsiColor.BLUE.toString())
                .replaceAll("§9",AnsiColor.BRIGHT_BLUE.toString())
                .replaceAll("§3",AnsiColor.CYAN.toString())
                .replaceAll("§b",AnsiColor.BRIGHT_CYAN.toString())
                .replaceAll("§4",AnsiColor.RED.toString())
                .replaceAll("§c",AnsiColor.BRIGHT_RED.toString())
                .replaceAll("§e",AnsiColor.BRIGHT_YELLOW.toString())
                .replaceAll("§6",AnsiColor.YELLOW.toString())
                .replaceAll("§2",AnsiColor.GREEN.toString())
                .replaceAll("§a",AnsiColor.BRIGHT_GREEN.toString())
                .replaceAll("§5",AnsiColor.MAGENTA.toString())
                .replaceAll("§d",AnsiColor.BRIGHT_MAGENTA.toString())
                .replaceAll("§f",AnsiColor.WHITE.toString())
                .replaceAll("§7",AnsiColor.BRIGHT_BLACK.toString())
                .replaceAll("§8",AnsiColor.BRIGHT_BLACK.toString())
                .replaceAll("§0",AnsiColor.BLACK.toString())
                .replaceAll("§r",Ansi.RESET);

    }

    public static String expressionsToColor(String[] expressions) {

        String out;


        for(int i = 1; i < expressions.length; i++) {

            String first2Letters = expressions[i].substring(2);


            AnsiFormat format;

            switch (first2Letters) {

                case "§9": {

                    break;
                }




            }

        }

        return "";

    }

}
