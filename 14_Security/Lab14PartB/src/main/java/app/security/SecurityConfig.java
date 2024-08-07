package app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {return new UserDetailsServiceImpl();}
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http
                .authorizeHttpRequests( authConfig -> {authConfig
                        .requestMatchers(HttpMethod.GET, "/shop").permitAll()
                        .requestMatchers(HttpMethod.GET, "/orders").hasAuthority("sales")
                        .requestMatchers(HttpMethod.GET, "/orders").hasAuthority("finance")
                        .requestMatchers(HttpMethod.GET, "/payments").hasAuthority("finance")
                        .requestMatchers(HttpMethod.GET, "/manager").hasAuthority("manager")
                        .requestMatchers(HttpMethod.GET, "/manager").hasAuthority("topmanager")
                        .requestMatchers(HttpMethod.GET, "/topmanager").hasAuthority("topmanager");
                }).httpBasic(Customizer.withDefaults());

        return http.build();
    }


}
