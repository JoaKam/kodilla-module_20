package com.kodilla.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.Scanner;

public class HamPizzaOrderDecorator extends AbstractPizzaOrderDecorator {
    public HamPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(3));
    }

    @Override
    public String getDesc() {
        return super.getDesc() + " with extra ham";
    }
}
