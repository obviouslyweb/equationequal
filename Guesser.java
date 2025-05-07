import java.util.ArrayList;
import java.util.Scanner;

public class Guesser {

    static ArrayList<Equation> missedEquations = new ArrayList<Equation>();

    public static void GameLoop(Scanner scanner, boolean missedMode)
    {
        System.out.println("\nType the missing number for the answer for the given equations.\nType 'end' to end the game.\n");

        boolean GameActive = true;
        int guesses = 0;
        int corrects = 0;

        while ( GameActive ) { // While game is active...
            
            Equation question = new Equation();
            
            if ( missedMode )
            {
                question = missedEquations.get(0);
            }

            question.DisplayEquation(true);

            System.out.println();
            String userInput = InputHandler.ObtainGameInput(scanner);
                
            if ( userInput.equalsIgnoreCase("end") ) {
                GameActive = false;
            } else if ( question.EvaluateEquation(Integer.parseInt(userInput)) ) {
                guesses++;
                corrects++;
                System.out.println("Correct!\n");
                if ( missedMode )
                {
                    question = missedEquations.remove(0);
                    if ( IsMissedEmpty() == true ) {
                        GameActive = false;
                        System.out.println("All missed questions solved!");
                    }
                }
            } else {
                System.out.println("Incorrect; correct answer was " + question.ReturnEvaluation() + "\n");
                guesses++;
                if ( !missedMode )
                {
                    missedEquations.add(question);
                }

            }
        }
        // END RESULTS
        if ( guesses == 0 ) {
            System.out.println("\nGame ended early.\nPress ENTER key to proceed. ");
        } else {
            System.out.println("RESULTS\n" + guesses + " total questions\n" + corrects + " correct answers\n" + ((corrects * 100) / guesses) + "% correct\n\nPress ENTER key to proceed. ");
        }
        
        SaveLoad.UpdateOptions(Equation.GetTopBound(), Equation.GetBottomBound(), missedEquations);
        scanner.nextLine();
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