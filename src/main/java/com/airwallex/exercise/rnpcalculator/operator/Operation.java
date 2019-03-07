package com.airwallex.exercise.rnpcalculator.operator;

import java.math.BigDecimal;

/**
 * Created by xiaojzhou on 3/6/19.
 */
public class Operation {

    private BigDecimal[] input;

    private int outputCount;

    public Operation(int outputCount, BigDecimal ...input) {
        this.outputCount = outputCount;
        this.input = input;
    }

    public BigDecimal[] getInput() {
        return this.input;
    }

    public int getOutputCount() {
        return this.outputCount;
    }
}
