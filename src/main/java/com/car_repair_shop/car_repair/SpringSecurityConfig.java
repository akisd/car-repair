package com.car_repair_shop.car_repair;

import com.car_repair_shop.car_repair.handlers.SuccessLoginHandler;
import com.car_repair_shop.car_repair.security.LoginAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static com.car_repair_shop.car_repair.properties.Constants.ADMIN;
import static com.car_repair_shop.car_repair.properties.Constants.MEMBER;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginAuthenticationProvider loginAuthenticationProvider;

    @Autowired
    private SuccessLoginHandler successLoginHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
                    .loginPage("/login")
                    .successHandler(successLoginHandler)
                    .usernameParameter("username")
                    .passwordParameter("password")
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll()
            .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").anonymous()
                .antMatchers("/admin/**").hasAuthority(ADMIN)
                .antMatchers("/member/**").hasAuthority(MEMBER);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(loginAuthenticationProvider);
    }
}

