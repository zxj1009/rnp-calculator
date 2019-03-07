package com.airwallex.exercise.rnpcalculator.operator;


/**
 * Created by xiaojzhou on 3/5/19.
 */
public class OperatorFactory {


    public static Operator getOperator(OperatorType operatorType) {
        switch (operatorType) {
            case ADDITION:
                return new AddOperator();
            case SUBTRACTION:
                return new SubtractOperator();
            case MULTIPLICATION:
                return new MultiplyOperator();
            case DIVISION:
                return new DivideOperator();
            case SQRT:
                return new SqrtOperator();
            case UNDO:
                return new UndoOperator();
            case CLEAR:
                return new ClearOperator();
            default:
                return null;
        }
    }
}
