package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private final Comparator<T> comp;
    private final ArrayDeque<T> deque;

    public MaxArrayDeque(Comparator<T> c) {
        deque = new ArrayDeque<>();
        comp = c;
    }

    public T max() {
        if (size() == 0) {
            return null;
        }
        if (size() == 1) {
            return get(0);
        }
        T max = get(0);
        for (int i = 1; i < size(); i++) {
            if (comp.compare(get(i), max) > 0) {
                max = get(i);
            }
        }
        return max;
    }

    public T max(Comparator<T> c) {
        if (size() == 0) {
            return null;
        }
        if (size() == 1) {
            return get(0);
        }
        T max = get(0);
        for (int i = 1; i < size(); i++) {
            if (c.compare(get(i), max) > 0) {
                max = get(i);
            }
        }
        return max;
    }
}