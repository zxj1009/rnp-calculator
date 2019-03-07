package com.airwallex.exercise.rnpcalculator.operation;

import java.math.BigDecimal;

/**
 * Created by xiaojzhou on 3/6/19.
 */
public class OperationRecord {

    /**
     * input of the operation
     */
    private BigDecimal[] input;

    /**
     * the count of the output numbers
     */
    private int outputCount;

    public OperationRecord(int outputCount, BigDecimal ...input) {
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
