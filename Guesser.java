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
            String userInput = scanner.nextLine(); // Obtain user guess
                
            if ( question.EvaluateEquation(Integer.parseInt(userInput)) ) {
                guesses++;
                System.out.println("Correct!\n");
                // GameActive = false;
            } else {
                System.out.println("Incorrect. Try again!");
                guesses++;
            }
        }

        System.out.println("You got it! It took you " + guesses + " guesses to find the answer.\n");

    }

    public static void SetBounds(Scanner scanner) {
        System.out.print("Please type the bottom bound ( i.e. Guess from _ to 10): ");
        int BottomBoundPotential = Integer.parseInt(scanner.nextLine());
        System.out.print("Please type the top bound ( i.e. Guess from 0 to _ ): ");
        int TopBoundPotential = Integer.parseInt(scanner.nextLine());
        if ( BottomBoundPotential >= TopBoundPotential ) {
            System.out.println("ERROR: Unable to set bounds!" + BottomBound + " is larger (or equal to) " + TopBound + ".\nPlease try again with a bottom bound that is LOWER than the top bound.\n");
        } else {
            BottomBound = BottomBoundPotential;
            TopBound = TopBoundPotential;
            System.out.println("Random number generator bounds set to " + BottomBound + " and " + TopBound + ".\n");
        }
    }
}

// OLD CODE BELOW, DO NOT USE

// public static void GameLoop(Scanner scanner)
//     {
//         boolean GameActive = true; // Game loop boolean
//         int number = ThreadLocalRandom.current().nextInt(BottomBound, TopBound + 1);
//         int guesses = 0; // Guess counter

//         System.out.println("A random number between " + BottomBound + " and " + TopBound + " has been chosen.");

//         while ( GameActive ) { // While game is active...

//             // System.out.println(number);
//             System.out.print("Guess a number: ");
//             String userInput = scanner.nextLine(); // Obtain user guess
                
//             if ( number == Integer.parseInt(userInput) ) {
//                 guesses++;
//                 GameActive = false;
//             } else {
//                 if ( number > Integer.parseInt(userInput)) {
//                     System.out.println("Higher!");
//                 } else {
//                     System.out.println("Lower!");
//                 }   
//                 guesses++;
//             }
//         }

//         System.out.println("You got it! It took you " + guesses + " guesses to find the answer.\n");

//     }