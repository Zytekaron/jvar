package tk.zytekaron.jvar;

/**
 * Various utility methods for unsupported math operations
 */
public class Maths {
    /**
     * Constrain an int to a certain range
     * @param num The number to constrain
     * @param min The minimum return value
     * @param max The maximum return value
     * @return The number, forced into the given range
     */
    public static int constrain(int num, int min, int max) {
        return Math.min(Math.max(num, min), max);
    }
    
    /**
     * Constrain a long to a certain range
     * @param num The number to constrain
     * @param min The minimum return value
     * @param max The maximum return value
     * @return The number, forced into the given range
     */
    public static long constrain(long num, long min, long max) {
        return Math.min(Math.max(num, min), max);
    }
    
    /**
     * Constrain a double to a certain range
     * @param num The number to constrain
     * @param min The minimum return value
     * @param max The maximum return value
     * @return The number, forced into the given range
     */
    public static double constrain(double num, double min, double max) {
        return Math.min(Math.max(num, min), max);
    }
    
    /**
     * Map a double from one range to another
     * @param num The number to map
     * @param istart The starting point of the number's initial range
     * @param istop The ending point of the number's initial range
     * @param ostart The starting point of the number's final range
     * @param ostop The ending point of the number's final range
     * @return A double mapped to the given range
     */
    public static double map(double num, float istart, float istop, float ostart, float ostop) {
        return ostart + (ostop - ostart) * ((num - istart) / (istop - istart));
    }
    
    /**
     * Calculate the rolling average of an arbitrary number of integers
     * @param ints The integers to average
     * @return The average of the integers
     */
    public static double average(int... ints) {
        double average = 0;
        double n = 1;
        for (int num : ints) {
            average = (n - 1) / n * average + num / n;
            n++;
        }
        return average;
    }
    
    /**
     * Calculate the rolling average of an arbitrary number of integers
     * @param doubles The doubles to average
     * @return The average of the integers
     */
    public static double average(double... doubles) {
        double average = 0;
        double n = 1;
        for (double num : doubles) {
            average = (n - 1) / n * average + num / n;
            n++;
        }
        return average;
    }

    public static double roundTo(double number, double to) {
        return Math.floor(number / to) * to;
    }
}