package tk.zytekaron.jvar.tests;

import org.junit.Test;
import tk.zytekaron.jvar.DotEnv;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DotEnvTest {
    
    @Test
    public void testDefault() {
        Map<String, String> env = DotEnv.load();
        assertEquals(".env value for 'TEST_KEY' must equal 'test_value'", "test_value", env.get("TEST_KEY"));
    }
    
    @Test
    public void testWithOptions() {
        Map<String, String> env = DotEnv.load();
        assertEquals(".env value for 'TEST_KEY' must equal 'test_value'", "test_value", env.get("TEST_KEY"));
    }
}