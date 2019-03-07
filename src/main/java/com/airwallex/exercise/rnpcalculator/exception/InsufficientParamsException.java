package com.airwallex.exercise.rnpcalculator.exception;

import com.airwallex.exercise.rnpcalculator.operator.OperatorType;

/**
 * Created by xiaojzhou on 3/6/19.
 */
public class InsufficientParamsException extends Exception {

    private OperatorType operatorType;

    private int offset;

    public InsufficientParamsException(OperatorType operatorType, int offset) {
        this.operatorType = operatorType;
        this.offset = offset;
    }

    @Override
    public String getMessage(){
        return String.format("operator %s (position: %d): insufficient parameters", this.operatorType.getOpType(), this.offset);
    }

}
