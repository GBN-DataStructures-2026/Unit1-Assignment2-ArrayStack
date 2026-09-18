# Unit 1 - Assignment 4: Infix to Postfix Converter

## Overview
In this assignment, you will implement an **Infix to Postfix Converter** using your custom Stack implementation (`StackInterface<Character>`). Converting arithmetic expressions from infix notation (e.g., `A + B * C`) to postfix/Reverse Polish Notation (e.g., `A B C * +`) eliminates the need for parentheses and operator precedence rules during evaluation.

Your task is to complete the `InfixToPostfix.java` utility class so that it passes all automated unit tests in `InfixToPostfixTest.java`.

---

## Preconditions & Constraints

To simplify parsing, you may assume the following **preconditions** for all input strings:

* **Balanced Parentheses:** All input expressions are guaranteed to have perfectly balanced parentheses. You do **not** need to validate or check for mismatched parentheses.
* **Grouping Symbols:** Parentheses `(` and `)` are the **only** grouping symbols used. Brackets `[` `]` and braces `{` `}` will not appear in test expressions.
* **Explicit Multiplication Required:** Implied multiplication is **not** supported. Operations like `2(A + B)` or `(A)(B)` are invalid inputs. All multiplication operations must use an explicit `*` operator (e.g., `2 * (A + B)` or `A * B`).
* **Single-Character Tokens:** Operands consist of single characters (letters or digits).
* **Whitespace Handling:** Expressions may contain spaces or tabs, which must be ignored during processing.

---

## Operator Precedence & Associativity

Your implementation must support six arithmetic operators and handle them according to standard precedence rules:

| Operator | Precedence Level | Description | Associativity |
| :---: | :---: | :--- | :---: |
| `^` | **3** (Highest) | Exponentiation | Right-to-Left |
| `*`, `/`, `%` | **2** | Multiplication, Division, Modulo | Left-to-Right |
| `+`, `-` | **1** (Lowest) | Addition, Subtraction | Left-to-Right |
| `(` | **0** | Open Parentheses (inside stack) | N/A |

### Stack Comparison Rules:
* **Left-Associative Operators (`+`, `-`, `*`, `/`, `%`):** Pop operators off the stack while `precedence(stack.peek()) >= precedence(currentSymbol)`.
* **Right-Associative Operators (`^`):** Pop operators off the stack only while `precedence(stack.peek()) > precedence(currentSymbol)`.

---

## Algorithm Summary

1. Initialize an instance of your custom stack: `StackInterface<Character> stack = new LinkedStack<Character>();` (or `ArrayStack<Character>`).
2. Traverse the input string character by character:
   * **Whitespace (` ' ' `, ` '\t' `):** Skip and continue.
   * **Operand (Letters / Digits):** Append directly to the output.
   * **Open Parenthesis `(`:** Push onto the stack.
   * **Close Parenthesis `)`:** Pop items off the stack and append to output until an open parenthesis `(` is popped. Discard the `(`.
   * **Operator (`+`, `-`, `*`, `/`, `%`, `^`):** Compare precedence against `stack.peek()`. Pop higher/equal precedence operators to output based on associativity rules, then push the current operator.
3. Once the end of the input string is reached, pop all remaining operators off the stack and append them to the output.

---

## Method Implementation Details

Implement the following methods in `InfixToPostfix.java`:

| Method | Return Type | Description / Requirements |
| :--- | :--- | :--- |
| `convertToPostfix(String infix)` | `String` | Converts an infix expression into a space-delimited postfix string. Returns the result. |
| `precedence(char symbol)` | `int` | Helper method returning the integer precedence rank (`0` to `3`) for a given character. |

---

## Testing Your Implementation

Run `InfixToPostfixTest.java` in VS Code to run the test suite. The tests verify:

1. **Basic Expressions:** Tests simple single-operator expressions (e.g., `A + B` $\rightarrow$ `A B +`).
2. **Precedence Hierarchy:** Verifies order of operations without parentheses (e.g., `A + B * C` $\rightarrow$ `A B C * +`).
3. **Parentheses Overrides:** Verifies sub-expression grouping (e.g., `(A + B) * C` $\rightarrow$ `A B + C *`).
4. **Exponentiation & Associativity:** Tests right-associativity of `^` (e.g., `A ^ B ^ C` $\rightarrow$ `A B C ^ ^`).
5. **Whitespace Independence:** Confirms correct output regardless of input spacing.
