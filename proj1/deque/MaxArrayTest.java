package deque;

import org.junit.Test;

import javax.print.DocFlavor;
import java.util.Comparator;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
public class MaxArrayTest {
    public class co<T> implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            return (int) o1 -(int) o2;
        }
    }
    @Test
    public void testq(){
        co <Integer>compare = new co();
        MaxArrayDeque<Integer> Deque = new MaxArrayDeque<>(compare);
        Deque.addFirst(1);
        Deque.addFirst(2);
        Deque.addFirst(3);
        Deque.addFirst(4);
        System.out.print(Deque.max());
    }
}