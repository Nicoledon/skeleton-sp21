package deque;

import org.junit.Test;

import java.util.Comparator;

public class MaxArrayTest {
    @Test
    public void testq() {
        co<Integer> compare = new co();
        MaxArrayDeque<Integer> Deque = new MaxArrayDeque<>(compare);
        Deque.addFirst(4);
        Deque.addFirst(3);
        Deque.addFirst(2);
        Deque.addFirst(1);
        System.out.print(Deque.max(compare));
    }

    public class co<T> implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            return (int) o1 - (int) o2;
        }
    }
}