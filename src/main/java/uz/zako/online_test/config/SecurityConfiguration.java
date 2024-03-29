package uz.zako.online_test.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import uz.zako.online_test.security.JwtAuthEntryPoint;
import uz.zako.online_test.security.JwtConfigurer;
import uz.zako.online_test.security.JwtTokenProvider;

@Configuration
@EnableWebSecurity// hammasiga zakrit qiladi
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtAuthEntryPoint jwtAuthEntryPoint;

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthEntryPoint)
                .and()
                .cors()
                .and()
                .headers()
                .frameOptions()
                .and().and()
                .authorizeRequests()
//                .antMatchers("/api/admin/**").hasRole("ADMIN")
//                .antMatchers("/api/auth/**").permitAll()
//                .antMatchers("/api/client/**").hasRole("USER")
                .antMatchers("/api/**").permitAll()
                .antMatchers("/swagger-ui.html", "/webjars/**", "/swagger-resources/**", "/v2/**", "/csrf").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .disable()
                .apply(new JwtConfigurer(jwtTokenProvider))
        ;
    }
}
