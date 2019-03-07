package com.airwallex.exercise.rnpcalculator;


import com.airwallex.exercise.rnpcalculator.exception.InsufficientParamsException;
import com.airwallex.exercise.rnpcalculator.exception.InvalidInputException;
import com.airwallex.exercise.rnpcalculator.operator.*;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by xiaojzhou on 3/5/19.
 */
public class RnpCalculator {

    private Stack<BigDecimal> numbers;

    private Stack<Operation> histories;

    private int currPosition;

    public RnpCalculator() {
        numbers = new Stack<BigDecimal>();
        histories = new Stack<Operation>();
    }

    public void calculate(String s) throws InvalidInputException, InsufficientParamsException {
        String[] inputs = s.split(" ");
        validateInput(inputs);
        currPosition = 1;
        for(String input: inputs) {
            if(NumberUtils.isParsable(input)) {
                // push number to stack
                BigDecimal number = new BigDecimal(input);
                numbers.push(number);
                histories.push(new Operation(1));
            } else {
                // execute the operation
                OperatorType operatorType = OperatorType.fromString(input);
                Operator operator = OperatorFactory.getOperator(operatorType);
                if(operator instanceof MathOperator) {
                    performMathOperation((MathOperator) operator);
                } else if(operator instanceof ClearOperator) {
                    performClearOperation();
                } else if(operator instanceof UndoOperator) {
                    performUndoOperation();
                }
            }
            currPosition = currPosition + input.length() + 1;
        }
    }

    public String printRemainingNumbers(){
        StringBuilder result = new StringBuilder();
        result.append("stack: ");
        BigDecimal[] numbersArray = new BigDecimal[numbers.size()];
        numbers.toArray(numbersArray);

        for (int i = 0; i < numbersArray.length; i++) {
            if(numbersArray[i].scale() > 10) {
                result.append(numbersArray[i].setScale(10, BigDecimal.ROUND_DOWN));
            } else {
                result.append(numbersArray[i]);
            }
            if(i < numbersArray.length - 1)
                result.append(" ");
        }
        return result.toString();
    }

    private void validateInput(String[] inputs) throws InvalidInputException {
        for(String input: inputs) {
            if(!NumberUtils.isParsable(input) && OperatorType.UNKNOWN.equals(OperatorType.fromString(input))) {
                throw new InvalidInputException(input);
            }
        }
    }

    private void performMathOperation(MathOperator operator) throws InsufficientParamsException {
        int paramCount = operator.getParamCount();
        if(numbers.size() < paramCount) {
            throw new InsufficientParamsException(operator.getOperatorType(), this.currPosition);
        }

        BigDecimal[] params = new BigDecimal[paramCount];
        for(int i = 0; i < paramCount; i++) {
            params[i] = numbers.pop();
        }

        BigDecimal newNumber = operator.calculate(params);
        numbers.push(newNumber);

        //add an operation history
        histories.push(new Operation(1, params));
    }

    private void performClearOperation() {
        int count = numbers.size();

        BigDecimal[] params = new BigDecimal[count];
        for(int i = 0; i < count; i++) {
            params[i] = numbers.pop();
        }

        numbers.clear();

        //add an operation history
        histories.push(new Operation(0, params));
    }

    private void performUndoOperation() {
        if(histories.isEmpty()) {
            //no history to undo
            return;
        }
        Operation operation = histories.pop();
        for(int i = 0; i < operation.getOutputCount(); i++) {
            numbers.pop();
        }
        BigDecimal[] inputs = operation.getInput();
        for(int i = inputs.length - 1; i > -1; i--) {
            numbers.push(inputs[i]);
        }
    }
}
