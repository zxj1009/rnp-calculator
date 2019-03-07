package com.airwallex.exercise.rnpcalculator.operation;

import com.airwallex.exercise.rnpcalculator.exception.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by xiaojzhou on 3/6/19.
 */
public interface Operation {

    OperatorType getOperatorType();

    void execute(Stack<BigDecimal> numbers, Stack<OperationRecord> histories) throws InsufficientParamsException;
}
