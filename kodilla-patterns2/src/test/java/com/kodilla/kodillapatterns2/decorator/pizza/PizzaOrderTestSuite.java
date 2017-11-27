package com.kodilla.kodillapatterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        BigDecimal calcCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(15), calcCost);
    }

    @Test
    public void testBasicPizzaOrderGetDesc(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        String basicDesc = pizzaOrder.getDesc();
        //Then
        assertEquals("Ingredients: Pizza dough, tomato sauce, mozzarella cheese", basicDesc);
    }

    @Test
    public void testPizzaExtraCheeseThickGetCost(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheesePizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new ThickPizzaOrderDecorator(pizzaOrder);
        //When
        BigDecimal calcCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(22), calcCost);
    }

    @Test
    public void testPizzaExtraCheeseThick2HamGetCost(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheesePizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new ThickPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new HamPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new HamPizzaOrderDecorator(pizzaOrder);
        //When
        BigDecimal calcCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(28), calcCost);
    }

    @Test
    public void testPizzaExtraCheeseThick2HamGetDesc(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheesePizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new ThickPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new HamPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new HamPizzaOrderDecorator(pizzaOrder);
        //When
        String pizzaDesc = pizzaOrder.getDesc();
        //Then
        assertEquals("Ingredients: Pizza dough, tomato sauce, mozzarella cheese with extra cheese thick crust with extra ham with extra ham", pizzaDesc);
    }
}
