package se.melchander.assignment.assignment2;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class CalculationServiceTests {

    private static final CalculationService service = new CalculationService();

    @Test
    public void addition_2_operands() {
        String result = service.calculatePolishNotation("+ 34 12");

        assertThat(result).isEqualTo("46.00");
    }

    @Test
    public void subtraction_2_operands() {
        String result = service.calculatePolishNotation("- 34 12");

        assertThat(result).isEqualTo("22.00");
    }

    @Test
    public void multiplication_2_operands() {
        String result = service.calculatePolishNotation("* 34 12");

        assertThat(result).isEqualTo("408.00");
    }

    @Test
    public void division_2_operands() {
        String result = service.calculatePolishNotation("/ 34 12");

        assertThat(result).isEqualTo("2.83");
    }

    @Test
    public void assignment_example1() {
        String result = service.calculatePolishNotation("+ + 0.5 1.5 * 4 10");

        assertThat(result).isEqualTo("42.00");
    }

    @Test
    public void assignment_example2() {
        String result = service.calculatePolishNotation("- 2e3 - 700 + 7 * 2 15");

        assertThat(result).isEqualTo("1337.00");
    }

    @Test
    public void assignment_example3() {
        String result = service.calculatePolishNotation("- -1.5 * 3.1415 / -7 -2");

        assertThat(result).isEqualTo("-12.50");
    }

    @Test
    public void assignment_example4() {
        String result = service.calculatePolishNotation("100500");

        assertThat(result).isEqualTo("100500.00");
    }

    @Test
    public void assignment_example5() {
        String result = service.calculatePolishNotation("1 2");

        assertThat(result).isEqualTo("error");
    }

    @Test
    public void assignment_example6() {
        String result = service.calculatePolishNotation("+ 1");

        assertThat(result).isEqualTo("error");
    }

    @Test
    public void assignment_1() {
        String result = service.calculatePolishNotation("* - 5 6 7");

        assertThat(result).isEqualTo("-7.00");
    }

    @Test
    public void assignment_2() {
        String result = service.calculatePolishNotation("/ - 5 6 7");

        assertThat(result).isEqualTo("-0.14");
    }

    @Test
    public void assignment_3() {
        String result = service.calculatePolishNotation("- 5 * 6 7");

        assertThat(result).isEqualTo("-37.00");
    }

    @Test
    public void assignment_4() {
        String result = service.calculatePolishNotation("/ * + - 6 8 10 12 7");

        assertThat(result).isEqualTo("13.71");
    }

    @Test
    public void assignment_5() {
        String result = service.calculatePolishNotation("+ 58 / - 20 * 0.5 + 18 10 6");

        assertThat(result).isEqualTo("59.00");
    }
}
