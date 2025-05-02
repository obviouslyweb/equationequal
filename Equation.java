import java.util.concurrent.ThreadLocalRandom;

public class Equation {

    // Attribute declaration
    private int firstnum = 1;
    private String operator;
    private int secondnum = 1;
    private int hiddennum = 0; // 0-2, 3 for operator
    
    // Constructor declaration
    public Equation() {
        firstnum = ThreadLocalRandom.current().nextInt(10);
        secondnum = ThreadLocalRandom.current().nextInt(10);
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
        hiddennum = ThreadLocalRandom.current().nextInt(2);
    }
    
    // Module declaration
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
                result = String.valueOf(firstnum / secondnum);
            } else {
                System.out.print("This is an error: the operator could not be handled. Please notify me if you see this!");
                return;
            }

            if (hiddennum == 2) {
                result = "[#" + result + "]";
            }

            System.out.print(first + " " + middle + " " + second + " = " + result);
        }
    }

    public boolean EvaluateEquation(int answer) {
        if ( hiddennum == 0 ) {
            return ( answer == firstnum );
        } else if ( hiddennum == 1 ) {
            return ( answer == secondnum );
        } else if ( hiddennum == 2 ) {
            if (operator.equals("+")) {
                return (answer == firstnum + secondnum);
            } else if (operator.equals("-")) {
                return (answer == firstnum - secondnum);
            } else if (operator.equals("*")) {
                return (answer == firstnum * secondnum);
            } else if (operator.equals("/")) {
                return (answer == firstnum / secondnum);
            } else {
                System.out.print("This is an error: the equation evaluator could not compute (1). Please notify me if you see this!");
                return true;
            }
        } else if ( hiddennum == 3 ) {
            return ( answer == firstnum );
        } else {
            System.out.print("This is an error: the equation evaluator could not compute (2). Please notify me if you see this!");
            return true;
        }
    }
}