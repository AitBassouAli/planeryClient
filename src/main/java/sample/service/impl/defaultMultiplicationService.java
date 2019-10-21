package sample.service.impl;

import sample.rest.CalculatorRestClient;
import sample.service.MultiplicationService;
import main.java.sample.dto.MultiplicationRequest;
import main.java.sample.dto.MultiplicationResponse;
import main.java.sample.builder.MultiplicationRequestBuilder;

public class defaultMultiplicationService implements MultiplicationService {

    private CalculatorRestClient calculatorRestClient;

    public defaultMultiplicationService() {
        calculatorRestClient = new CalculatorRestClient();
    }

    public int multiply(int number, int multiplier) {
        MultiplicationRequest request = MultiplicationRequestBuilder.builder()
                .multiply(number)
                .by(multiplier)
                .build();
        MultiplicationResponse response = calculatorRestClient.multiply(request);
        return response.getMultiplicationResult();
    }
}
