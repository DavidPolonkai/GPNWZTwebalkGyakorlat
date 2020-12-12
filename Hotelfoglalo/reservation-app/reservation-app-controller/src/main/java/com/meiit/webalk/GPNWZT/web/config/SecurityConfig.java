package com.meiit.webalk.GPNWZT.web.config;

import com.meiit.webalk.GPNWZT.repositories.BookingPersonRepository;
import com.meiit.webalk.GPNWZT.services.security.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
 {
    

    @Autowired
    private org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder BCryptPasswordEncoder;

    @Autowired
    private BookingPersonRepository bookingPersonRepository;

    @Autowired
    private MyUserDetailsService myUserDetailService;

    @Override
    public void configure(AuthenticationManagerBuilder a)throws Exception{
        a.userDetailsService(myUserDetailService).passwordEncoder(BCryptPasswordEncoder);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/register","/reg","/proceeded").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/modifyuser",true)
        .failureUrl("/login?fail=true")
        .permitAll().and().logout().logoutSuccessUrl("/login");
        http.csrf().disable();
    }

    

    @Bean
    @Override
    public MyUserDetailsService userDetailsService(){
        return new MyUserDetailsService();
    }


    

}
