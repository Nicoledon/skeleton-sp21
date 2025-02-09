package deque;

import jh61b.junit.In;
import org.junit.Test;

import java.beans.IntrospectionException;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

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
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
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
    /* Tests removing from an empty deque */

    public void removeEmptyTest() {
        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
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
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }

    }
    @Test
    public void getTest(){
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        lld1.addFirst(1);
        lld1.addFirst(2);
        int item = lld1.getRecursive(1);
        assertEquals(1,item);
    }
    @Test
    public void equalTest(){
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        lld1.addLast(0);
     int num1  = lld1.removeLast();      // ==> 0
        lld1.addFirst(2);
        lld1.addLast(3);
        int num2 =lld1.removeLast();      // ==> 3
       int num3= lld1.removeLast();      // ==> 2
        lld1.addFirst(6);
        int num4=lld1.get(0);      // ==> 6
        int num5 =lld1.removeLast();      // ==> 6
        lld1.addLast(9);
        lld1.addLast(10);
        lld1.addFirst(11);
        int num6=lld1.get(0);      // ==> 11
        lld1.addFirst(13);
        lld1.addLast(14);
        lld1.addLast(15);
        int num7=lld1.removeFirst();     // ==> 13
        lld1.addFirst(17);
        lld1.addLast(18);
       int num= lld1.get(3);      // ==> 14
    }
@Test
    public void eq(){
     ArrayDeque<Integer> l = new ArrayDeque<>();
    l.addLast(0);
    l.addLast(1);
    l.removeLast();      // ==> 1
    l.removeFirst();     // ==> 0
    l.addFirst(4);
    l.removeLast();      // ==> 4
    l.addFirst(6);
    l.removeFirst();     // ==> 6
    l.addFirst(8);
    l.removeFirst();     // ==> 8
    l.addFirst(10);
    l.removeLast();      // ==> 10
    l.addLast(12);
    l.addFirst(13);
    l.get(0);            // ==> 13
    l.addLast(15);
    l.removeLast();      // ==> 15
    l.removeLast();      // ==> 12
    l.removeFirst();     // ==> 13
    l.addFirst(19);
    l.addLast(20);
    l.addFirst(21);
    l.addFirst(22);
    int nums =l.get(2);            // ==> 20
  Deque<Integer> deque = new LinkedListDeque<>();
  deque.addFirst(1);
}
@Test
public void testequal(){
     LinkedListDeque<Integer> l =new LinkedListDeque<>();
     l.addLast(1);
     l.addLast(2);
     LinkedListDeque<Integer>l1 =new LinkedListDeque<>();
     ArrayDeque<Integer>l2= new ArrayDeque<>();
     l1.addLast(1);
     l1.addLast(3);
     l2.addLast(1);
     l2.addLast(3);
     assertTrue(l1.equals(l2));
    }
    @Test
    public void testLiking(){
        LinkedListDeque<Integer> l =new LinkedListDeque<>();
        l.addLast(1);
        l.addLast(2);
        for(int i : l){
            System.out.print(i +" ");
        }
    }
}
