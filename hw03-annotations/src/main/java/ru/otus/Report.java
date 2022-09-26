package ru.otus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Report {
    private Integer tolalTests;
    private final List<String> failsMethods = new ArrayList<>();
    private final List<Method> passMethods = new ArrayList<>();

    public void addFailure(String message) {
        failsMethods.add(message);
    }

    public void setTolalTests(Integer tolalTests) {
        this.tolalTests = tolalTests;
    }

    public void printReport() {
        System.out.println('\n');

        passMethods.forEach(e -> System.out.printf("%s - test passed\n", e.getName()));
        failsMethods.forEach(e -> System.out.printf("%s - test failed\n", e));

        System.out.printf("number of tests: %s \n", tolalTests);
        System.out.printf("number of pass tests: %d \n", passMethods.size());
        System.out.printf("number of failde tests: %d \n", failsMethods.size());
    }

    public void addPass(Method testMethod) {
        passMethods.add(testMethod);
    }
}
