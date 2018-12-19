package Bookstore.Configuration;

import Bookstore.Service.MobyDickensUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MobyDickensUserDetailsService mobyDickensUserDetailsService;

    @Override
    public void configure(WebSecurity web) throws Exception {

        //
        //  don't need auth for viewing stylesheets!!!
        web.ignoring().antMatchers("/css/**", "/images/**", "/img/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()

                // public pages
                .antMatchers("/", "/contact-us", "/about-us", "/employment").permitAll()

                // authenticated pages
        .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                    .usernameParameter("username")
                    .passwordParameter("userpass")
                .permitAll()
                .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/logout-success")
                    .permitAll();

                // make this all work
                http.headers().frameOptions().disable();
                http.csrf().disable();

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin")
//                .password("secretpassword")
//                .roles("USER");
        auth.userDetailsService(mobyDickensUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}