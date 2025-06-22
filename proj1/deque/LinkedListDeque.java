package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private final Node sentinelHead;
    private final Node sentinelTail;
    private int size;

    public LinkedListDeque() {
        sentinelHead = new Node();
        sentinelTail = new Node();
        sentinelHead.next = sentinelTail;
        sentinelHead.prev = null;
        sentinelTail.next = null;
        sentinelTail.prev = sentinelHead;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        size++;
        Node temp = sentinelHead.next;
        Node node = new Node(item, sentinelHead, temp);
        sentinelHead.next = node;
        temp.prev = node;
    }

    @Override
    public void addLast(T item) {
        size++;
        Node temp = sentinelTail.prev;
        Node node = new Node(item, temp, sentinelTail);
        temp.next = node;
        sentinelTail.prev = node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node temp = sentinelHead.next;
        while (temp != sentinelTail) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T item = sentinelHead.next.item;
        Node temp = sentinelHead.next.next;
        sentinelHead.next = temp;
        temp.prev = sentinelHead;
        size--;
        return item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T item = sentinelTail.prev.item;
        Node temp = sentinelTail.prev.prev;
        temp.next = sentinelTail;
        sentinelTail.prev = temp;
        size--;
        return item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node temp = sentinelHead.next;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(index, sentinelHead.next);
    }

    private T getRecursiveHelper(int index, Node node) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(index - 1, node.next);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque<?> other = (Deque<?>) o;
        if (other.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator();
    }

    private class Node {
        Node prev;
        Node next;
        T item;

        Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        Node() {
            this(null, null, null);
        }
    }

    private class LinkedIterator implements Iterator<T> {
        private Node current = sentinelHead.next;

        @Override
        public boolean hasNext() {
            return current != sentinelTail;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
