package fundamentals.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;

public class HashCollisionInPractice {

  public static void main(String[] args) {
    collisionTest();
    noCollisionTest();
    collisionWithBalancedTreeTest();
  }

  private static void collisionTest() {
    Map<CollisionBean, Integer> collisionMap = new HashMap<>();
    var startTime = System.currentTimeMillis();
    // O(n ^ 2)
    for (int i = 0; i < 10000; i++) {
      collisionMap.put(new CollisionBean(i), i);
      collisionMap.get(i);
    }

    var endTime = System.currentTimeMillis() - startTime;
    System.out.println("O(n ^ 2) with collision: " + endTime);
  }

  private static void collisionWithBalancedTreeTest() {
    Map<CollisionComparableBean, Integer> collisionMap = new HashMap<>();
    var startTime = System.currentTimeMillis();
    // O(n)
    for (int i = 0; i < 10000; i++) {
      collisionMap.put(new CollisionComparableBean(i), i);
      // O(log n)
      collisionMap.get(i);
    }

    var endTime = System.currentTimeMillis() - startTime;
    System.out.println("O(n) with collision and a balanced tree: " + endTime);
  }


  private static void noCollisionTest() {
    Map<NoCollisionBean, Integer> noCollisionMap = new HashMap<>();
    var startTime = System.currentTimeMillis();
    // O(n)
    for (int i = 0; i < 10000; i++) {
      noCollisionMap.put(new NoCollisionBean(i), i);
      noCollisionMap.get(i);
    }

    var endTime = System.currentTimeMillis() - startTime;
    System.out.println("O(n) without collision: " + endTime);
  }

  static class CollisionBean {
    private Integer value;

    public CollisionBean(Integer value) {
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      CollisionBean that = (CollisionBean) o;
      return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
      return 1; // Always the same hash code forcing a hash collision
    }

  }

  static class CollisionComparableBean
      implements Comparable<CollisionComparableBean>{
    private Integer value;

    public CollisionComparableBean(Integer value) {
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      CollisionComparableBean that = (CollisionComparableBean) o;
      return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
      return 1; // Always the same hash code forcing a hash collision
    }

    @Override
    public int compareTo(CollisionComparableBean o) {
      return this.value.compareTo(o.value);
    }
  }

  static class NoCollisionBean {
    private Integer value;

    public NoCollisionBean(Integer value) {
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      CollisionBean that = (CollisionBean) o;
      return Objects.equals(value, that.value);
    }
    @Override
    public int hashCode() {
      return value; // Different hash code, no hash collision
    }
  }
}
