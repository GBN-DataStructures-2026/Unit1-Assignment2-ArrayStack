# Unit 1 - Assignment 5: Postfix Evaluator

## Overview
In this assignment, you will implement an arithmetic **Postfix Evaluator** using your custom Stack implementation (`StackInterface<Integer>`). In postfix notation (Reverse Polish Notation), operators follow their operands, eliminating the need for parentheses and precedence rules during evaluation.

Your task is to complete the `PostfixEvaluator.java` class so that it passes all automated unit tests in `PostfixEvaluatorTest.java`.

---

## Preconditions & Parsing Rules

* **Space-Delimited Tokens:** Expressions consist of integer operands and operator symbols separated by whitespace. Use Java's `Scanner(expression)` with `.hasNextInt()` and `.nextInt()` to parse tokens.
* **Operand Type:** Operands are 32-bit integers (`int`), which can be positive, negative, or zero.
* **Custom Stack Container:** You must store operands using your custom stack (`LinkedStack<Integer>` or `ArrayStack<Integer>`). You may **not** use `java.util.Stack`.

---

## Supported Operators

Your evaluator must handle six binary operators:

| Symbol | Operation | Java Evaluation |
| :---: | :--- | :--- |
| `+` | Addition | `operand1 + operand2` |
| `-` | Subtraction | `operand1 - operand2` |
| `*` | Multiplication | `operand1 * operand2` |
| `/` | Division | `operand1 / operand2` |
| `%` | Modulo | `operand1 % operand2` |
| `^` | Exponentiation | `(int) Math.pow(operand1, operand2)` |

> **Crucial Rule for Subtraction, Division, and Exponentiation:**
> Because stack operations invert order, the **first** popped item is `operand2` and the **second** popped item is `operand1`. Always calculate `operand1 <operator> operand2`.

---

## Error Handling & `PostfixException`

Your code must throw a `PostfixException` with an appropriate message whenever an expression violates evaluation rules:

1. **Stack Underflow (Too Few Operands):** Encountering an operator when the stack contains fewer than two operands.
2. **Leftover Operands (Too Many Operands):** Reaching the end of the input string with more than one operand remaining on the stack.
3. **Empty Output:** Reaching the end of processing with an empty stack.
4. **Division or Modulo by Zero:** Attempting `/` or `%` when `operand2 == 0`.
5. **Unrecognized Symbol:** Encountering any token that is neither a valid integer nor one of the six supported operators (`+`, `-`, `*`, `/`, `%`, `^`).

---

## Algorithm Summary

1. Instantiate your custom stack (`StackInterface<Integer> stack = new LinkedStack<Integer>();`).
2. Attach a `Scanner` to the input expression string.
3. While tokens remain:
   * If token is an integer (`tokens.hasNextInt()`), push `tokens.nextInt()` onto the stack.
   * Otherwise, read the operator token (`tokens.next()`).
   * Verify the stack contains at least two operands. Pop `operand2`, then pop `operand1`.
   * Perform the mathematical operation, and push the integer result back onto the stack.
4. After token parsing finishes, pop the final result. If the stack is not empty, throw a `PostfixException`.
5. Return the result.

---

## Testing Your Implementation

Run `PostfixEvaluatorTest.java` in VS Code to execute the test suite. The tests verify:

1. Standard expressions containing mixed arithmetic operations.
2. Negative number handling.
3. Modulo (`%`) and Exponentiation (`^`) evaluation logic.
4. Proper exception throwing for underflow, leftover operands, division/modulo by zero, and invalid symbols.
