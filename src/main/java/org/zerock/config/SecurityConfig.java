package org.zerock.config;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.zerock.security.CustomAccessDeniedHandler;
import org.zerock.security.CustomLoginSuccessHandler;
import org.zerock.security.CustomUserDetailsService;

import javax.sql.DataSource;

@Configuration
// EnableWebSecurity 를 통해 스프링 MVC 와 시큐리티를 결합.
@EnableWebSecurity
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Setter(onMethod_ = @Autowired)
//    private DataSource dataSource;

    @Override
    // XML 의 security:http 부분
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/security/all").permitAll()
                .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/security/member").access("hasRole('ROLE_MEMBER')");

//        http.exceptionHandling().accessDeniedPage("/accessError");
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());

//        http.formLogin();
        http.formLogin()
                .loginPage("/customLogin")
                .loginProcessingUrl("/login")
                .successHandler(loginSuccessHandler());

        http.logout()
                .logoutUrl("/customLogout")
                .logoutSuccessUrl("/");
//                .invalidateHttpSession(true)
//                .deleteCookies("remember-me", "JSESSION_ID");

//        http.rememberMe()
//                .key("zerock")
//                .tokenRepository(persistentTokenRepository())
//                .tokenValiditySeconds(604800);
    } // end configure(HttpSecurity)

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("configure...");
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN", "MEMBER");
        auth.inMemoryAuthentication().withUser("member").password("{noop}member").roles("MEMBER");
//
//        log.info("configure JDBC...");
//        String queryUser = "SELECT userid, userpw, enabled FROM tbl_member WHERE = userid = ?";
//        String queryDetails = "SELECT userid, auth FROM tbl_member_auth WHERE userid = ?";
//
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(passwordEncoder())
//                .usersByUsernameQuery(queryUser)
//                .authoritiesByUsernameQuery(queryDetails);
        // 자동 로그인 698 page
//        auth.userDetailsService(customUserService())
//                .passwordEncoder(passwordEncoder());
    } // end configure(AuthenticationMangerBuilder)

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new CustomLoginSuccessHandler();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//    @Bean
//    public UserDetailsService customUserService() {
//        return new CustomUserDetailsService();
//    }

//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
//        repo.setDataSource(dataSource);
//        return repo;
//    }
}
