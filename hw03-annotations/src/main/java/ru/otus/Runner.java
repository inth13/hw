package ru.otus;

import java.lang.reflect.Method;
import java.util.List;

public class Runner {

    private final TestClass testClass;
    private final Report report;

    public Runner(TestClass testClass, Report report) {
        this.testClass = testClass;
        this.report = report;
    }

    public void run() {
        List<Method> testMethods = this.testClass.getTestMethods();
        report.setTolalTests(testMethods.size());

        for (Method testMethod : testMethods) {
            Object testInstance = null;
            try {
                testInstance = this.testClass.getConstructor().newInstance();
                runBefores(testInstance);
                runTest(testInstance, testMethod);
            } catch (FailedBefore failedBefore) {
                failedBefore.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException("stub exception");
            } finally {
                afterMethods(testInstance);
            }
        }
        report.printReport();
    }

    private void afterMethods(Object testInstance) {
        List<Method> afterMethods = this.testClass.getAfterMethods();
        for (Method afterMethod : afterMethods) {
            try {
                afterMethod.invoke(testInstance);
            } catch (IllegalAccessException e) {
                report.addFailure(afterMethod.getName());
                e.printStackTrace();
            } catch (Exception e) {
                report.addFailure(afterMethod.getName());
            }
        }
    }

    private void runTest(Object testInstance, Method testMethod) {
        try {
            testMethod.invoke(testInstance);
            report.addPass(testMethod);
        } catch (Exception e) {
            report.addFailure(testMethod.getName());
            e.printStackTrace();
        }
    }

    private void runBefores(Object testInstance) throws FailedBefore {
        List<Method> beforeMethods = this.testClass.getBeforeMethods();
        for (Method beforeMethod : beforeMethods) {
            try {
                beforeMethod.invoke(testInstance);
            } catch (Exception e) {
                report.addFailure(beforeMethod.getName());
                throw new FailedBefore();
            }
        }
    }
}

