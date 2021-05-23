package se.melchander.assignment.assignment2;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class CalculationService {

    public String calculatePolishNotation(String expression) {
        String[] values = expression.split(" ");
        Double result = 0.0;

        if (values.length < 3) {
            // Need at least 3 values to do a calculation
            if (values.length == 1) {
                // If there is only one value, try to parse to double
                try {
                    result = Double.valueOf(values[0]);
                } catch (NumberFormatException e) {
                    return "error";
                }
            } else {
                return "error";
            }
        } else {
            Stack<Double> operands = new Stack<>();

            List<String> valuesList = Arrays.asList(values);
            // Read values right>left
            Collections.reverse(valuesList);

            for (String value : valuesList) {
                if ("+-*/".contains(value)) {
                    // When an operator is found, take the two top values from the stack
                    Double operand1 = operands.pop();
                    Double operand2 = operands.pop();
                    switch (value) {
                        case "+":
                            result = operand1 + operand2;
                            break;
                        case "-":
                            result = operand1 - operand2;
                            break;
                        case "*":
                            result = operand1 * operand2;
                            break;
                        case "/":
                            result = operand1 / operand2;
                            break;
                    }
                    // After calculation, push the result to the top of the operands stack
                    // as it is needed for the next calculation
                    operands.push(result);
                } else {
                    // Push operands to the stack for later calculation
                    operands.push(Double.valueOf(value));
                }
            }
        }

        DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance(Locale.US);
        decimalFormat.applyPattern("0.00");
        return decimalFormat.format(result);
    }
}
