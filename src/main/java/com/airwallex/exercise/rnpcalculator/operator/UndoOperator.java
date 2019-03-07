package com.airwallex.exercise.rnpcalculator.operator;


/**
 * Created by xiaojzhou on 3/6/19.
 */
public class UndoOperator implements Operator{

    public OperatorType getOperatorType() {
        return OperatorType.UNDO;
    }
}
