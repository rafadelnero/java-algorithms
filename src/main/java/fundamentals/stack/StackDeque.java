package fundamentals.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackDeque {
  public static void main(String[] args) {
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(1);  // Inserts element at the first position
    stack.push(2);

    System.out.println(stack); // LIFO insertion
    System.out.println(stack.peek()); // Shows first element
    System.out.println(stack.pop());  // Remove and return first element
  }
}
