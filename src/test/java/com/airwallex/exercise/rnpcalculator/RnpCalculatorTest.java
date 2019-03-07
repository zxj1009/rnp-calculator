package com.airwallex.exercise.rnpcalculator;

import com.airwallex.exercise.rnpcalculator.exception.InsufficientParamsException;
import com.airwallex.exercise.rnpcalculator.exception.InvalidInputException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by xiaojzhou on 3/7/19.
 */
public class RnpCalculatorTest {

    RnpCalculator calculator;

    @Before
    public void setup(){
        calculator = new RnpCalculator();
    }

    @Test
    public void testRnpCalculator_1() throws InvalidInputException, InsufficientParamsException {
        calculator.calculate("5 2");
        Assert.assertEquals("stack: 5 2", constructDisplayStr(calculator.getNumbersForDisplay()));
    }

    @Test
    public void testRnpCalculator_2() throws InvalidInputException, InsufficientParamsException {
        calculator.calculate("2 sqrt");
        Assert.assertEquals("stack: 1.4142135623", constructDisplayStr(calculator.getNumbersForDisplay()));

        calculator.calculate("clear 9 sqrt");
        Assert.assertEquals("stack: 3", constructDisplayStr(calculator.getNumbersForDisplay()));
    }

    @Test
    public void testRnpCalculator_3() throws InvalidInputException, InsufficientParamsException {
        calculator.calculate("5 2 -");
        Assert.assertEquals("stack: 3", constructDisplayStr(calculator.getNumbersForDisplay()));

        calculator.calculate("3 -");
        Assert.assertEquals("stack: 0", constructDisplayStr(calculator.getNumbersForDisplay()));

        calculator.calculate("clear");
        Assert.assertEquals("stack: ", constructDisplayStr(calculator.getNumbersForDisplay()));
    }

    @Test
    public void testRnpCalculator_4() throws InvalidInputException, InsufficientParamsException {
        calculator.calculate("5 4 3 2");
        Assert.assertEquals("stack: 5 4 3 2", constructDisplayStr(calculator.getNumbersForDisplay()));

        calculator.calculate("undo undo *");
        Assert.assertEquals("stack: 20", constructDisplayStr(calculator.getNumbersForDisplay()));

        calculator.calculate("5 *");
        Assert.assertEquals("stack: 100", constructDisplayStr(calculator.getNumbersForDisplay()));

        calculator.calculate("undo");
        Assert.assertEquals("stack: 20 5", constructDisplayStr(calculator.getNumbersForDisplay()));
    }

    @Test
    public void testRnpCalculator_5() throws InvalidInputException, InsufficientParamsException {
        calculator.calculate("7 12 2 /");
        Assert.assertEquals("stack: 7 6", constructDisplayStr(calculator.getNumbersForDisplay()));

        calculator.calculate("*");
        Assert.assertEquals("stack: 42", constructDisplayStr(calculator.getNumbersForDisplay()));

        calculator.calculate("4 /");
        Assert.assertEquals("stack: 10.5", constructDisplayStr(calculator.getNumbersForDisplay()));
    }

    @Test
    public void testRnpCalculator_6() throws InvalidInputException, InsufficientParamsException {
        calculator.calculate("1 2 3 4 5");
        Assert.assertEquals("stack: 1 2 3 4 5", constructDisplayStr(calculator.getNumbersForDisplay()));

        calculator.calculate("*");
        Assert.assertEquals("stack: 1 2 3 20", constructDisplayStr(calculator.getNumbersForDisplay()));

        calculator.calculate("clear 3 4 -");
        Assert.assertEquals("stack: -1", constructDisplayStr(calculator.getNumbersForDisplay()));
    }

    @Test
    public void testRnpCalculator_7() throws InvalidInputException, InsufficientParamsException {
        calculator.calculate("1 2 3 4 5");
        Assert.assertEquals("stack: 1 2 3 4 5", constructDisplayStr(calculator.getNumbersForDisplay()));

        calculator.calculate("* * * *");
        Assert.assertEquals("stack: 120", constructDisplayStr(calculator.getNumbersForDisplay()));
    }

    @Test
    public void testRnpCalculator_8(){
        try {
            calculator.calculate("1 2 3 * 5 + * * 6 5");
        } catch (InsufficientParamsException e) {
            Assert.assertEquals("operator * (position: 15): insufficient parameters", e.getMessage());
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("stack: 11", constructDisplayStr(calculator.getNumbersForDisplay()));
    }

    private String constructDisplayStr(BigDecimal[] numbers){
        return "stack: " + StringUtils.join(numbers, " ");
    }

}
