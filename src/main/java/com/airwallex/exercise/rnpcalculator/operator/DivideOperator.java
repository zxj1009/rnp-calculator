package com.airwallex.exercise.rnpcalculator.operator;

import java.math.BigDecimal;

/**
 * Created by xiaojzhou on 3/5/19.
 */
public class DivideOperator implements MathOperator {

    private static int PARAM_COUNT = 2;

    public BigDecimal calculate(BigDecimal... params) {
        if(params.length != PARAM_COUNT) {
            throw new IllegalArgumentException("wrong params for addition operator");
        }
        return params[1].divide(params[0]);
    }

    public int getParamCount() {
        return PARAM_COUNT;
    }

    public OperatorType getOperatorType() {
        return OperatorType.DIVISION;
    }
}
