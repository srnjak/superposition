package com.srnjak.academic.superposition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.srnjak.academic.superposition.Superposition.*;

/**
 * A test class to simulate and test various superposition and state swapping
 * scenarios on particles.
 */
public class SuperpositionTest {

    private Superposition tut;

    @BeforeEach
    public void boot() {
        tut = new Superposition();
    }

    @Test
    public void testRandomSwap() {
        performSwapTest("random", i -> Swap.values()[new Random().nextInt(4)]);
    }

    @Test
    public void testSequentialSwap() {
        performSwapTest("sequence", i -> Swap.values()[i % 4]);
    }

     @Test
    public void testAdvancedSequentialSwap() {
//        var generator = new SequenceGenerator(new int[]{3, 0, 0, 2, 1, 3, 2, 1});
//         var generator = new SequenceGenerator(new int[]{0, 1, 2, 3});
//         var generator = new SequenceGenerator(new int[]{3, 0, 0, 2, 1, 3, 2, 1, 1, 1, 1});
//         var generator = new SequenceGenerator(1000);
         var generator = new SequenceGenerator(new int[]{0, 3});

         performSwapTest("advanced sequence", i -> {
             if (i == 0) {
                 generator.reset();
             }

             return Swap.values()[generator.nextValue()];
         });
    }

    @Test
    public void testSwapOneAlways() {
        performSwapTest("no swaps", i -> Swap.values()[0]);
    }

    @Test
    public void testSwapTwoAlways() {
        performSwapTest("swap vertical", i -> Swap.values()[1]);
    }

    @Test
    public void testSwapThreeAlways() {
        performSwapTest("swap horizontal", i -> Swap.values()[2]);
    }

    @Test
    public void testSwapFourAlways() {
        performSwapTest("swap horizontal and vertical", i -> Swap.values()[3]);
    }

    @Test
    public void testFirstHalfSwapOneSecondHalfSwapTwo() {
        performSwapTest(
                "first half no swap, second half swap vertical",
                i -> i < Superposition.SIZE / 2 ?
                        Swap.values()[0] : Swap.values()[1]);
    }

    @Test
    public void testFirstHalfSequentialSwapSecondHalfRandomSwap() {
        performSwapTest(
                "first half sequence, second half random",
                i -> i < Superposition.SIZE / 2 ?
                        Swap.values()[i % 4] :
                        Swap.values()[new Random().nextInt(4)]);
    }

    @Test
    public void testFirstHalfRandomSwapSecondHalfSequentialSwap() {
        performSwapTest(
                "first half random, second half sequence",
                i -> i > Superposition.SIZE / 2 ?
                        Swap.values()[i % 4] :
                        Swap.values()[new Random().nextInt(4)]);
    }

    /**
     * Performs a test of the swapping mechanism using a specified swap
     * strategy and swap selector.
     *
     * @param strategy A description of the swap strategy.
     * @param swapSelector A function that selects a swap strategy based on
     *                     a particle index.
     */
    private void performSwapTest(
            String strategy, Function<Integer, Swap> swapSelector) {

        Predicate<Particle> filterLeft =
                p -> Position.LEFT.equals(p.position());
        Predicate<Particle> filterRight =
                p -> Position.RIGHT.equals(p.position());
        Predicate<Particle> filterHigh =
                p -> Momentum.HIGH.equals(p.momentum());
        Predicate<Particle> filterLow =
                p -> Momentum.LOW.equals(p.momentum());
        Predicate<Particle> passAll = p -> true;


        System.out.println("Swap strategy: " + strategy);
        System.out.println("*** Accept high");
        var filteredA1 = measure(tut.getParticles(), filterLeft, swapSelector);
        var filteredA2 = measure(filteredA1, filterHigh, swapSelector);
        var filteredA3 = measure(filteredA2, filterLeft, swapSelector);

        System.out.println("*** Accept high and low");
        var filteredB1 = measure(tut.getParticles(), filterLeft, swapSelector);
        var filteredB2 = measure(filteredB1, passAll, swapSelector);
        var filteredB3 = measure(filteredB2, filterLeft, swapSelector);
//
//        System.out.println("*** Accept high and low separately");
//        var filteredC1 = measure(tut.getParticles(), filterLeft, swapSelector);
//        var filteredC2a = measure(filteredC1, filterHigh, swapSelector);
//        var filteredC2b = measure(filteredC1, filterLow, swapSelector);
//        var filteredC2 = new ArrayList<Particle>();
//        filteredC2.addAll(filteredC2a);
//        filteredC2.addAll(filteredC2b);
//        Collections.shuffle(filteredC2);
//        var filteredC3 = measure(filteredC2, filterLeft, swapSelector);
//
//        System.out.println("*** Position only (twice)");
//        var filteredD1 = measure(tut.getParticles(), filterLeft, swapSelector);
//        var filteredD2 = measure(filteredD1, filterLeft, swapSelector);
//
//        System.out.println("*** Momentum only");
//        var filteredE1 = measure(tut.getParticles(), filterHigh, swapSelector);

        System.out.println();
    }
}
