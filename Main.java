import java.util.Random;
import java.util.Scanner;

public class Main {

    // Attribute declaration
    static boolean menuActive = true;

    // Module declaration

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        while ( menuActive )
        {
            Menu.DisplayMenu(); // Display menu
            String userInput = scanner.nextLine(); // Obtain user input
            
            if ( 1 == Integer.parseInt(userInput) ) {
                GameLoop(scanner);  
            } else {
                System.out.println("Incorrect");
            }
        }
        scanner.close();
    }

    public static void GameLoop(Scanner scanner)
    {
        Random rand_1 = new Random(); // Random object creator
        boolean GameActive = true; // Game loop boolean
        int number = rand_1.nextInt(3); // Generate guessing number
        int guesses = 0; // Guess counter

        System.out.println("A random number between 0 and 2 has been chosen.");

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

        System.out.println("You got it! It took you " + guesses + " guesses to find the answer.");

    }

    // Likely more here eventually

}