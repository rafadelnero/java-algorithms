package fundamentals.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeAlternativeMethods {

  public static void main(String[] args) {
    Deque<Integer> stack = new ArrayDeque<>();
    stack.addLast(1);
    stack.addLast(2);

    System.out.println(stack.getLast());
    stack.removeLast();

    System.out.println(stack);
  }
}
