package com.srnjak.academic.superposition;

/**
 * Enum representing different swap behavior for a particle's position
 * and momentum.
 */
public enum Swap {
    ONE(false, false),
    TWO(false, true),
    THREE(true, false),
    FOUR(true, true);

    public final boolean position;
    public final boolean momentum;

    Swap(boolean position, boolean momentum) {
        this.position = position;
        this.momentum = momentum;
    }
}
