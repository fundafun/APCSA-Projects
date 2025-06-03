

import java.util.Scanner;

public class Main {

    // List of words for the Hangman game
    private static String[] words = {"apple", "banana", "orange", "lime", "lemon", "mangosteen", "starfruit", "mango", "lychee", "rambutan", "peach", "grapes"};
    // Randomly selects a word from the list
    private static String word = words[(int) (Math.random() * words.length)];
    // Creates a string of asterisks based on the length of the word
    private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
    private static int count = 0; // Tracks the number of incorrect guesses
    private static int maxGuesses; // Maximum number of incorrect guesses based on difficulty level

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Displaying welcome message and difficulty selection
        System.out.println("Welcome to the fruit-themed Hangman game!");
        System.out.println("Choose a difficulty level:");
        System.out.println("1. Easy (10 incorrect guesses allowed)");
        System.out.println("2. Medium (7 incorrect guesses allowed)");
        System.out.println("3. Hard (5 incorrect guesses allowed)");

        // Reading user input for difficulty
        int difficulty = sc.nextInt();

        // Setting the maximum number of guesses based on user input
        switch (difficulty) {
            case 1:
                maxGuesses = 10;
                break;
            case 2:
                maxGuesses = 7;
                break;
            case 3:
                maxGuesses = 5;
                break;
            default:
                System.out.println("Invalid choice, defaulting to Medium difficulty.");
                maxGuesses = 7;
        }

        // Main game loop
        while (count < maxGuesses && asterisk.contains("*")) {
            // Prompt the user to guess a letter or quit
            System.out.println("Guess any letter in the word (or type 'quit' to exit):");
            System.out.println(asterisk);
            String guess = sc.next();

            // Check if the user wants to quit
            if (guess.equalsIgnoreCase("quit")) {
                System.out.println("You quit the game. The word was: " + word);
                break;
            }

            // Process the guess and update the word representation
            hang(guess);
            // Display the hangman image after each guess
            hangmanImage();
        }
        // Close the scanner to prevent resource leak
        sc.close();
    }

    // Method to process the user's guess and update the word
    public static void hang(String guess) {
        String newAsterisk = "";
        // Loop through the word and update asterisk string
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess.charAt(0)) {
                newAsterisk += guess.charAt(0);
            } else if (asterisk.charAt(i) != '*') {
                newAsterisk += word.charAt(i);
            } else {
                newAsterisk += "*";
            }
        }

        // If no changes, increment incorrect guess count
        if (asterisk.equals(newAsterisk)) {
            count++;
        } else {
            asterisk = newAsterisk;
        }

        // Check if the word is completely guessed or the player ran out of guesses
        if (asterisk.equals(word)) {
            System.out.println("Correct! You win! The word was " + word);
        } else if (count == maxGuesses) {
            System.out.println("GAME OVER! The word was " + word);
        }
    }

    // Method to display the hangman image based on the number of incorrect guesses
    public static void hangmanImage() {
        // Print different hangman images based on the number of incorrect guesses
        if (count == 1) {
            System.out.println("Wrong guess, try again");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        } else if (count == 2) {
            System.out.println("Wrong guess, try again");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        } else if (count == 3) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        } else if (count == 4) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        } else if (count == 5) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        } else if (count == 6) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        } else if (count == maxGuesses) {
            System.out.println("GAME OVER!");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
    }
}
