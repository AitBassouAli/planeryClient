package main.java.sample.builder;

import main.java.sample.dto.MultiplicationRequest;

public final class MultiplicationRequestBuilder {

    private int number;
    private int multiplier;

    public static MultiplicationRequestBuilder builder() {
        return new MultiplicationRequestBuilder();
    }

    public MultiplicationRequestBuilder multiply(int number) {
        this.number = number;
        return this;
    }

    public MultiplicationRequestBuilder by(int multiplier) {
        this.multiplier = multiplier;
        return this;
    }

    public MultiplicationRequest build() {
        MultiplicationRequest request = new MultiplicationRequest();
        request.setNumber(this.number);
        request.setMultiplier(this.multiplier);
        return request;
    }
}
