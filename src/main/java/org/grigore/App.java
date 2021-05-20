package org.grigore;

public class App {
    public static void main(String[] args) {
        StringBuilder input = new StringBuilder();
        if (args.length > 0) {
            input.append(UserInput.getFromUserFile(args[0]));
        } else {
            input.append(UserInput.getInputFromUser());
        }

        if (input.length() == 0) {
            System.out.println("Input not valid");
            return;
        }

        System.out.println(CommandProcessor.process(input.toString()));
    }
}