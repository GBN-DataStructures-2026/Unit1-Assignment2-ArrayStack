import java.util.Scanner;

/**
 * Evaluates space-delimited postfix expressions using a custom Stack ADT.
 */
public class PostfixEvaluator {

    /**
     * Evaluates a valid space-delimited postfix expression.
     * 
     * @param expression The postfix string containing integer operands and operators.
     * @return The integer result of the evaluation.
     * @throws PostfixException if the expression is malformed or invalid.
     */
    public static int evaluate(String expression) throws PostfixException {
        // TODO: Declare and instantiate your custom stack implementation (LinkedStack or ArrayStack)
        
        
        Scanner tokens = new Scanner(expression);

        // TODO: Implement postfix evaluation

        // TODO: Verify final stack state (must have exactly one value remaining)
      
        return 0;
    }
}
