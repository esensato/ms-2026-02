package aula.microservicos.oauth2.keycloack;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

@Component
public class JwtConverter
        implements Converter<Jwt, AbstractAuthenticationToken> {

    private final JwtGrantedAuthoritiesConverter defaultConverter = new JwtGrantedAuthoritiesConverter();

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {

        Set<GrantedAuthority> authorities = new HashSet<>();

        // Authorities padrão do Spring Security (SCOPE_)
        Collection<GrantedAuthority> defaultAuthorities = defaultConverter.convert(jwt);

        if (defaultAuthorities != null) {
            authorities.addAll(defaultAuthorities);
        }

        // Roles do Realm
        Map<String, Object> realmAccess = jwt.getClaim("realm_access");

        if (realmAccess != null) {
            Object rolesObject = realmAccess.get("roles");

            if (rolesObject instanceof Collection<?> roles) {
                roles.stream()
                        .filter(String.class::isInstance)
                        .map(String.class::cast)
                        .map(role -> new SimpleGrantedAuthority(
                                "ROLE_" + role))
                        .forEach(authorities::add);
            }
        }

        // Roles do Client
        Map<String, Object> resourceAccess = jwt.getClaim("resource_access");

        if (resourceAccess != null) {

            Object clientObject = resourceAccess.get("faculdade-client");

            if (clientObject instanceof Map<?, ?> clientAccess) {

                Object rolesObject = clientAccess.get("roles");

                if (rolesObject instanceof Collection<?> roles) {
                    roles.stream()
                            .filter(String.class::isInstance)
                            .map(String.class::cast)
                            .map(role -> new SimpleGrantedAuthority(
                                    "ROLE_" + role))
                            .forEach(authorities::add);
                }
            }
        }

        String principal = jwt.getClaimAsString("preferred_username");

        return new JwtAuthenticationToken(
                jwt,
                authorities,
                principal != null ? principal : jwt.getSubject());
    }
}
