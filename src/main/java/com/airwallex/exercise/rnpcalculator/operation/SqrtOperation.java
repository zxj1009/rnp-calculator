package com.airwallex.exercise.rnpcalculator.operation;

import java.math.BigDecimal;

/**
 * Created by xiaojzhou on 3/5/19.
 */
public class SqrtOperation extends MathOperation {

    private static int PARAM_COUNT = 1;

    protected BigDecimal calculate(BigDecimal... params) {
        if(params.length != PARAM_COUNT) {
            throw new IllegalArgumentException("wrong params for addition operator");
        }
        return new BigDecimal(Math.sqrt(params[0].doubleValue()));
    }

    public int getParamCount() {
        return PARAM_COUNT;
    }

    public OperatorType getOperatorType() {
        return OperatorType.SQRT;
    }
}
