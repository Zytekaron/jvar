package com.zytekaron.jvar.tests;

import org.junit.Test;
import com.zytekaron.jvar.Maths;

import static org.junit.Assert.assertEquals;

public class MathsTest {

    @Test
    public void roundTest() {
        double[] values = {
                Maths.roundTo(123456789.987654321, 100000), // 123400000
                Maths.roundTo(123456789.987654321, 10000),  // 123450000
                Maths.roundTo(123456789.987654321, 1000),   // 123456000
                Maths.roundTo(123456789.987654321, 100),    // 123456700
                Maths.roundTo(123456789.987654321, 10),     // 123456780
                Maths.roundTo(123456789.987654321, 1),      // 123456789
                Maths.roundTo(123456789.987654321, .1),     // 123456789.9
                Maths.roundTo(123456789.987654321, .01),    // 123456789.98
                Maths.roundTo(123456789.987654321, .001),   // 123456789.987
                Maths.roundTo(123456789.987654321, .0001),  // 123456789.9876
                Maths.roundTo(123456789.987654321, .00001)  // 123456789.98765
        };

        double[] returns = {
                123400000,
                123450000,
                123456000,
                123456700,
                123456780,
                123456789,
                123456789.9,
                123456789.98,
                123456789.987,
                123456789.9876,
                123456789.98765
        };

        for (int i = 0; i < values.length; i++) {
            assertEquals("Return values must match (index = " + i + ")",
                    values[i],
                    returns[i],
                    0);
        }
    }
}