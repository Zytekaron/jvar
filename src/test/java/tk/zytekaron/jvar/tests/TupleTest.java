package tk.zytekaron.jvar.tests;

import org.junit.Test;
import tk.zytekaron.jvar.Tuple;

import static org.junit.Assert.assertEquals;

public class TupleTest {

    @Test
    public void tupleGetterTest() {
        Tuple<String, String> tuple = new Tuple<>("first element", "second element");

        assertEquals("Getter .getFirst() must return the first element",
                     "first element",
                     tuple.getFirst());

        assertEquals("Getter .getSecond() must return the second element",
                     "second element",
                     tuple.getSecond());
    }
}