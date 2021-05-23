package se.melchander.assignment.assignment1;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculationService {

    public int calculateNumberOfPairs(int k, int[] a) {
        // Create a list of Value objects - main purpose of this is to be able to keep track
        // if a value has been used in a pair to avoid duplicates.
        List<Value> input = new ArrayList<>();
        for (int value : a) {
            input.add(new Value(value, false));
        }

        // The number of unique pair combinations to be returned as result.
        int numberOfPairs = 0;

        int size = input.size();
        // Loop through all the a[i] values except the last value
        for (int i = 0; i < size - 1; i++) {
            boolean iUsed = input.get(i).used;
            // Only use a value if it has not been used in another pair
            if (!iUsed) {
                // Loop through all the a[j] values, starting from the value after the current a[i] value
                for (int j = i + 1; j < size; j++) {
                    boolean jUsed = input.get(j).used;
                    // Only use a value if it has not been used in another pair
                    if (!jUsed) {
                        int iValue = input.get(i).value;
                        int jValue = input.get(j).value;
                        if (iValue + jValue == k) {
                            numberOfPairs++;
                            input.get(j).used = true;
                            // If a matching pair has been found, break out of the loop
                            // as there is no need to look for more matches
                            break;
                        }
                    }
                }
            }
        }

        return numberOfPairs;
    }

    @AllArgsConstructor
    private static class Value {
        private final int value;
        private boolean used;
    }
}
