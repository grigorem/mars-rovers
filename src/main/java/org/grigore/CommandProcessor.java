package org.grigore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandProcessor {
    public static String process(String commands) {
        StringBuilder response = new StringBuilder();

        String tempCommand = clean(commands);

        // isolate plateau X and Y, and the rovers info
        Pattern pattern = Pattern.compile("^(?<x>\\d+) +(?<y>\\d+)\\n(?<rovers>.+)", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(tempCommand);

        if (!matcher.find()) {
            return null;
        }

        int plateauXLimit = Integer.parseInt(matcher.group("x"));
        int plateauYLimit = Integer.parseInt(matcher.group("y"));
        Plateau.getInstance(plateauXLimit, plateauYLimit);

        String roversDetails = matcher.group("rovers");

        // extract each rover's info
        pattern = Pattern.compile("(?<x>\\d+) +(?<y>\\d+) +(?<direction>[NESW])\\n(?<movement>[LRM]+)");
        matcher = pattern.matcher(roversDetails);

        while (matcher.find()) {
            int roverX = Integer.parseInt(matcher.group("x"));
            int roverY = Integer.parseInt(matcher.group("y"));
            char roverDirection = matcher.group("direction").charAt(0);
            String movement = matcher.group("movement");

            Rover rover = new Rover(roverX, roverY, roverDirection);

            for (char c : movement.toCharArray()) {
                switch (c) {
                    case 'M':
                        rover.move();
                        break;
                    case 'L':
                        rover.turnLeft();
                        break;
                    case 'R':
                        rover.turnRight();
                        break;
                    default:
                        // do nothing
                }
            }

            response.append(rover).append(System.getProperty("line.separator"));
        }
        response.deleteCharAt(response.length() - 1);
        return response.toString();
    }

    private static String clean(String command) {
        StringBuilder temp = new StringBuilder(command);
        temp.replace(0, temp.length(), temp.toString().replaceAll("^\\s+", ""));
        temp.replace(0, temp.length(), temp.toString().replaceAll("\\s+$", ""));
        temp.replace(0, temp.length(), temp.toString().replaceAll(" *\\r?\\n *", "\n"));
        temp.replace(0, temp.length(), temp.toString().replaceAll(" {2,}", "\n"));
        return temp.toString();
    }
}