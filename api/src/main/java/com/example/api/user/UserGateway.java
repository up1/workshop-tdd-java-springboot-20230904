package com.example.api.user;

import com.example.api.user.gateway.UserGatewayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class UserGateway {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${target_url}")
    private String targetUrl;

    public Optional<UserGatewayResponse> callApi(int id) {
        try {
            String url = targetUrl + "/users/" + id;
            UserGatewayResponse result = restTemplate.getForObject(url,
                    UserGatewayResponse.class);
            return Optional.ofNullable(result);
        } catch (RestClientException e) {
            return Optional.empty();
        }
    }

}

