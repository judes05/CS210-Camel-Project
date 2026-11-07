package camelfestival;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class InputReader {

    // inputFile: e.g. "Input.txt"
    // errorFile: e.g. "Errors.txt". Each invalid line is written as:
    //            Line 57: <the line> -> <reason>
    //            If errorFile is null, still skip invalid lines but write no file
    //            (the benchmark uses this, because benchmark runs write no files).
    // Returns the list of valid camels (scores not calculated yet).
    public static CamelLinkedList readFile(String inputFile, String errorFile) {
        CamelLinkedList list = new CamelLinkedList();
        PrintWriter error = null;
        try (BufferedReader readlist = new BufferedReader(new FileReader(inputFile))) {
            if (errorFile != null) {
                error = new PrintWriter(new FileWriter(errorFile));
            }
            String lines;
            int lineNum = 0;
            // string cant read to bolean 
            while ((lines = readlist.readLine()) != null) {
                lineNum++;
                // code didnt work so i add fix 
                String fix;
                if (lines.endsWith(";")) {
                    fix = lines.substring(0, lines.length() - 1);
                } else {
                    fix = lines;
                }

                String[] f = fix.split(";", -1);
                String reason = validate(f);

                if (reason == null) {
                    list.addLast(new Camel(f[0].trim(),
                            f[1].trim().charAt(0),
                            Double.parseDouble(f[2].trim()),
                            Integer.parseInt(f[3].trim()),
                            Integer.parseInt(f[4].trim()),
                            f[5].trim(),
                            Double.parseDouble(f[6].trim())));
                } else if (error != null) {
                    error.println("line " + lineNum + ": " + lines + " -> " + reason);
                }

            }
        } catch (IOException e) {
            System.out.println("CAN NOT WRITE" + inputFile);
        } finally {
            if (error != null) {
                error.close();
            }
        }

        return list;
    }

    private static String validate(String[] f) {
        if (f.length != 7) {
            return " wrong number of fields";
        }

        String id = f[0].trim();
        String breed = f[1].trim();
        String stables = f[5].trim();

        if (id.length() != 8) {
            return "invalid camel ID";
        }
        if (!(breed.equals("A") || breed.equals("M")
                || breed.equals("W") || breed.equals("H"))) {
            return "invalid breed code";
        }
                if (stables.length() != 3) {
            return "invalid stables code";
        }
        for (int i = 0; i < stables.length(); i++) {
            if (!Character.isLetter(stables.charAt(i))) {
                return "invalid stables code";
            }
        }

        double win, speed;
        int year, heritage;
        try {
            win = Double.parseDouble(f[2].trim());
            year = Integer.parseInt(f[3].trim());
            heritage = Integer.parseInt(f[4].trim());
            speed = Double.parseDouble(f[6].trim());
        } catch (NumberFormatException e) {
            return "a number field is not a number";
        }

        if (win < 0 || win > 100) {
            return "win rate out of range";
        }
        if (year < 2026) {
            return "target year out of range";
        }
        if (heritage < 1 || heritage > 5) {
            return "heritage rating out of range";
        }
        if (speed < -100 || speed > 100) {
            return "speed variation out of range";
        }

        return null;

    }
}
