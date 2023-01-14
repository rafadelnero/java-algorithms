package fundamentals.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeDeleteFirstAndLast {
  public static void main(String[] args) {
    Deque<String> xmenQueue = new LinkedList<>();
    xmenQueue.add("Wolverine");
    xmenQueue.add("Cyclops");
    xmenQueue.add("Xavier");

    System.out.println("Removing first: " + xmenQueue.removeFirst());
    System.out.println("Removing last: " + xmenQueue.removeLast());

    showAndRemoveQueueElements(xmenQueue);
  }

  private static void showAndRemoveQueueElements(Deque<String> peopleQueue) {
    var queueSize = peopleQueue.size();
    for (int i = 0; i < queueSize; i++) {
      System.out.print(peopleQueue.poll() + " ");
    }
  }
}
