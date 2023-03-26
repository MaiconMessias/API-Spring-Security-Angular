package praticando.securityspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/user/user/**")
                .hasAnyRole("USER", "ADMIN")
                .requestMatchers("/api/user/listarAllUsers")
                .hasAnyRole("USER", "ADMIN")
                .requestMatchers("/api/user/listarPorId/**")
                .hasAnyRole("USER", "ADMIN")
                .requestMatchers("/api/user/salvarUsuario")
                .hasAnyRole("USER", "ADMIN")
                .requestMatchers("/api/user/deletarUsuario/**")
                .hasAnyRole("USER", "ADMIN")
                .requestMatchers("/")
                .hasAnyRole("USER", "ADMIN")
                .and()
                .httpBasic()
                .and()
                .cors();

        return http.build();
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, UserDetailsServiceImpl userDetailService)
            throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                                    .userDetailsService(userDetailService)
                                    .passwordEncoder(passwordEncoder())
                                    .and()
                                    .build();
    }

}