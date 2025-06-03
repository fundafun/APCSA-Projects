/*
Purpose: Upgraded adventure game from runestone
Date: 11/13/24
 */

import java.util.Random;
import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        System.out.println("\n\nYou want to take the Green Line in Boston City.");
        System.out.println("You can head north, south, east, or west along the Green Line.");
        System.out.println("Type 'exit' anytime to end your journey.");

        // random limit for the amount of moves (between 5 and 10)
        int moveLimit = random.nextInt(6) + 5;  // between 5 and 10
        int moveCount = 0;

        boolean exploring = true;

        while (exploring) {
            System.out.print("\nWhich direction do you want to go (n, e, s, w, nw, ne, sw, se)? ");
            String command = scan.next().toLowerCase();

            if (command.equals("exit")) {
                exploring = false;
                System.out.println("Ending your journey on the Green Line. Goodbye!");
            } else {
                handleCommand(command);
                moveCount++;  // increment move count with each move

                // Random event chance (1 in 5 chance of journey ending unexpectedly)
                int eventChance = random.nextInt(5) + 1; // generates a number between 1 and 5
                if (eventChance == 1) {
                    System.out.println("\nA sudden event has occurred, ending your journey unexpectedly!");
                    exploring = false;
                }

                // If move limit has been reached
                if (moveCount >= moveLimit) {
                    System.out.println("\nA sudden delay has ended your journey on the Green Line.");
                    exploring = false;
                }
            }
        }

        scan.close();
    }

    // Methods for each direction
    public static void goNorth() {
        System.out.println("You head north and reach the Science Museum station.");
    }

    public static void goSouth() {
        System.out.println("You go south and find yourself at the Boston Common station.");
    }

    public static void goEast() {
        System.out.println("You take the line east toward Park Street, the heart of the Green Line.");
    }

    public static void goWest() {
        System.out.println("You head west and reach the Boston University Central stop.");
    }

    public static void goNorthwest() {
        System.out.println("You travel northwest, ending up at the Kenmore station.");
    }

    public static void goSouthwest() {
        System.out.println("Heading southwest, you discover Fenway Park nearby.");
    }

    public static void goNortheast() {
        System.out.println("You go northeast and find the Government Center station.");
    }

    public static void goSoutheast() {
        System.out.println("You travel southeast and reach the bustling Downtown Crossing.");
    }

    public static void invalidDirection() {
        System.out.println("That’s not a valid direction. Try choosing a different route!");
    }

    // Method for user input/commands
    public static void handleCommand(String command) {
        switch (command) {
            case "n": goNorth(); break;
            case "s": goSouth(); break;
            case "e": goEast(); break;
            case "w": goWest(); break;
            case "nw": goNorthwest(); break;
            case "sw": goSouthwest(); break;
            case "ne": goNortheast(); break;
            case "se": goSoutheast(); break;
            default: invalidDirection(); break;
        }
    }
}
