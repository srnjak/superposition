package com.srnjak.academic.superposition;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * A test class to simulate and test various superposition and state swapping
 * scenarios on particles.
 */
public class Superposition {

    /**
     * The size of the particle array to be tested.
     */
    public static final Integer SIZE = 8 * 1000 * 1000;

    /**
     * Swaps the position of a particle based on the specified swap strategy.
     *
     * @param position The current position of the particle.
     * @param swap The swap strategy to be applied.
     * @return The new position of the particle after the swap.
     */
    public static Position swap(Position position, Swap swap) {

        if (!swap.position) {
            return position;
        }

        Position finalPosition;

        switch (position) {
            case LEFT:
                finalPosition = Position.RIGHT;
                break;
            case RIGHT:
                finalPosition = Position.LEFT;
                break;
            default:
                throw new IllegalArgumentException();
        }

        return finalPosition;
    }

    /**
     * Swaps the momentum of a particle based on the specified swap strategy.
     *
     * @param momentum The current momentum of the particle.
     * @param swap The swap strategy to be applied.
     * @return The new momentum of the particle after the swap.
     */
    public static Momentum swap(Momentum momentum, Swap swap) {

        if (!swap.momentum) {
            return momentum;
        }

        Momentum finalMomentum;

        switch (momentum) {
            case HIGH:
                finalMomentum = Momentum.LOW;
                break;
            case LOW:
                finalMomentum = Momentum.HIGH;
                break;
            default:
                throw new IllegalArgumentException();
        }

        return finalMomentum;
    }

    /**
     * Calculates the percentage of a part value in relation to a whole value.
     *
     * @param part The part value.
     * @return A string representing the percentage.
     */
    private static String calculatePercentage(Integer part) {
        if (part == null || Superposition.SIZE == 0) {
            throw new IllegalArgumentException(
                    "Values cannot be null and whole cannot be zero.");
        }

        double percentage = ((double) part / Superposition.SIZE) * 100;
        return String.format("%.1f%%", percentage);
    }

    /**
     * List of particles used in the simulation. This list is populated in
     * the prepare() method and is used in the test methods to perform various
     * swap operations.
     */
    @Getter
    private List<Particle> particles;

    public Superposition() {

        var particles = new ArrayList<Particle>();

        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {

            var particle = new Particle(
                    Position.values()[random.nextInt(2)],
                    Momentum.values()[random.nextInt(2)]);

            particles.add(particle);
        }

        this.particles = particles;
    }

    /**
     * Measures and filters a list of particles based on a given predicate
     * and swap selector.
     *
     * @param particles The list of particles to be measured and filtered.
     * @param predicate The predicate to filter particles.
     * @param swapSelector A function that selects a swap strategy based on
     *                     a particle index.
     * @return A list of particles that meet the specified criteria.
     */
    public static List<Particle> measure(
            List<Particle> particles,
            Predicate<Particle> predicate,
            Function<Integer, Swap> swapSelector) {

        var electrons1 = new ArrayList<Particle>();
        var i = 0;
        for (Particle particle : particles) {

            if (!predicate.test(particle)) {
                continue;
            }

            var swap = swapSelector.apply(i);

            var p = new Particle(
                    swap(particle.position(), swap),
                    swap(particle.momentum(), swap));

            electrons1.add(p);

            i++;
        }

        var size = electrons1.size();
        System.out.println(calculatePercentage(size) + " (" + size + ")");

        return electrons1;
    }
}
