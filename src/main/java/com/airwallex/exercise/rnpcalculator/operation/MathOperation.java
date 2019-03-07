package com.airwallex.exercise.rnpcalculator.operation;

import com.airwallex.exercise.rnpcalculator.exception.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by xiaojzhou on 3/5/19.
 */
public abstract class MathOperation implements Operation {

    protected abstract BigDecimal calculate(BigDecimal...params);

    abstract int getParamCount();

    public void execute(Stack<BigDecimal> numbers, Stack<OperationRecord> histories) throws InsufficientParamsException {
        int paramCount = getParamCount();
        if(numbers.size() < paramCount) {
            throw new InsufficientParamsException(getOperatorType());
        }

        BigDecimal[] params = new BigDecimal[paramCount];
        for(int i = 0; i < paramCount; i++) {
            params[i] = numbers.pop();
        }

        BigDecimal newNumber = calculate(params);
        numbers.push(newNumber);

        //add an operation history
        histories.push(new OperationRecord(1, params));
    }

}
