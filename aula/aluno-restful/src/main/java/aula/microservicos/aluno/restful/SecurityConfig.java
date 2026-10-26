package aula.microservicos.aluno.restful;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defauSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .headers(header -> header.frameOptions(hconfig -> hconfig.disable()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(withDefaults())
                .formLogin(withDefaults())
                .authorizeHttpRequests((requests) -> requests.requestMatchers("/h2-console/*").permitAll())
                .authorizeHttpRequests((requests) -> requests.requestMatchers("/aluno/versao").permitAll())
                .authorizeHttpRequests((requests) -> requests.requestMatchers("/aluno/token").authenticated())
                .authorizeHttpRequests((requests) -> requests.requestMatchers("/aluno").hasRole("PROFESSOR"));

        return http.build();
    }

    // @Bean
    // public InMemoryUserDetailsManager userDetailsService(PasswordEncoder
    // passwordEncoder) {

    // UserDetails user = User.withUsername("user")
    // .password("{noop}user")
    // .roles("USER")
    // .build();

    // UserDetails admin = User.withUsername("admin")
    // .password("{bcrypt}$2a$12$hgcXT2BRPpwh8U17GnTRve3pw7P/pV3Qh.ndNUfBRqr22OsJEfj9u")
    // .roles("USER", "ADMIN")
    // .build();

    // return new InMemoryUserDetailsManager(user, admin);
    // }

    @Bean
    public JdbcUserDetailsManager userDetailsServiceDataSource(DataSource datasource) {

        return new JdbcUserDetailsManager(datasource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }
}
