package CIS2206.Unit_13.parser;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * A simple parser
 *
 * @author Ilias Tachmazidis
 * @version September 2023
 */
public class SimpleParser {

    static Stack<String> stack1 = new Stack();
    public static void printStack() {
        for (int i = stack1.capacity() - 1; i >= 0; i--) {
            String a = (i < stack1.size()) ? stack1.get(i).toString() : " ";
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
//        String input = "Word 4 5.2 &";
        String input = "4.3 25 + 1.7 2 * - 3.2 /";

        // Separate tokens
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        String token;

        // Process input
        while (tokenizer.hasMoreElements()) {
            token = tokenizer.nextToken();

            try {
                // Check if token is numeric
                Double tmpDouble = Double.parseDouble(token);
                // rule 2 so push
                stack1.push(token);
                System.out.println("Double: " + tmpDouble);
            } catch (NumberFormatException nfe) {
                // rule 1 so push
                stack1.push(token);
                System.out.println("String: " + token);
            }

            // if last 3 operator operand operand
            // rule 3

//            if (stack1.size() > 2) {
//                try {
//                    Double.parseDouble(temp1);
//                    break;
//                } catch (NumberFormatException e) {
//                    stack1.pop();
//                    String temp2 = stack1.peek();
//                    System.out.println("not double");
//                    try {
//                        Double.parseDouble(temp2);
//                        stack1.pop();
//                        String temp3 = stack1.peek();
//                        System.out.println("double");
//                        try {
//                            Double.parseDouble(temp3);
//                            stack1.pop();
//                            System.out.println("double");
//                            if (temp1.equals("+")) {
//                                double result = Double.valueOf(temp2) + Double.valueOf(temp3);
//                                System.out.println("result " + result);
//                                stack1.push(String.valueOf(result));
//                            }
//                            else if (temp1.equals("*")) {
//                                double result = Double.valueOf(temp2) * Double.valueOf(temp3);
//                                System.out.println("result " + result);
//                                stack1.push(String.valueOf(result));
//                            }
//                            else if (temp1.equals("-")) {
//                                double result = Double.valueOf(temp2) - Double.valueOf(temp3);
//                                System.out.println("result " + result);
//                                stack1.push(String.valueOf(result));
//                            }
//                            else if (temp1.equals("/")) {
//                                double result = Double.valueOf(temp2) / Double.valueOf(temp3);
//                                System.out.println("result " + result);
//                                stack1.push(String.valueOf(result));
//                            }
//
//                        } catch (NumberFormatException f) {
//                            stack1.push(temp2);
//                            stack1.push(temp1);
//                        }
//                    } catch (NumberFormatException g) {
//                        stack1.push(temp1);
//                    }
//                }
//                printStack();
//            }
//
//        }
//        printStack();

            // better code


            if (stack1.size() > 2) {
                String temp3 = stack1.pop(); // Operator
                String temp2 = stack1.pop(); // Second operand
                String temp1 = stack1.pop(); // First operand

                try {
                    // Check if the fetched elements are numbers
                    Double.parseDouble(temp1);
                    Double.parseDouble(temp2);

                    // Operations based on the operator
                    switch (temp3) {
                        case "+":
                            double result = Double.parseDouble(temp1) + Double.parseDouble(temp2);
                            // Push the result back to the stack
                            stack1.push(String.valueOf(result));
                            break;
                        case "-":
                            result = Double.parseDouble(temp1) - Double.parseDouble(temp2);
                            // Push the result back to the stack
                            stack1.push(String.valueOf(result));
                            break;
                        case "*":
                            result = Double.parseDouble(temp1) * Double.parseDouble(temp2);
                            // Push the result back to the stack
                            stack1.push(String.valueOf(result));
                            break;
                        case "/":
                            result = Double.parseDouble(temp1) / Double.parseDouble(temp2);
                            // Push the result back to the stack
                            stack1.push(String.valueOf(result));
                            break;
                        default:
                            stack1.push(temp1);
                            stack1.push(temp2);
                            stack1.push(temp3);
                            break;
                    }
                } catch (NumberFormatException e) {
                    // Push back the elements if the elements not numbers
                    stack1.push(temp1);
                    stack1.push(temp2);
                    stack1.push(temp3);
                }
                // Print the stack after each update
                printStack();
            }


        }
    }
}
// make it check symbol try instead, it thinks anything and wont do the second symbol
// check the temps