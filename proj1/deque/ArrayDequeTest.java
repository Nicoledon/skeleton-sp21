package deque;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ArrayDequeTest {
    @Test
    public void addIsEmptySizeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();
    }
    @Test
    public void addRemoveTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }
    @Test
    public void removeEmptyTest() {
        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }
    @Test
    public void sildeTest() {
     ArrayDeque<String> lld1 = new ArrayDeque<>();
    lld1.addLast("a");
    lld1.addLast("b");
     lld1.addFirst("c");
     lld1.addLast("d");
     lld1.addLast("e");
     lld1.addFirst("f");
     lld1.addLast("g");
     lld1.addLast("h");
    lld1.addLast("Z");
     /*  assertEquals(lld1.removeFirst(),"f");
       assertEquals(lld1.removeFirst(),"c");
      assertEquals(lld1.removeFirst(),"a");
        assertEquals(lld1.removeFirst(),"b");
        assertEquals(lld1.removeFirst(),"d");
        assertEquals(lld1.removeFirst(),"e");
        assertEquals(lld1.removeFirst(),"g");
        assertEquals(lld1.removeFirst(),"h");*/
        assertEquals(lld1.get(0),"f");
        assertEquals(lld1.get(1),"c");
    }
    @Test
    public void removeFirstTest(){
        ArrayDeque<String> lld1 = new ArrayDeque<>();
        lld1.addLast("0");
        lld1.addLast("1");
        lld1.addLast("2");
        lld1.addLast("3");
        assertEquals(lld1.removeFirst(),"0");

    }
}
