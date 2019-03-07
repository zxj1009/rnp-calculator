package com.airwallex.exercise.rnpcalculator.operator;

/**
 * Created by xiaojzhou on 3/5/19.
 */
public enum OperatorType {

    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    SQRT("sqrt"),
    UNDO("undo"),
    CLEAR("clear"),
    UNKNOWN("unknown");

    private String opType;

    OperatorType(String opType) {
        this.opType = opType;
    }

    public String getOpType() {
        return this.opType;
    }

    public static OperatorType fromString(String s){
        for(OperatorType operatorType : OperatorType.values()) {
            if(operatorType.opType.equals(s)){
                return operatorType;
            }
        }
        return OperatorType.UNKNOWN;
    }
}
