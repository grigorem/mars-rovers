package org.grigore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserInput {
    public static String getInputFromUser() {
        StringBuilder input = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Welcome to the app where you can control a fleet of Rovers on Mars.");
            System.out.println("On the next lines you will need to give the information about the rovers and the commands you want to be executed.");
            System.out.println("Please enter the plateau upper limits (two positive integers separated by a space; ex: 7 9)");
            input.append(reader.readLine()).append(System.getProperty("line.separator"));
            System.out.println("Brilliant! Now you will need to input each rover's initial position and their movement on the plateau.");
            do {
                System.out.println("Please enter the coordinates and the cardinal direction the rover is facing separated by a space (ex: 5 5 N)");
                input.append(reader.readLine()).append(System.getProperty("line.separator"));
                System.out.println("Please enter the movement of the rover without any spaces (M = move, L = turn left, R = turn right; ex: MMRMLLM)");
                input.append(reader.readLine()).append(System.getProperty("line.separator"));
                System.out.println("Do you want to add one more rover? Type 'Y' if YES or anything else to stop");
            } while (reader.readLine().equalsIgnoreCase("y"));
        } catch (Exception e) {
            return null;
        }
        return input.toString();
    }

    public static String getFromUserFile(String file) {
        try {
            return new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            return null;
        }
    }
}
