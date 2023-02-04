package fundamentals.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayExample {

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5};
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }

    List list = new ArrayList<>();
    int[] test = {};
    System.out.println(test.length);
  }

}
