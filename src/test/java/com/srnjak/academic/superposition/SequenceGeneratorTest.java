package com.srnjak.academic.superposition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SequenceGeneratorTest {

    @Test
    public void testManualSequence() {
        var manualBaseSequence = new int[]{0, 1, 1, 3, 0, 2, 1, 2, 3};
        var manualGenerator = new SequenceGenerator(manualBaseSequence);

        // Example of testing the first 5 values of the sequence
        assertEquals(0, manualGenerator.nextValue());
        assertEquals(1, manualGenerator.nextValue());
        assertEquals(1, manualGenerator.nextValue());
        assertEquals(3, manualGenerator.nextValue());
        assertEquals(0, manualGenerator.nextValue());
    }

    @Test
    public void testRandomSequenceValuesInRange() {
        int sequenceLength = 10;
        SequenceGenerator randomGenerator = new SequenceGenerator(sequenceLength);

        // Check if all values in the sequence are within the expected range
        for (int i = 0; i < sequenceLength; i++) {
            int value = randomGenerator.nextValue();
            assertTrue(value >= 0 && value <= 3, "Value should be between 0 and 3");
        }
    }

    @Test
    public void testRandomSequenceRepetition() {
        int sequenceLength = 10;
        SequenceGenerator randomGenerator = new SequenceGenerator(sequenceLength);

        // Store the first full cycle of values
        int[] firstCycle = new int[sequenceLength];
        for (int i = 0; i < sequenceLength; i++) {
            firstCycle[i] = randomGenerator.nextValue();
        }

        // Check the next cycle of values to see if it repeats the sequence
        for (int i = 0; i < sequenceLength; i++) {
            int value = randomGenerator.nextValue();
            assertTrue(value == firstCycle[i], "Sequence should repeat after " + sequenceLength + " steps");
        }
    }

    @Test
    public void testResetMethod() {
        int[] baseSequence = {0, 1, 1, 3, 0, 2, 1, 2, 3};
        SequenceGenerator generator = new SequenceGenerator(baseSequence);

        // Get a few values from the sequence
        generator.nextValue(); // 0
        generator.nextValue(); // 1
        generator.nextValue(); // 1

        // Reset the sequence
        generator.reset();

        // Test if the sequence starts over from the beginning
        assertEquals(0, generator.nextValue(), "After reset, the first value of the sequence should be returned");
    }
}