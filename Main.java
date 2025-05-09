import java.util.Scanner;

public class Main {

    static boolean menuActive = true;

    public static void main(String[] args)
    {
        // Clear console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Using SaveLoad, reads the contents in "options.txt" and updates options accordingly
        SaveLoad.ReadOptions();

        // Creates a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // MAIN MENU LOOP
        while ( menuActive )
        {
            // Display menu
            Menu.DisplayMenu();
            // Create an int called userInput used for menu evaluation.
            // If the input cannot be converted to an int, InputHandler stops evaluation
            int userInput = InputHandler.ObtainIntInput(scanner, 1); 
            
            if ( 0 == userInput ) { // Quit program
                menuActive = false;
            } else if ( 1 == userInput ) { // Start game
                Guesser.GameLoop(scanner, false); 
            } else if ( 2 == userInput ) { // Play missed questions
                if ( Guesser.IsMissedEmpty() == true ){ // If none exist...
                    System.out.println("There are no missed equations yet!");
                } else { // If they do exist
                    Guesser.GameLoop(scanner, true);
                }
            } else if ( 3 == userInput ) { // Go to settings menu
                    Settings(scanner);
            } else if ( 10 == userInput ) { // Test equation display mode (DEBUG)
                Equation demo_equation = new Equation();
                demo_equation.DisplayEquation(false);;
            } else {
                System.out.println("Unacceptable input; please try again.");
            }
        }
        // At the closure of the program, end the scanner object
        scanner.close();
    }

    public static void Settings(Scanner scanner)
    {
        while ( true ) { // While in the settings menu

            // Display settings, obtain user input
            Menu.DisplaySettings();
            int userInput = InputHandler.ObtainIntInput(scanner, 1);

            if ( 0 == userInput ) { // Return to main menu
                break;
            } else {
                if ( 1 == userInput ) { // Set new bounds using SetBounds function, save bounds to file
                    Equation.SetBounds(scanner);
                    SaveLoad.UpdateOptions(Equation.GetTopBound(), Equation.GetBottomBound(), Guesser.ReturnMissedEquations());
                } else if ( 2 == userInput ) { // Clear missed equations, save empty array to file
                    Guesser.ResetMissedEquations();
                    SaveLoad.UpdateOptions(Equation.GetTopBound(), Equation.GetBottomBound(), Guesser.ReturnMissedEquations());
                    System.out.println("Missed equations deleted.");
                }
            }
        }
    }
}