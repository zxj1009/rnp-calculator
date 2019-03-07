package com.airwallex.exercise.rnpcalculator.exception;

import com.airwallex.exercise.rnpcalculator.operation.OperatorType;

/**
 * Created by xiaojzhou on 3/6/19.
 */
public class InsufficientParamsException extends Exception {

    private OperatorType operatorType;

    private int position;

    public InsufficientParamsException(OperatorType operatorType) {
        this.operatorType = operatorType;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String getMessage(){
        return String.format("operator %s (position: %d): insufficient parameters", this.operatorType.getOpType(), this.position);
    }
}
