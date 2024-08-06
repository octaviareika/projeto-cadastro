package com.projeto.cadastro.Projeto.Sistema.de.cadastro.model.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // indica personalizar as config de segurança
public class SecurityConfiguration {

    @Autowired
    private SecurityFIlter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Desabilita o csrf, pois não estamos usando sessão
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // configurando a sessão para não ser criada, não
            // devendo criar sessão para armazenar o estado do usuário
            .authorizeHttpRequests(auth -> auth // autoriza as requisições
                .requestMatchers("/user").permitAll() // permite que a requisição de login seja feita sem autenticação
                .anyRequest().authenticated()) // qualquer outra requisição deve ser autenticada
            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class); // adiciona o filtro de segurança antes do filtro de autenticação

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() { // hashing de senha
        return new BCryptPasswordEncoder();
    }
}
