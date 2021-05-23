package se.melchander.assignment.assignment1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Assignment1Application implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Assignment1Application.class);

    private final CalculationService calculationService;

    public Assignment1Application(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    public static void main(String[] args) {
        LOG.info("Assignment started");
        try {
            SpringApplication.run(Assignment1Application.class, args);
        } catch (Exception e) {
            System.out.println(e.getCause().getMessage());
        }
        LOG.info("Assignment finished");
    }

    @Override
    public void run(String... args) throws Exception {
        // Need at least three args to move forward
        if (args != null && args.length > 2) {
            // Check that all args are ints
            for (String arg : args) {
                try {
                    Integer.parseInt(arg);
                } catch (NumberFormatException e) {
                    throw new Exception("Invalid input. One arg is not an int: '" + arg + "'");
                }
            }

            // First arg i "k"
            int k = Integer.parseInt(args[0]);
            // From second arg, parse as int and add to "a"
            int[] a = new int[args.length - 1];
            for (int i = 1; i < args.length; i++) {
                a[i - 1] = Integer.parseInt(args[i]);
            }

            System.out.println("k: " + k);
            System.out.println("a: " + Arrays.toString(a));
            System.out.println(calculationService.calculateNumberOfPairs(k, a));
        } else {
            throw new Exception("Invalid input");
        }
    }
}
