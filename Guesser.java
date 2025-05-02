import java.util.Scanner;

public class Guesser {

    static int TopBound = 10;
    static int BottomBound = 0;

    public static void GameLoop(Scanner scanner)
    {
        boolean GameActive = true; // Game loop boolean
        int guesses = 0; // Guess counter

        while ( GameActive ) { // While game is active...
            Equation question = new Equation(); // Create equation for guess
            question.DisplayEquation(false);
            System.out.println();
            int userInput = InputHandler.ObtainIntInput(scanner, 0);
                
            if ( question.EvaluateEquation(userInput) ) {
                guesses++;
                System.out.println("Correct!\n");
                // GameActive = false;
            } else {
                System.out.println("Incorrect. Try again!\n");
                guesses++;
            }
        }

        System.out.println("You got it! It took you " + guesses + " guesses to find the answer.\n");

    }

    public static void SetBounds(Scanner scanner) {
        System.out.print("Please type the bottom bound ( i.e. Guess from _ to 10): ");
        int BottomBoundPotential = InputHandler.ObtainIntInput(scanner, 0);
        System.out.print("Please type the top bound ( i.e. Guess from 0 to _ ): ");
        int TopBoundPotential = InputHandler.ObtainIntInput(scanner, 0);
        if ( BottomBoundPotential >= TopBoundPotential ) {
            System.out.println("ERROR: Unable to set bounds!" + BottomBound + " is larger (or equal to) " + TopBound + ".\nPlease try again with a bottom bound that is LOWER than the top bound.\n");
        } else {
            BottomBound = BottomBoundPotential;
            TopBound = TopBoundPotential;
            System.out.println("Random number generator bounds set to " + BottomBound + " and " + TopBound + ".\n");
        }
    }
}