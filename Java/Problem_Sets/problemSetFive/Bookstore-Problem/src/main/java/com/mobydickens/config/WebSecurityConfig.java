/**
 * Created by Taras on 11/20/2016.
 */

package com.mobydickens.config;


import com.mobydickens.service.MobyDickensUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private MobyDickensUserDetailsService mobyDickensUserDetailsService;

    @Override
    public void configure(WebSecurity web) throws Exception {web.ignoring().antMatchers("/css/**", "/images/**");}

    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                    .antMatchers("/", "/home", "/search", "/contact-us", "/moby-dickens-login").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                .loginPage("/moby-dickens-login")
//                .failureUrl("/moby-dickens-login")
                .usernameParameter("username")
                .passwordParameter("userpass")
                .permitAll()
                    .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout-success"))
                .logoutSuccessUrl("/moby-dickens-logout-success")
                .permitAll();
                http.headers().frameOptions().disable();
                http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {

//        auth
//                .inMemoryAuthentication()
//                .withUser("admin")
//                .password("123456")
//                .roles("USER");
        auth.userDetailsService(mobyDickensUserDetailsService).passwordEncoder(new PlaintextPasswordEncoder());
    }
}
