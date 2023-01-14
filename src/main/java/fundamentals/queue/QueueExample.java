package fundamentals.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

  public static void main(String[] args) {
    Queue<String> peopleQueue = new LinkedList<>();
    peopleQueue.add("Wolverine"); // First in & first out
    peopleQueue.add("Juggernaut");
    peopleQueue.add("Xavier");
    peopleQueue.add("Beast");     // Last in & last out

    var queueSize = peopleQueue.size();
    for (int i = 0; i < queueSize; i++) {
      System.out.print(peopleQueue.poll() + " ");
    }
  }

}
