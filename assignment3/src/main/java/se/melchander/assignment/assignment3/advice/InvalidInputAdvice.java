package se.melchander.assignment.assignment3.advice;

import se.melchander.assignment.assignment3.exception.InvalidInputException;
import se.melchander.assignment.assignment3.model.CalculationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvalidInputAdvice {

    @ResponseBody
    @ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    CalculationResponse invalidInputHandler(InvalidInputException ex) {
        CalculationResponse calculationResponse = new CalculationResponse();
        calculationResponse.setMessage(ex.getMessage());
        return calculationResponse;
    }
}
