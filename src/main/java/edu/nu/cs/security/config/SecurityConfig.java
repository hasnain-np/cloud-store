package edu.nu.cs.security.config;

/**
 * Created by Hasnain on 11/29/2014.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/resources/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .failureUrl("/login?error") .permitAll()
            .and()
            .logout().logoutSuccessUrl("/login?logout").permitAll();

        http.csrf().disable();
    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        AuthenticationProvider authenticationProvider = new CustomAuthenticationProvider();
        auth.authenticationProvider(authenticationProvider);
    }

    private String getUserQuery() {
        return "SELECT user_name as username, password as password, true FROM UserVO WHERE user_name = ?";
    }

    private String getAuthoritiesQuery() {
         return "SELECT username as username, roles as authority FROM CLIENT WHERE username = ?";
    }
}