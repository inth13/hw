

package ru.otus;


public class AnnotationsTest {

    public static void main(String... args) {
        new AnnotationsTest().go(TestTarget.class);
    }

    private void go(Class<?> clazz) {
        new Runner(new TestClass(clazz), new Report()).run();
    }
}
