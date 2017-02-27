package com.test.for_mocking;

/**
 * Created by gnavin on 2/26/17.
 */
public final class ClassWithPrivateMethod {

    private String privateMethod() {
        return "privateMethod";
    }

    public String method1() {
        return privateMethod();
    }

    public String method2() {
        return method1();
    }

}
