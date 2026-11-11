package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {

    @Test
    void testNoDiscount() {
        DiscountPolicy policy = new NoDiscount();
        PriceCalculator calculator = new PriceCalculator(policy);
        assertEquals(100.0, calculator.calculate(100.0));
    }

    @Test
    void testPercentDiscount() {
        DiscountPolicy policy = new PercentDiscount(20); 
        PriceCalculator calculator = new PriceCalculator(policy);
        assertEquals(80.0, calculator.calculate(100.0));
    }

    @Test
    void testPolicyReplacement() {
        DiscountPolicy policy1 = new NoDiscount();
        PriceCalculator calc1 = new PriceCalculator(policy1);
        assertEquals(100.0, calc1.calculate(100.0));

        DiscountPolicy policy2 = new PercentDiscount(50);
        PriceCalculator calc2 = new PriceCalculator(policy2);
        assertEquals(50.0, calc2.calculate(100.0));
    }
}