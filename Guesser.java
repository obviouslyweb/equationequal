import java.util.Scanner;

public class Guesser {

    public static void GameLoop(Scanner scanner)
    {
        System.out.println("\nType the missing number for the answer for the given equations.\n");

        boolean GameActive = true; // Game loop boolean
        int guesses = 0; // Guess counter
        int corrects = 0;
        int incorrects = 0;

        while ( GameActive ) { // While game is active...
            Equation question = new Equation(); // Create equation for guess
            question.DisplayEquation(true);
            System.out.println();
            int userInput = InputHandler.ObtainIntInput(scanner, 0);
                
            if ( question.EvaluateEquation(userInput) ) {
                guesses++;
                corrects++;
                System.out.println("Correct!\n");
                // GameActive = false;
            } else {
                System.out.println("Incorrect. Try again!\n");
                guesses++;
                incorrects++;
            }
        }

        System.out.println("You got it! It took you " + guesses + " guesses to find the answer.\n");

    }

    
}