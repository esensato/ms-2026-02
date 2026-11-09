package aula.microservicos.oauth2.keycloack;

import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/seguranca")
public class LoginController {

    private final RestClient restClient;

    public LoginController() {
        this.restClient = RestClient.create();
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest loginRequest) {

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();

        body.add("client_id", "faculdade-client");
        body.add("username", loginRequest.username);
        body.add("password", loginRequest.password);
        body.add("grant_type", "password");

        return restClient.post()
                .uri("http://localhost:8080/realms/faculdade/protocol/openid-connect/token")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(body)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
