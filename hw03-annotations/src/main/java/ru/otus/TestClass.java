package ru.otus;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {
    private final Class<?> clazz;

    public TestClass(Class<?> clazz) {
        this.clazz = clazz;
    }

    public List<Method> getTestMethods() {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        return Arrays.stream(declaredMethods)
                .filter(method -> method.getAnnotation(Test.class) != null)
                .collect(Collectors.toList());
    }

    public List<Method> getBeforeMethods() {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        return Arrays.stream(declaredMethods)
                .filter(method -> method.getAnnotation(Before.class) != null)
                .collect(Collectors.toList());
    }

    public List<Method> getAfterMethods() {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        return Arrays.stream(declaredMethods)
                .filter(method -> method.getAnnotation(After.class) != null)
                .collect(Collectors.toList());
    }

    public Constructor getConstructor() throws NoSuchMethodException {
        return this.clazz.getConstructor();
    }
}
