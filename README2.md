# Unit 1 - Assignment 3: Linked Stack

## Overview
In this assignment, you will implement a **Stack** Abstract Data Type (ADT) using a singly linked structure (`LLNode<T>`) instead of a dynamically resizing array. Your `LinkedStack<T>` class must satisfy `StackInterface<T>` and pass all unit tests in `LinkedStackTest`.

Unlike `ArrayStack<T>`, a linked stack does not require dynamic capacity checks or array resizing (`checkSize()`). Memory for each element is dynamically allocated on the heap inside an `LLNode<T>` object as items are pushed onto the stack.

---

## Working with `LLNode<T>`

Your stack uses the provided `LLNode<T>` generic node class. The front/head of your linked list represents the **top** of the stack.

Available `LLNode<T>` methods:
* `T getInfo()` — Returns the data stored in the node.
* `LLNode<T> getLink()` — Returns the reference to the next node in the sequence.
* `void setInfo(T info)` — Updates the data stored in the node.
* `void setLink(LLNode<T> link)` — Points the node's link reference to another node.

---

## Instance Variables

Your `LinkedStack<T>` class maintains two private fields:
* `private LLNode<T> top` — Points to the top node of the stack (`null` when empty).
* `private int size` — Tracks the logical number of elements currently stored.

---

## Method Implementation Details

You must complete the following methods inside `LinkedStack.java`:

| Method | Return Type | Description / Requirements |
| :--- | :--- | :--- |
| **`LinkedStack()`** | Constructor | Initializes `top` to `null` and `size` to `0`. |
| **`size()`** | `int` | Returns the logical size (number of elements currently stored). |
| **`empty()`** | `boolean` | Returns `true` if `size == 0`, `false` otherwise. |
| **`peek()`** | `T` | Returns the data stored in the `top` node without removing it. **Must throw `StackUnderflowException`** if the stack is empty (`size < 1`). |
| **`pop()`** | `T` | Removes and returns the data from the `top` node. Updates `top` to point to `top.getLink()`, decrements `size`, and returns the element. **Must throw `StackUnderflowException`** if the stack is empty (`size < 1`). |
| **`push(T item)`** | `T` | Creates a new `LLNode<T>`, sets its link to the current `top`, updates `top` to point to the new node, increments `size`, and returns `item`. |
| **`clear()`** | `void` | Resets `top` to `null` and `size` to `0`. |
| **`search(Object o)`** | `int` | Returns the 1-based position of object `o` relative to `top` (1 = top node). Returns `-1` if not found. Uses `.equals()` for comparisons. **Leaves the stack state unchanged.** |

---

## 1-Based Search Position Logic

Traversal begins at `top` (position 1) and steps through node links downward:

```text
[ top ]    --> Node 1 (Position 1)
               │
               ▼
               Node 2 (Position 2)
               │
               ▼
               Node 3 (Position 3) --> null
```

* The `top` node is always position `1`.
* Traversal checks each node using `curr.getInfo().equals(o)`.
* Return `-1` if the target object is not present in the stack.
* Searching must inspect nodes sequentially without modifying any links or removing elements.

---

## Testing Your Implementation

Run `LinkedStackTest.java` in VS Code to execute the unit test suite. The tester verifies:

1. **Interface Compliance:** Confirms `StackInterface<T>` signatures are properly implemented.
2. **Exception Handling:** Verifies `StackUnderflowException` is thrown when calling `pop()` or `peek()` on an empty stack.
3. **Node Pointer Operations:** Ensures `push()` and `pop()` correctly update `top` references and node links without losing elements.
4. **Search Accuracy:** Checks 1-based indexing accuracy from `top` downward and ensures pointer integrity remains intact after searching.
