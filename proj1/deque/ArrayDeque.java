package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {

    private T[] elem;

    private int head;

    private int tail;

    private int size;

    public ArrayDeque() {

        elem = (T[]) new Object[8];
    }

    @Override

    public void addFirst(T item) {
        if (size == elem.length) {
            expand();
        }
        if (size == 0) {
            tail = 0;
            head = 0;
            elem[head] = item;
            size++;
        } else {
            head = prev(head);
            elem[head] = item;
            size++;
        }
    }

    private int prev(int pos) {

        if (pos == 0) {

            return elem.length - 1;

        } else {

            return pos - 1;

        }

    }

    private int next(int pos) {
        if (pos == elem.length - 1) {
            return 0;
        } else {
            return pos + 1;
        }
    }

    @Override

    public void addLast(T item) {
        if (size == elem.length) {
            expand();
        }
        if (size == 0) {
            tail = 0;
            head = 0;
            elem[tail] = item;
            size++;
        } else {
            tail = next(tail);
            elem[tail] = item;
            size++;
        }
    }

    @Override

    public int size() {

        return size;

    }

    @Override

    public void printDeque() {

    }


    @Override

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = elem[head];
        size--;
        if (head == 0 && size == 0) {
            head = 0;
        } else {
            head = next(head);
        }
        if (shrunk()) {
            expand(size());
        }
        return item;
    }

    @Override

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item = elem[tail];
        size--;
        if (tail == 0 && size == 0) {
            tail = 0;
        } else {
            tail = prev(tail);
        }
        if (shrunk()) {
            expand(size());
        }
        return item;
    }

    @Override

    public T get(int index) {

        if (index < 0 || index >= size) {

            return null;

        } else {
            return elem[(head + index) % elem.length];
        }
    }

    private void expand() {
        T[] newElem = (T[]) new Object[elem.length * 2];
        int end = elem.length - 1;

        for (int i = 0; i < elem.length; i++) {
            newElem[i] = elem[head];
            head = next(head);
        }
        elem = newElem;
        head = 0;
        tail = end;
    }

    private void expand(int newSize) {
        T[] newElem = (T[]) new Object[newSize * 2];
        int end = newSize - 1;
        for (int i = 0; i < newSize; i++) {
            newElem[i] = elem[head];
            head = next(head);
        }
        elem = newElem;
        head = 0;
        tail = end;

    }

    public boolean equals(Object o) {
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque item = (Deque) o;
        if (item.size() != size()) {
            return false;
        }
        for (int i = 0; i < item.size(); i++) {
            if (!item.get(i).equals(get(i))) {
                return false;
            }
        }
        return true;
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator<>();
    }

    private boolean shrunk() {
        return elem.length >= 16 && ((double) size() / elem.length) < 0.25;
    }

    private class ArrayDequeIterator<T> implements Iterator<T> {
        int inc;
        int pos;

         ArrayDequeIterator() {
            pos = head;
            inc = 0;
        }

        @Override
        public boolean hasNext() {
            return inc < size;
        }

        @Override
        public T next() {
            T item = (T) elem[pos];
            inc++;
            pos = ArrayDeque.this.next(pos);
            return item;
        }
    }
}
