import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Guesser {

    static int TopBound = 10;
    static int BottomBound = 0;


    public static void GameLoop(Scanner scanner)
    {
        boolean GameActive = true; // Game loop boolean
        int number = ThreadLocalRandom.current().nextInt(BottomBound, TopBound + 1);
        int guesses = 0; // Guess counter

        System.out.println("A random number between " + BottomBound + " and " + TopBound + " has been chosen.");

        while ( GameActive ) { // While game is active...

            // System.out.println(number);
            System.out.print("Guess a number: ");
            String userInput = scanner.nextLine(); // Obtain user guess
                
            if ( number == Integer.parseInt(userInput) ) {
                guesses++;
                GameActive = false;
            } else {
                if ( number > Integer.parseInt(userInput)) {
                    System.out.println("Higher!");
                } else {
                    System.out.println("Lower!");
                }   
                guesses++;
            }
        }

        System.out.println("You got it! It took you " + guesses + " guesses to find the answer.\n");

    }

}