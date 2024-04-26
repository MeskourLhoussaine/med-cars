package ma.project.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin").password(passwordEncoder().encode("12345")).roles("USER", "ADMIN").build(),
                User.withUsername("houssain").password(passwordEncoder().encode("12345")).roles("USER").build()
                );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.formLogin(f -> {
            f.loginPage("/login").permitAll();
            f.defaultSuccessUrl("/dashboard/cars", true);
        }).authorizeHttpRequests(a -> {
            a.requestMatchers("/static/**", "/templates/**", "/", "/about","/services",
                    "/cars", "/faq", "/article", "/article/**", "/contact",
                    "/contact/**", "/reservation", "/reservation/**","/notFound").permitAll();
            a.anyRequest().authenticated();
        }).logout(l -> l.logoutSuccessUrl("/").permitAll()).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
