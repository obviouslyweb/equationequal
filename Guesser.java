import java.util.Scanner;

public class Guesser {

    public static void GameLoop(Scanner scanner)
    {
        System.out.println("\nType the missing number for the answer for the given equations.\nType 'end' to end the game.\n");

        boolean GameActive = true; // Game loop boolean
        int guesses = 0; // Guess counter
        int corrects = 0;

        while ( GameActive ) { // While game is active...
            Equation question = new Equation(); // Create equation for guess
            question.DisplayEquation(true);
            System.out.println();
            String userInput = InputHandler.ObtainGameInput(scanner);
                
            if ( userInput.equalsIgnoreCase("end") ) {
                GameActive = false;
            } else if ( question.EvaluateEquation(Integer.parseInt(userInput)) ) {
                guesses++;
                corrects++;
                System.out.println("Correct!\n");
                // GameActive = false;
            } else {
                System.out.println("Incorrect. Try again!\n");
                guesses++;
            }
        }
        // END RESULTS
        if ( guesses == 0 ) {
            System.out.println("\nGame ended early.\nPress ENTER key to proceed. ");
        } else {
            System.out.println("RESULTS\n" + guesses + " total questions\n" + corrects + " correct answers\n" + ((corrects * 100) / guesses) + "% correct\n\nPress ENTER key to proceed. ");
        }
        
        scanner.nextLine();
    }
}