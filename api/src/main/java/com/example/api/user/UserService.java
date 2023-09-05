package com.example.api.user;


import com.example.api.user.gateway.UserGatewayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserGateway userGateway;

    /**
     * 200 = > Success
     * 404 = > User not found , UserNotFoundException
     * 500 => System error , UserDatabaseException
     * @param id
     * @return
     */
    public UserResponse getById(int id){
        // Get data from API
        Optional<UserGatewayResponse> responseFromApi = userGateway.callApi(id);
        if (!responseFromApi.isPresent()) {
            throw new UserNotFoundException("User id=" + id + " not found in our system");
        }

        // Response from API
        UserGatewayResponse response = responseFromApi.get();
        // Create response to controller
        UserResponse result = new UserResponse();
        result.setId(response.getId());
        result.setFirtname(response.getName());
        result.setLastname(response.getUsername());
        return result;
    }

}
