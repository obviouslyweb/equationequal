import java.util.Scanner;

public class Main {

    // Attribute declaration
    static boolean menuActive = true;

    // Module declaration

    public static void main(String[] args)
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner scanner = new Scanner(System.in);

        while ( menuActive )
        {
            Menu.DisplayMenu(); // Display menu
            int userInput = InputHandler.ObtainIntInput(scanner, 1);
            
            if ( 0 == userInput ) {
                menuActive = false;
            } else if ( 1 == userInput ) {
                Guesser.GameLoop(scanner); 
            } else if ( 2 == userInput ) {
                Settings(scanner);
            } else if ( 10 == userInput ) {
                Equation demo_equation = new Equation();
                demo_equation.DisplayEquation(true);;
            } else {
                System.out.println("Unacceptable input; please try again.");
            }
        }
        scanner.close();
    }

    public static void Settings(Scanner scanner)
    {
        while ( true ) {

            Menu.DisplaySettings();
            int userInput = InputHandler.ObtainIntInput(scanner, 1);

            if ( 0 == userInput ) {
                break;
            } else {
                if ( 1 == userInput ) {
                    Guesser.SetBounds(scanner);
                }   
            }
        }
    }

}