package se.melchander.assignment.assignment3.exception;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String input) {
        super("Invalid input: " + input);
    }
}
