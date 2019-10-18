package sample.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import main.java.sample.dto.MultiplicationRequest;

public class CalculatorRestClient {

    private static final String REST_URI
            = "http://localhost:8080/multiplication/";

    private Client client = ClientBuilder.newClient();

    public Response multiply(MultiplicationRequest request) {
        return client
                .target(REST_URI + "/multiply")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON));
    }
}
