package com.airwallex.exercise.rnpcalculator.operation;

import java.math.BigDecimal;

/**
 * Created by xiaojzhou on 3/5/19.
 */
public class SubtractOperation extends MathOperation {

    private static int PARAM_COUNT = 2;

    protected BigDecimal calculate(BigDecimal... params) {
        if(params.length != PARAM_COUNT) {
            throw new IllegalArgumentException("wrong params for addition operator");
        }
        return params[1].subtract(params[0]);
    }

    public int getParamCount() {
        return PARAM_COUNT;
    }

    public OperatorType getOperatorType() {
        return OperatorType.SUBTRACTION;
    }
}
