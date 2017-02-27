package com.test.for_mocking;

/**
 * Created by gnavin on 2/26/17.
 */
public class StaticClassForTesting {

    public static String method1() {
        return "Method1";
    }

    public static String method2(final String str) {
        return "Method2";
    }

    public static String methodThrowException(final String str) throws IndexOutOfBoundsException {
        return "Method2";
    }
}
