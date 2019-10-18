package sample.service.impl;

import sample.rest.CalculatorRestClient;
import sample.service.MultiplicationService;
import main.java.sample.dto.MultiplicationRequest;
import main.java.sample.builder.MultiplicationRequestBuilder;

import javax.ws.rs.core.Response;

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
        Response response = calculatorRestClient.multiply(request);
        return 0;
    }
}
