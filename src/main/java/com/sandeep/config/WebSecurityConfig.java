package com.sandeep.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	 http
         .authorizeHttpRequests(authorize -> authorize
             .requestMatchers("/login", "/resources/**").permitAll()  // Allow access to login and resources
             .anyRequest().authenticated()  // All other requests require authentication
         )
         .formLogin(form -> form
             .loginPage("/login")  // Custom login page
             .defaultSuccessUrl("/redirectRegister", true)  // Redirect to Registration microservice
             .permitAll()
         )
         .logout(logout -> logout
             .permitAll()
         );

     return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var user = User.builder()
                .username("sandeepbarik399@gmail.com")
                .password(passwordEncoder().encode("sandeep@12345"))  // Encode password
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Use BCrypt for password encoding
    }
}

