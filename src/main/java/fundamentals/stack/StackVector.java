package fundamentals.stack;

import java.util.Stack;

public class StackVector {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);

    System.out.println(stack);
    System.out.println(stack.get(0)); // Gets the first element
    System.out.println(stack.peek()); // Shows the last element
  }
}
