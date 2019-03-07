package com.airwallex.exercise.rnpcalculator;

import com.airwallex.exercise.rnpcalculator.exception.InsufficientParamsException;
import com.airwallex.exercise.rnpcalculator.exception.InvalidInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xiaojzhou on 3/5/19.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        RnpCalculator calculator = new RnpCalculator();

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            //read input from command line
            String userInput = reader.readLine();
            try {
                calculator.calculate(userInput);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (InsufficientParamsException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(calculator.getCurrNumbersForDisplay());
        }
    }
}
