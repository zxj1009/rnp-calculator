package com.airwallex.exercise.rnpcalculator.operation;


import com.airwallex.exercise.rnpcalculator.exception.InsufficientParamsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by xiaojzhou on 3/6/19.
 */
public class UndoOperation implements Operation {

    private static Logger LOGGER = LoggerFactory.getLogger(UndoOperation.class);

    public OperatorType getOperatorType() {
        return OperatorType.UNDO;
    }

    public void execute(Stack<BigDecimal> numbers, Stack<OperationRecord> histories) throws InsufficientParamsException {
        if(histories.isEmpty()) {
            //no history to undo
            LOGGER.info("there is no more previous operations to undo");
            return;
        }
        OperationRecord operationRecord = histories.pop();

        //pop up output from stack
        for(int i = 0; i < operationRecord.getOutputCount(); i++) {
            numbers.pop();
        }
        //push inputs into stack
        BigDecimal[] inputs = operationRecord.getInput();
        for(int i = inputs.length - 1; i > -1; i--) {
            numbers.push(inputs[i]);
        }
    }
}
