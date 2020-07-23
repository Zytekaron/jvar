package com.zytekaron.jvar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * A java port for .env environment variables
 */
public final class DotEnv {
    
    private DotEnv() {
    }
    
    /**
     * Load the environment variables
     *
     * @return A map containing environment variable names mapped to their value
     */
    public static Map<String, String> load() {
        return load(DotEnv.class.getClassLoader(), true);
    }
    
    /**
     * Load the environment variables
     *
     * @param classLoader The ClassLoader to use
     * @return A map containing environment variable names mapped to their value
     */
    public static Map<String, String> load(ClassLoader classLoader) {
        return load(classLoader, true);
    }
    
    /**
     * Load the environment variables
     *
     * @param includeSystemEnv Whether the system environment variables should be loaded and included (`System.getEnv()`)
     * @return A map containing environment variable names mapped to their value
     */
    public static Map<String, String> load(boolean includeSystemEnv) {
        return load(DotEnv.class.getClassLoader(), includeSystemEnv);
    }
    
    /**
     * Load the environment variables
     *
     * @param classLoader      The ClassLoader to use
     * @param includeSystemEnv Whether the system environment variables should be loaded and included (`System.getEnv()`)
     * @return A map containing environment variable names mapped to their value
     */
    public static Map<String, String> load(ClassLoader classLoader, boolean includeSystemEnv) {
        Map<String, String> map = new HashMap<>(parse(classLoader.getResourceAsStream(".env")));
        if (includeSystemEnv) {
            map.putAll(System.getenv());
        }
        try {
            map.putAll(parse(new FileInputStream(".env")));
        } catch (FileNotFoundException ignored) {
        }
        return Collections.unmodifiableMap(map);
    }
    
    private static Map<String, String> parse(InputStream inputStream) {
        if (inputStream == null) {
            return Collections.emptyMap();
        }
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey().toString(), entry -> entry.getValue().toString()));
    }
}