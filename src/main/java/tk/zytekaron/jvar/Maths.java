package tk.zytekaron.jvar;

public class Maths {
    public static int constrain(int num, int min, int max) {
        return Math.min(Math.max(num, min), max);
    }
    
    public static long constrain(long num, long min, long max) {
        return Math.min(Math.max(num, min), max);
    }
    
    public static double constrain(double num, double min, double max) {
        return Math.min(Math.max(num, min), max);
    }
}