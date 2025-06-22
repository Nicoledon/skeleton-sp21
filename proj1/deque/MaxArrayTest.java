package deque;

import org.junit.Test;

import java.util.Comparator;

public class MaxArrayTest {

    @Test
    public void testq() {
        Co<Integer> compare = new Co<>();
        MaxArrayDeque<Integer> deque = new MaxArrayDeque<>(compare);
        deque.addFirst(4);
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        System.out.print(deque.max(compare));
    }

    public static class Co<T extends Comparable<T>> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
        }
    }
}
