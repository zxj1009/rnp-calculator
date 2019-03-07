package com.airwallex.exercise.rnpcalculator.operation;


import com.airwallex.exercise.rnpcalculator.exception.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by xiaojzhou on 3/6/19.
 */
public class ClearOperation implements Operation {

    public OperatorType getOperatorType() {
        return OperatorType.CLEAR;
    }

    public void execute(Stack<BigDecimal> numbers, Stack<OperationRecord> histories) throws InsufficientParamsException {
        int count = numbers.size();

        BigDecimal[] params = new BigDecimal[count];
        for(int i = 0; i < count; i++) {
            params[i] = numbers.pop();
        }

        numbers.clear();

        //add an operation history
        histories.push(new OperationRecord(0, params));
    }
}
