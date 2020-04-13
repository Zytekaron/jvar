package tk.zytekaron.jvar.randomizer;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Calculated randomization based on element weights
 * <b>* samples are O(n)</b>
 *
 * @param <E> The element class for return values
 */
public class Randomizer<E> {
    private final List<Item<E>> items = new ArrayList<>();
    private final Random random;
    private double total = 0;

    /**
     * Create a new Randomizer
     */
    public Randomizer() {
        this(new Random());
    }

    /**
     * Create a new Randomizer with a pre-defined Random instance
     *
     * @param random The Random instance for this Randomizer to use
     */
    public Randomizer(@NotNull Random random) {
        Objects.requireNonNull(random);
        this.random = random;
    }

    /**
     * Add an element to this Randomizer
     *
     * @param weight The weight of this element
     * @param result The result for this element
     * @return This Randomizer instance
     */
    public Randomizer<E> add(double weight, E result) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }
        total += weight;
        items.add(new Item<>(weight, result));
        return this;
    }

    /**
     * Generate a calculated random result and return it
     *
     * @return The generated result
     */
    public E next() {
        double r = random.nextDouble() * total;
        double countWeight = 0.0;
        for (Item<E> tuple : items) {
            E result = tuple.getResult();
            Double weight = tuple.getWeight();
            countWeight += weight;
            if (countWeight >= r) {
                return result;
            }
        }
        return null; // should never occur
    }

    /**
     * Get the list of item tuples
     *
     * @return The list of item tuples
     */
    public List<Item<E>> getItems() {
        return items;
    }
}