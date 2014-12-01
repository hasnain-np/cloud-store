package edu.nu.cs.security.config;

/**
 * Created by Hasnain on 11/29/2014.
 */
import edu.nu.cs.security.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    DataSource dataSource;

    @Resource
    CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/resources/**", "/secure/**").permitAll()
                .anyRequest().authenticated();

        http
                .formLogin()
                .loginPage("/secure/login")
                .defaultSuccessUrl("/home").failureUrl("/secure/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/secure/login?logout")
                .permitAll();

        http.csrf().disable();
    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
        super.configure(auth);
    }
    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
    }

    /*private String getUserQuery() {
        return "SELECT user_name as username, password as password, true FROM UserVO WHERE user_name = ?";
    }

    private String getAuthoritiesQuery() {
         return "SELECT username as username, roles as authority FROM CLIENT WHERE username = ?";
    }*/

}