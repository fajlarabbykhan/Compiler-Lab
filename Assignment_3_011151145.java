import java.util.Scanner;
import java.util.Stack;

public class Assignment_3_011151145 {

    // checking character is an operand
    public static boolean isOperand(char c) {
        return Character.isDigit(c);
    }

    // arithmetic operation on two operands
    public static int operate(int a, int b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                return 0;
        }
    }

    // prefix method
    public static int evaluatePrefix(String expr) {
        
        Stack<Integer> stack = new Stack<>();

        // right to left
        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);

            // If  operand, push it to the stack
            if (isOperand(c)) {
                stack.push(c - '0');
            }
            // If an operator, pop two operands from the stack
            // push the result back to the stack
            else {
                int a = stack.pop();
                int b = stack.pop();
                int result = operate(a, b, c);
                stack.push(result);
            }
        }

        // final result 
        return stack.peek();
    }

    // postfix method
    public static int evaluatePostfix(String expr) {
        Stack<Integer> stack = new Stack<>();

        // left to right
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            // If operand, push it to the stack
            if (isOperand(c)) {
                stack.push(c - '0');
            }
            // If an operator, pop two operands from the stack
            // push the result back to the stack
            else {
                int b = stack.pop();
                int a = stack.pop();
                int result = operate(a, b, c);
                stack.push(result);
            }
        }

       //final result 
        return stack.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // An infinite loop
        while (true) {
     
            System.out.println("Type PRE for Prefix Evaluation");
            System.out.println("Type POST for Postfix Evaluation");
            System.out.println("Type EXIT for  Exit from the program");

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("PRE")) {
                System.out.println("Enter a prefix expression:");
                String expr = scanner.nextLine();
                
                // Evaluate prefix
                int result = evaluatePrefix(expr);
                System.out.println("The result of the prefix evaluation is: " + result);
            }
            else if (choice.equalsIgnoreCase("POST")) {
                System.out.println("Enter a valid postfix expression:");

                String expr = scanner.nextLine();
                
                // Evaluate postfix
                int result = evaluatePostfix(expr);
                System.out.println("The result of the postfix evaluation is: " + result);
            }
            else if (choice.equalsIgnoreCase("EXIT")) {
                // Break the loop and end the program
                System.out.println("You Exit from the program.");
                break;
            }
            else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
