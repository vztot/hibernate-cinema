package com.vztot.cinema.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(getEncoder());
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register").permitAll()

                .antMatchers(HttpMethod.GET, "/movies/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/cinemahalls/**").hasRole("USER")
                .antMatchers("/shoppingcarts/**", "/orders/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/moviesessions/**").hasRole("USER")

                .antMatchers("/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/movies/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/cinemahalls/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/moviesessions/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}
