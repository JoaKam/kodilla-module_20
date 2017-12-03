package com.kodilla.kodillapatterns2.aop.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@EnableAspectJAutoProxy
public class Calculator {
    private static final Logger LOGGER = LoggerFactory.getLogger(Calculator.class);

    public double add(double x, double y) {
        return x + y;
    }

    public double sub(double x, double y) {
        return x - y;
    }

    public double mul(double x, double y) {
        return x * y;
    }

    public double div(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Divide by zero");
        }

        return x / y;
    }

    public BigDecimal factorial(BigDecimal n) {
        if (n.compareTo(BigDecimal.ONE) > 0) {
            return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
        } else if (n.equals(BigDecimal.ONE) || n.equals(BigDecimal.ZERO)) {
            return BigDecimal.ONE;
        } else {
            throw new ArithmeticException("Factorial argument is negative");
        }

    }
}
