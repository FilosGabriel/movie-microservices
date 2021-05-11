package com.filos.users.aop.logging;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

@DisplayName("When a method is annotated with @LogExecutionTime")
class LoggingAspectTest {

    private String string = "INFO com.filos.users.aop.logging.LoggingAspect - StopWatch 'TestInterface->doSomething': running time =";

    @Test
    @DisplayName("then it should print the duration of execution")
    public void test() {
        // Given
        TestInterface target = new TestAspectTarget();
        AspectJProxyFactory factory = new AspectJProxyFactory(target);
        LoggingAspect aspect = new LoggingAspect();
        factory.addAspect(aspect);
        TestInterface proxy = factory.getProxy();
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        // When
        proxy.doSomething();
        // Then
        assertThat(outputStreamCaptor.toString())
                .contains(string);

    }

    private static class TestAspectTarget implements TestInterface {
        @Override
        @LogExecutionTime
        public void doSomething() {

        }
    }

    public static interface TestInterface {
        void doSomething();
    }

}