package org.grigore;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandProcessor {
    public static String process(String inputCommands) {
        StringBuilder response = new StringBuilder();

        String tempCommand = clean(inputCommands);

        // isolate plateau X and Y, and the rovers info
        Pattern pattern = Pattern.compile("^(?<x>\\d+) +(?<y>\\d+)\\n(?<rovers>.+)", Pattern.DOTALL); // extract plateau X and Y and isolate rovers commands
        Matcher matcher = pattern.matcher(tempCommand);

        if (!matcher.find()) {
            return null;
        }

        int plateauXLimit = Integer.parseInt(matcher.group("x"));
        int plateauYLimit = Integer.parseInt(matcher.group("y"));

        Plateau plateau = null;
        try {
            plateau = Plateau.getInstance(plateauXLimit, plateauYLimit);
        } catch (InvalidPlateauLimitsException e) {
            System.out.println(e);
            return null;
        } catch (Exception e) {
            System.out.println("Unknown exception occurred: " + e);
            return null;
        }

        String roversDetails = matcher.group("rovers");

        // extract each rover's info
        pattern = Pattern.compile("(?<x>\\d+) +(?<y>\\d+) +(?<direction>[NESW])\\n(?<movement>[LRM]+)"); // isolate each rover X and Y and its commands
        matcher = pattern.matcher(roversDetails);

        ArrayList<String> commands = new ArrayList<>();
        int roverCount = 0;
        while (matcher.find()) {
            roverCount++;
            int roverX = Integer.parseInt(matcher.group("x"));
            int roverY = Integer.parseInt(matcher.group("y"));
            char roverDirection = matcher.group("direction").charAt(0);
            String movement = matcher.group("movement");

            try {
                plateau.addRover(new Rover(roverX, roverY, roverDirection));
            } catch (RoverPositionException e) {
                return e.toString();
            }
            commands.add(movement);
        }

        for (int i = 0; i < plateau.getRovers().size(); i++) {
            Rover rover = plateau.getRovers().get(i);
            String movement = commands.get(i);
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

            if (i > 0) {
                response.append(System.lineSeparator());
            }

            response.append(rover);
        }

        response.trimToSize();
        return response.toString();
    }

    private static String clean(String command) {
        StringBuilder temp = new StringBuilder(command.toUpperCase());
        temp.replace(0, temp.length(), temp.toString().replaceAll("^\\s+", "")); // delete spaces at the start of the string
        temp.replace(0, temp.length(), temp.toString().replaceAll("\\s+$", "")); // delete the spaces at the end of the string
        temp.replace(0, temp.length(), temp.toString().replaceAll(" *\\r?\\n *", "\n")); // delete multiple newlines
        temp.replace(0, temp.length(), temp.toString().replaceAll(" {2,}", " ")); // delete multiple spaces
        return temp.toString();
    }
}
