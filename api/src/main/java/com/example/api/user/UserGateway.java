package com.example.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class UserGateway {

    @Autowired
    private RestTemplate restTemplate;

    public Optional<UserGatewayResponse> callApi(int id) {
        try {
            UserGatewayResponse result = restTemplate.getForObject(
                    "https://jsonplaceholder.typicode.com/users/" + id,
                    UserGatewayResponse.class);
            return Optional.ofNullable(result);
        } catch (RestClientException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

}

class UserGatewayResponse {

}
