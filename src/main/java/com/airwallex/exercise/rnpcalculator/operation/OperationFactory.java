package com.airwallex.exercise.rnpcalculator.operation;


/**
 * Created by xiaojzhou on 3/5/19.
 */
public class OperationFactory {

    private static Operation addOperation = new AddOperation();
    private static Operation subtractOperation = new SubtractOperation();
    private static Operation multiplyOperation = new MultiplyOperation();
    private static Operation divideOperation = new DivideOperation();
    private static Operation sqrtOperation = new SqrtOperation();
    private static Operation undoOperation = new UndoOperation();
    private static Operation clearOperation = new ClearOperation();

    public static Operation getOperation(OperatorType operatorType) {
        switch (operatorType) {
            case ADDITION:
                return addOperation;
            case SUBTRACTION:
                return subtractOperation;
            case MULTIPLICATION:
                return multiplyOperation;
            case DIVISION:
                return divideOperation;
            case SQRT:
                return sqrtOperation;
            case UNDO:
                return undoOperation;
            case CLEAR:
                return clearOperation;
            default:
                return null;
        }
    }
}
