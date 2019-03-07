package com.airwallex.exercise.rnpcalculator;


import com.airwallex.exercise.rnpcalculator.exception.InsufficientParamsException;
import com.airwallex.exercise.rnpcalculator.exception.InvalidInputException;
import com.airwallex.exercise.rnpcalculator.operation.*;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by xiaojzhou on 3/5/19.
 */
public class RnpCalculator {

    private static Logger LOGGER = LoggerFactory.getLogger(RnpCalculator.class);

    private Stack<BigDecimal> numbers;

    private Stack<OperationRecord> histories;

    private int currPosition;

    public RnpCalculator() {
        numbers = new Stack<BigDecimal>();
        histories = new Stack<OperationRecord>();
    }

    public void calculate(String userInput) throws InvalidInputException, InsufficientParamsException {
        LOGGER.info("----- start to calculate user input: '{}', current stack is '{}' -----", userInput, numbers);
        String[] inputs = userInput.split(" ");
        validateInput(inputs);
        currPosition = 1;
        for(String input: inputs) {
            LOGGER.debug("start to operate input: '{}', current stack is '{}'", input, numbers);
            if(NumberUtils.isParsable(input)) {
                // push number to stack
                BigDecimal number = new BigDecimal(input);
                numbers.push(number);
                histories.push(new OperationRecord(1));
            } else {
                // execute the operation
                OperatorType operatorType = OperatorType.fromString(input);
                Operation operation = OperationFactory.getOperation(operatorType);
                try {
                    operation.execute(numbers, histories);
                } catch (InsufficientParamsException e) {
                    e.setPosition(currPosition);
                    throw e;
                }
            }
            currPosition = currPosition + input.length() + 1;
            LOGGER.debug("after operate input: '{}', current stack is '{}'", input, numbers);
        }
        LOGGER.info("----- after calculate user input: '{}', current stack is '{}' -----", userInput, numbers);
    }

    public String getCurrNumbersForDisplay(){
        StringBuilder numbersForDisplay = new StringBuilder();
        numbersForDisplay.append("stack: ");
        BigDecimal[] numbersArray = new BigDecimal[numbers.size()];
        numbers.toArray(numbersArray);

        for (int i = 0; i < numbersArray.length; i++) {
            if(numbersArray[i].scale() > 10) {
                numbersForDisplay.append(numbersArray[i].setScale(10, BigDecimal.ROUND_DOWN));
            } else {
                numbersForDisplay.append(numbersArray[i]);
            }
            if(i < numbersArray.length - 1)
                numbersForDisplay.append(" ");
        }
        return numbersForDisplay.toString();
    }

    private void validateInput(String[] inputs) throws InvalidInputException {
        for(String input: inputs) {
            if(!NumberUtils.isParsable(input) && OperatorType.UNKNOWN.equals(OperatorType.fromString(input))) {
                LOGGER.warn("'{}' is not a number or a valid operator", input);
                throw new InvalidInputException(input);
            }
        }
    }
}
