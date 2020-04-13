package tk.zytekaron.jvar.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import tk.zytekaron.jvar.randomizer.Item;
import tk.zytekaron.jvar.randomizer.Randomizer;


import java.util.Arrays;

public class RandomizerTest {

    @Test
    public void itemIterationTest() {
        Randomizer<String> randomizer = new Randomizer<String>()
                .add(10, "option 1")
                .add(20, "option 2")
                .add(30, "option 3")
                .add(40, "option 4");

        int total = 0;
        for (Item<String> tuple : randomizer.getItems()) {
            total += tuple.getWeight();
        }

        assertEquals("Total value should be 100.0", total, 100, 0);
    }

    @Test
    public void randomChancesShouldMatchWeights() {
        final int TESTS = 1_000_000;
        Randomizer<String> randomizer = new Randomizer<String>()
                .add( 10, "hi")
                .add(200, "hey")
                .add(300, "hello")
                .add(500, "what's up?");

        int[] results = new int[4];
        for (int i = 0; i < TESTS; i++) {
            switch (randomizer.next()) {
                case "hi":
                    results[0]++;
                    break;
                case "hey":
                    results[1]++;
                    break;
                case "hello":
                    results[2]++;
                    break;
                case "what's up?":
                    results[3]++;
                    break;
            }
        }

        double total = randomizer.getItems().stream()
                .map(Item::getWeight)
                .reduce(Double::sum)
                .orElse(0.0);

        double[] resultDoubles = Arrays.stream(results)
                .mapToDouble(op -> (double) op / TESTS * 100)
                .toArray();

        double[] averages = {
                10 / total * 100,
                200 / total * 100,
                300 / total * 100,
                500 / total * 100
        };
        System.out.println("=============");
        System.out.println("Total:   " + total);
        System.out.println("Average: " + Arrays.toString(averages));
        System.out.println("Results: " + Arrays.toString(resultDoubles));
        System.out.println("=============");
    }
}