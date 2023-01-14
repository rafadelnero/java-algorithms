package fundamentals.queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeAddFirstAndLast {
  public static void main(String[] args) {
    Deque<String> xmenQueue = new LinkedList<>();
    xmenQueue.add("Wolverine");
    xmenQueue.addFirst("Cyclops");
    xmenQueue.addLast("Xavier");

    showAndRemoveQueueElements(xmenQueue);
  }

  private static void showAndRemoveQueueElements(Deque<String> peopleQueue) {
    var queueSize = peopleQueue.size();
    for (int i = 0; i < queueSize; i++) {
      System.out.print(peopleQueue.poll() + " ");
    }
  }
}
