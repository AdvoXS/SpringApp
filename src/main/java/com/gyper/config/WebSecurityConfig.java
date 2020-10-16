package com.gyper.config;

import com.gyper.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    StudentService studentService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeRequests()
                .antMatchers("/login").not().fullyAuthenticated()
                .antMatchers("/students").hasRole("STUDENT")
                .anyRequest().authenticated().and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/").permitAll().and().logout().permitAll().logoutSuccessUrl("/");

    }
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //noinspection SpringConfigurationProxyMethods
        auth.userDetailsService(studentService).passwordEncoder(bCryptPasswordEncoder());
    }
}
