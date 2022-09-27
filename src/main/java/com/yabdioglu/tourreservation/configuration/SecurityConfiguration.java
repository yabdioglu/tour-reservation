package com.yabdioglu.tourreservation.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserAuthService userAuthService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Spring security csrf'i(Cross Site Request Forgery) enable etmek.
        // Bizim buna ihtiyacımız olmadığı için disable ediyoruz.
        http.csrf().disable();

        // tarayıcının login popup'ını kapatalım
        http.httpBasic().authenticationEntryPoint(new AuthEntryPoint());

        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/1.0/auth").authenticated() // buraya gelen istekler authentication parametrelerini barındırmalı.
                .and()
                .authorizeRequests().anyRequest().permitAll(); // bunun dışında kalan herhangi request için authentication'a bakma

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // authenticated accesste bulunduktan sonra no authentication'a çektiğimizde secure olmasını engelliyoruz.
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userAuthService).passwordEncoder(passwordEncoder()); // eğer bi user bulmaya çalışıyorsan bu service'i kullan
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
