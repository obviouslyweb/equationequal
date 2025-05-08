import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Equation {

    // Attribute declaration
    private int firstnum; // 0-10
    private String operator; // +, -, *, /
    private int secondnum; // 0-10
    private int hiddennum; // 0-2, 3 for operator
    private static int topbound = 10;
    private static int bottombound = 0;
    
    // Constructor declaration
    public Equation() {
        firstnum = ThreadLocalRandom.current().nextInt(topbound + 1) - bottombound;
        secondnum = ThreadLocalRandom.current().nextInt(topbound + 1) - bottombound;
        int operatorcheck = ThreadLocalRandom.current().nextInt(4);
        if ( operatorcheck == 0 ) {
            operator = "+";
        } else if ( operatorcheck == 1 ) {
            operator = "-";
        } else if ( operatorcheck == 2 ) {
            operator = "*";
        } else if ( operatorcheck == 3 ) {
            operator = "/";
        }

        // Divide by 0 handler
        if ( ( secondnum == 0 ) && ( operator == "/" )) {
            secondnum = 1;
        }
        hiddennum = ThreadLocalRandom.current().nextInt(3);

        FixAmbiguousOperation();
    }

    // Module declaration
    private void FixAmbiguousOperation() {
        if (operator.equals("*") && (firstnum * secondnum == 0)) {
            if ((hiddennum == 0 && secondnum == 0) || (hiddennum == 1 && firstnum == 0) ) {
                hiddennum = 2;
            }
        } else if (operator.equals("/") && (firstnum / secondnum == 0)) {
            if ((hiddennum == 0 && secondnum == 0) || (hiddennum == 1 && firstnum == 0) ) {
                hiddennum = 2;
                System.out.println("Division fix triggered");
            }
        }
    }
    
    public void DisplayEquation(boolean hideHidden) {
        if ( hideHidden ) {
            String first = (hiddennum == 0) ? "[_]" : String.valueOf(firstnum);
            String middle = (hiddennum == 3) ? "[_]" : operator;
            String second = (hiddennum == 1) ? "[_]" : String.valueOf(secondnum);
            String result;

            if (operator.equals("+")) {
                result = String.valueOf(firstnum + secondnum);
            } else if (operator.equals("-")) {
                result = String.valueOf(firstnum - secondnum);
            } else if (operator.equals("*")) {
                result = String.valueOf(firstnum * secondnum);
            } else if (operator.equals("/")) {
                if ( secondnum == 0 ) {
                    secondnum = 1;
                }
                result = String.valueOf(firstnum / secondnum);
            } else {
                System.out.print("This is an error: the operator could not be handled. Please notify me if you see this!");
                return;
            }

            if (hiddennum == 2) {
                result = "[_]";
            }

            System.out.print(first + " " + middle + " " + second + " = " + result);
        } else {
            String first = (hiddennum == 0) ? "[" + firstnum + "]" : String.valueOf(firstnum);
            String middle = (hiddennum == 3) ? "[" + operator + "]" : operator;
            String second = (hiddennum == 1) ? "[" + secondnum + "]" : String.valueOf(secondnum);
            String result;

            if (operator.equals("+")) {
                result = String.valueOf(firstnum + secondnum);
            } else if (operator.equals("-")) {
                result = String.valueOf(firstnum - secondnum);
            } else if (operator.equals("*")) {
                result = String.valueOf(firstnum * secondnum);
            } else if (operator.equals("/")) {
                if ( secondnum == 0 ) {
                    secondnum = 1;
                }
                result = String.valueOf(firstnum / secondnum);
            } else {
                System.out.print("This is an error: the operator could not be handled. Please notify me if you see this!");
                return;
            }

            if (hiddennum == 2) {
                result = "[" + result + "]";
            }

            System.out.print(first + " " + middle + " " + second + " = " + result);
        }
    }

    public boolean EvaluateEquation(int answer) {
        if (answer == ReturnEvaluation()) {
            return true;
        } else {
            return false;
        }
    }

    public int ReturnEvaluation() {
        try {
            switch (hiddennum) {
                case 0: // First number is hidden, [] + 5 = 7
                    if (operator.equals("+")) 
                        return Integer.parseInt(String.valueOf(result() - secondnum));
                    if (operator.equals("-"))
                        return Integer.parseInt(String.valueOf(result() + secondnum));
                    if (operator.equals("*"))
                        return Integer.parseInt(String.valueOf(result() / secondnum));
                    if (operator.equals("/"))
                        return Integer.parseInt(String.valueOf(result() * secondnum));
                    break;
                case 1: // Second number is hidden, 2 + [] = 7
                    if (operator.equals("+")) 
                        return Integer.parseInt(String.valueOf(result() - firstnum));
                    if (operator.equals("-"))
                        return Integer.parseInt(String.valueOf(firstnum - result()));
                    if (operator.equals("*"))
                        return Integer.parseInt(String.valueOf(result() / firstnum));
                    if (operator.equals("/"))
                        return Integer.parseInt(String.valueOf(firstnum / result()));
                    break;
                case 2: // Result number is hidden, 2 + 5 = []
                    return result();
                case 3: // Operator is hidden, 2 [] 5 = 7
                    return -1;
                    // Functionality coming soon; shouldn't be called in current version anyway
            }
        } catch (ArithmeticException e) {
            System.out.println("Math error during evaluation.");
            return -1;
        }
        System.out.println("Unknown operator or hiddennum state.");
        return -1;
    }

    private int result() {
        if (operator.equals("+")) return firstnum + secondnum;
        if (operator.equals("-")) return firstnum - secondnum;
        if (operator.equals("*")) return firstnum * secondnum;
        if (operator.equals("/")) return firstnum / secondnum;
        return -1;
    }

    public static void SetBounds(Scanner scanner) {
        System.out.print("\nPlease type the bottom bound (i.e. numbers from __ to 10): ");
        int BottomBoundPotential = InputHandler.ObtainIntInput(scanner, 0);
        System.out.print("Please type the top bound (i.e. numbers from 1 to __): ");
        int TopBoundPotential = InputHandler.ObtainIntInput(scanner, 0);
        if ( BottomBoundPotential >= TopBoundPotential ) {
            System.out.println("\nERROR: Unable to set bounds! " + bottombound + " is larger (or equal to) " + topbound + ".\nPlease try again with a bottom bound that is LOWER than the top bound.\n");
        } else {
            bottombound = BottomBoundPotential;
            topbound = TopBoundPotential;
            SaveLoad.UpdateOptions(TopBoundPotential, BottomBoundPotential, Guesser.ReturnMissedEquations());
            System.out.println("Random number generator bounds set to " + bottombound + " and " + topbound + ".");
        }
    }

    public static void SetTopBound(int number) {
        topbound = number;
    }

    public static void SetBottomBound(int number) {
        bottombound = number;
    }

    public static int GetTopBound() {
        return topbound;
    }

    public static int GetBottomBound() {
        return bottombound;
    }

    public String SerializeEquation() {
        return firstnum + "," + operator + "," + secondnum + "," + hiddennum;
    }

    public static Equation DeserializeEquation(String data) {
        String[] parts = data.split(",");
        int firstnum = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int secondnum = Integer.parseInt(parts[2]);
        int hiddennum = Integer.parseInt(parts[3]);
    
        Equation equation = new Equation();
        equation.firstnum = firstnum;
        equation.operator = operator;
        equation.secondnum = secondnum;
        equation.hiddennum = hiddennum;
        return equation;
    }
}