package aula.microservicos.oauth2.keycloack;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/seguranca")
public class SegurancaController {

    @GetMapping("/info")
    public String info() {
        return "Endpoint público!";
    }

    @GetMapping("/user")
    public String user(Authentication authentication) {
        return "Olá, " + authentication.getName()
                + "! Você possui acesso de usuário.";
    }

    @GetMapping("/admin")
    public String admin(Authentication authentication) {
        return "Olá, " + authentication.getName()
                + "! Você possui acesso administrativo.";
    }
}
