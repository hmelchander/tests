package se.melchander.assignment.assignment2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Scanner;

@SpringBootApplication
public class Assignment2Application implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Assignment2Application.class);

    private final CalculationService calculationService;

    public Assignment2Application(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    public static void main(String[] args) {
        LOG.info("Assignment started");
        try {
            SpringApplication.run(Assignment2Application.class, args);
        } catch (Exception e) {
            System.out.println(e.getCause().getMessage());
        }
        LOG.info("Assignment finished");
    }

    @Override
    public void run(String... args) throws Exception {
        // Need at least one arg to move forward
        if (args != null && args.length > 0) {
            Scanner scanner = new Scanner(new File(args[0]));
            while (scanner.hasNextLine()) {
                System.out.println(calculationService.calculatePolishNotation(scanner.nextLine()));
            }
        } else {
            throw new Exception("Invalid input");
        }
    }
}
