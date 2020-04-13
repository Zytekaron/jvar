package tk.zytekaron.jvar;

import tk.zytekaron.jvar.randomizer.Randomizer;

import java.util.Map;

public class Main {
    
    public static void main(String[] args) {
        Map<String, String> env = DotEnv.load();
        System.out.println(env.get("Path"));
    
        Randomizer<String> randomizer = new Randomizer<String>()
                .add(99998, "Hello!")
                .add(1, "Secret response 1")
                .add(1, "Secret response 2");
        System.out.println(randomizer.next());
    
        System.out.println(Maths.average(10, 20, 30)); // 20.0
        System.out.println(Maths.average(2.5, 1050, 11.222)); // 354.57399999999996
        System.out.println(Maths.constrain(10, 25, 50)); // 25
        System.out.println(Maths.map(0.53, 0, 1, 0, 100)); // 53.0
        System.out.println(Maths.roundTo(Math.PI, .01)); // 3.14
        System.out.println(Maths.roundTo(Integer.MAX_VALUE, 100000000)); // 2.1E9
    }
}