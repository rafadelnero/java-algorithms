package algoexpert.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class NthFibonacci {

    public static int getNthFibRecursive(int n) {
       if (n == 2) {
           return 1;
       } else if (n == 1) {
           return 0;
       } else {
           return getNthFibRecursive(n - 1) + getNthFibRecursive(n - 2);
       }
    }

    public static int getNthFibMemoize(int n) {
        Map<Integer, Integer> memoize = new HashMap<>();
        memoize.put(1, 0);
        memoize.put(2, 1);
        return getNthFibMemoize(n, memoize);
    }

    public static int getNthFibMemoize(int n, Map<Integer, Integer> memoize) {
        if (memoize.containsKey(n)) {
            return memoize.get(n);
        } else {
            memoize.put(n, getNthFibMemoize(n - 1, memoize) + getNthFibMemoize(n - 2, memoize));
            return memoize.get(n);
        }
    }

    public static int getNthFibIterative(int n) {
        int[] fib = new int[]{0, 1};
        int counter = 3;

        while (counter <= n) {
            var nextFib = fib[0] + fib[1];
            fib[0] = fib[1];
            fib[1] = nextFib;
            counter++;
        }

        return n > 1 ? fib[1] : fib[0];
    }

    @Test
    public void TestCase1() {
        System.out.println(getNthFibMemoize(13));
    }
}
