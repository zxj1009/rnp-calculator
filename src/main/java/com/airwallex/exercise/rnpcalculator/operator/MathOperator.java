package com.airwallex.exercise.rnpcalculator.operator;

import java.math.BigDecimal;

/**
 * Created by xiaojzhou on 3/5/19.
 */
public interface MathOperator extends Operator{

    BigDecimal calculate(BigDecimal...params);

    int getParamCount();

}
