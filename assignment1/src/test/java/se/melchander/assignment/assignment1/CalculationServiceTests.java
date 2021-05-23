package se.melchander.assignment.assignment1;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class CalculationServiceTests {

    private static final CalculationService service = new CalculationService();

    @Test
    public void emptyInput() {
        int numberOfPairs = service.calculateNumberOfPairs(0, new int[0]);

        assertThat(numberOfPairs).isEqualTo(0);
    }

    @Test
    public void oneValue() {
        int numberOfPairs = service.calculateNumberOfPairs(3, new int[]{3});

        assertThat(numberOfPairs).isEqualTo(0);
    }

    @Test
    public void twoNumbers_match_1() {
        int numberOfPairs = service.calculateNumberOfPairs(6, new int[]{5, 1});

        assertThat(numberOfPairs).isEqualTo(1);
    }

    @Test
    public void twoNumbers_match_1_reverse() {
        int numberOfPairs = service.calculateNumberOfPairs(6, new int[]{1, 5});

        assertThat(numberOfPairs).isEqualTo(1);
    }

    @Test
    public void twoNumbers_noMatch() {
        int numberOfPairs = service.calculateNumberOfPairs(4, new int[]{5, 1});

        assertThat(numberOfPairs).isEqualTo(0);
    }

    @Test
    public void fourNumbers_match_1() {
        int numberOfPairs = service.calculateNumberOfPairs(6, new int[]{5, 1, 3, 4});

        assertThat(numberOfPairs).isEqualTo(1);
    }

    @Test
    public void fourNumbers_match_1_reverse() {
        int numberOfPairs = service.calculateNumberOfPairs(6, new int[]{4, 3, 1, 5});

        assertThat(numberOfPairs).isEqualTo(1);
    }

    @Test
    public void fourNumbers__match_2() {
        int numberOfPairs = service.calculateNumberOfPairs(6, new int[]{1, 5, 4, 2});

        assertThat(numberOfPairs).isEqualTo(2);
    }

    @Test
    public void fourNumbers__match_2_reverse() {
        int numberOfPairs = service.calculateNumberOfPairs(6, new int[]{2, 4, 5, 1});

        assertThat(numberOfPairs).isEqualTo(2);
    }

    @Test
    public void fourNumbers_noMatch() {
        int numberOfPairs = service.calculateNumberOfPairs(4, new int[]{1, 5, 2, 6});

        assertThat(numberOfPairs).isEqualTo(0);
    }

    @Test
    public void fourNumbers_noMatch_reverse() {
        int numberOfPairs = service.calculateNumberOfPairs(4, new int[]{6, 2, 5, 1});

        assertThat(numberOfPairs).isEqualTo(0);
    }

    @Test
    public void fourNumbers_repeatedNumbers_match_2() {
        int numberOfPairs = service.calculateNumberOfPairs(6, new int[]{1, 5, 1, 5});

        assertThat(numberOfPairs).isEqualTo(2);
    }

    @Test
    public void fourNumbers_repeatedNumbers_match_2_reverse() {
        int numberOfPairs = service.calculateNumberOfPairs(6, new int[]{5, 1, 5, 1});

        assertThat(numberOfPairs).isEqualTo(2);
    }

    @Test
    public void sixNumbers_sameNumbers_match_3() {
        int numberOfPairs = service.calculateNumberOfPairs(2, new int[]{1, 1, 1, 1, 1, 1});

        assertThat(numberOfPairs).isEqualTo(3);
    }

    @Test
    public void sixNumbers_repeatedNumbers_match_3() {
        int numberOfPairs = service.calculateNumberOfPairs(5, new int[]{2, 4, 1, 1, 4, 3});

        assertThat(numberOfPairs).isEqualTo(3);
    }

    @Test
    public void sevenNumbers_repeatedNumbers_match_3() {
        int numberOfPairs = service.calculateNumberOfPairs(5, new int[]{2, 4, 1, 1, 1, 4, 3});

        assertThat(numberOfPairs).isEqualTo(3);
    }

    @Test
    public void fiveNumbers_assignmentExampleInput() {
        int numberOfPairs = service.calculateNumberOfPairs(6, new int[]{2, 1, 4, 5, 3});

        assertThat(numberOfPairs).isEqualTo(2);
    }
}
