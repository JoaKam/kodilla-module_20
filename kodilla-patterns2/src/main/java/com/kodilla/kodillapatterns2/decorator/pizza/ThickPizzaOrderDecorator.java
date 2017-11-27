package com.kodilla.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class ThickPizzaOrderDecorator extends AbstractPizzaOrderDecorator{
    public ThickPizzaOrderDecorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost(){
        return super.getCost().add(new BigDecimal(2));
    }

    @Override
    public String getDesc(){
        return super.getDesc() + " thick crust";
    }
}
