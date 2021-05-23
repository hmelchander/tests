package se.melchander.assignment.assignment3.controller;

import se.melchander.assignment.assignment3.model.CalculationRequest;
import se.melchander.assignment.assignment3.model.CalculationResponse;
import se.melchander.assignment.assignment3.service.CalculationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest/v1")
public class CalculationController {

    private final CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping("/calculate/polish")
    ResponseEntity<CalculationResponse> newEmployee(@RequestBody CalculationRequest request) {
        CalculationResponse calculationResponse = new CalculationResponse();
        calculationResponse.setResult(calculationService.calculatePolishNotation(request.getExpression()));
        return ResponseEntity.ok().body(calculationResponse);
    }
}
