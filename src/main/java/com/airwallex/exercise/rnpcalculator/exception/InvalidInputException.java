package com.airwallex.exercise.rnpcalculator.exception;

/**
 * Created by xiaojzhou on 3/6/19.
 */
public class InvalidInputException extends Exception {

    private String invalidInput;

    public InvalidInputException(String invalidInput) {
        this.invalidInput = invalidInput;
    }

    public String getMessage(){
        return String.format("'%s' is not a number or valid operator", invalidInput);
    }


}
