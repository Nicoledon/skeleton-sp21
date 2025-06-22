package gh2;

import deque.Deque;
import deque.LinkedListDeque;

/**
 * GuitarString class simulates a vibrating guitar string using
 * the Karplus-Strong algorithm.
 */
public class GuitarString {
    /**
     * Constants. These values should not be changed.
     */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = 0.996; // Energy decay factor

    private final Deque<Double> buffer;
    private final int capacity;

    /** Create a guitar string of the given frequency. */
    public GuitarString(double frequency) {
        this.capacity = (int) Math.round(SR / frequency);
        buffer = new LinkedListDeque<>();
        for (int i = 0; i < capacity; i++) {
            buffer.addLast(0.0);
        }
    }

    /** Pluck the guitar string by filling the buffer with random white noise. */
    public void pluck() {
        for (int i = 0; i < capacity; i++) {
            buffer.removeFirst();
        }
        for (int i = 0; i < capacity; i++) {
            double r = Math.random() - 0.5;
            buffer.addLast(r);
        }
    }

    /** Advance the simulation one time step using the Karplus-Strong algorithm. */
    public void tic() {
        if (buffer.size() >= 2) {
            double first = buffer.removeFirst();
            double second = buffer.get(0);
            double item = (first + second) / 2 * DECAY;
            buffer.addLast(item);
        }
    }

    /** Return the current sample from the front of the buffer. */
    public double sample() {
        return buffer.get(0);
    }
}
