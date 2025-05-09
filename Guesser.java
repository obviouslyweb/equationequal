import java.util.ArrayList;
import java.util.Scanner;

public class Guesser {

    static ArrayList<Equation> missedEquations = new ArrayList<Equation>();

    public static void GameLoop(Scanner scanner, boolean missedMode) 
    {
        // if missedMode is enabled, code will only use the missed equations in the missedEquations arraylist

        System.out.println("\nType the missing number for the answer for the given equations.\nType 'end' to end the game.\n");

        boolean GameActive = true;
        int guesses = 0;
        int corrects = 0;

        while ( GameActive ) { // While game is active...
            
            Equation question = new Equation(); // Create a new equation using equation constructor
            
            if ( missedMode ) // If game is in missed mode, override generated equation with missed equation
            {
                question = missedEquations.get(0);
            }

            // Display equation with answer hidden
            question.DisplayEquation(true);

            // Obtain user response
            System.out.println();
            String userInput = InputHandler.ObtainGameInput(scanner);
                
            if ( userInput.equalsIgnoreCase("end") ) { // If response is "end", quit game
                GameActive = false;
            } else if ( question.EvaluateEquation(Integer.parseInt(userInput)) ) { // If response is number, evaluate answer
                guesses++;
                corrects++;
                System.out.println("Correct!\n");
                if ( missedMode ) // If question is in missedEquations, remove it from the list and check if it is empty
                {
                    question = missedEquations.remove(0);
                    if ( IsMissedEmpty() == true ) {
                        GameActive = false;
                        System.out.println("All missed questions solved!");
                    }
                }
            } else { // If incorrect, provide correct answer and add to array (if not in missedMode)
                System.out.println("Incorrect; correct answer was " + question.ReturnEvaluation() + "\n");
                guesses++;
                if ( !missedMode )
                {
                    missedEquations.add(question);
                }

            }
        }

        // Display end results screen
        if ( guesses == 0 ) {
            System.out.println("\nGame ended early.\nPress ENTER key to proceed. ");
        } else {
            System.out.println("RESULTS\n" + guesses + " total questions\n" + corrects + " correct answers\n" + ((corrects * 100) / guesses) + "% correct\n\nPress ENTER key to proceed. ");
        }
        
        // Save missed equations to console
        SaveLoad.UpdateOptions(Equation.GetTopBound(), Equation.GetBottomBound(), missedEquations);

        // Await ENTER to return to menu
        scanner.nextLine();

        // Clear the console for menu display
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static boolean IsMissedEmpty() {
        if ( missedEquations.size() == 0 ) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Equation> ReturnMissedEquations()
    {
        return missedEquations;
    }

    public static void AddToMissedEquations(Equation equation)
    {
        missedEquations.add(equation);
    }

    public static void ResetMissedEquations()
    {
        missedEquations.clear();
    }
}