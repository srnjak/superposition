package com.srnjak.academic.superposition;

import java.util.Random;

public class SequenceGenerator {
    private final int[] baseSequence;
    private int currentIndex;

    // Constructor for manual base sequence
    public SequenceGenerator(int[] baseSequence) {
        this.baseSequence = baseSequence;
        this.currentIndex = 0;
    }

    // Constructor for random base sequence of a given length
    public SequenceGenerator(int length) {
        this.baseSequence = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            this.baseSequence[i] = random.nextInt(4); // Random number between 0 and 3
        }
        this.currentIndex = 0;
    }

    public int nextValue() {
        int value = baseSequence[currentIndex];
        currentIndex = (currentIndex + 1) % baseSequence.length;
        return value;
    }

    public void reset() {
        currentIndex = 0;
    }

}
