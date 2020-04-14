package com.globeop.riskfeed.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.globeop.riskfeed.security.user.service.UserService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;
    
	/*
	 * @Autowired
	 * 
	 * @Qualifier("securityDataSource") private DataSource securityDataSource;
	 */
    
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * // use jdbc authentication ... oh yeah!!!
	 * auth.jdbcAuthentication().dataSource(securityDataSource);
	 * 
	 * }
	 */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //.antMatchers("/my-api/**").hasRole("MANAGER")
                //.antMatchers("/my-api/RiskAggregators**").hasRole("ADMIN")
                    .antMatchers(
                            "/registration**",
                            "/js/**",
                            "/css/**",
                            "/img/**",
                            "/webfonts/**",
                            "/popper.js/**",
                            "/webjars/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                        .loginPage("/login")
                            .permitAll()
                .and()
                    .logout()
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                .permitAll();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

	
	  @Bean
	  @ConfigurationProperties(prefix="security.datasource")
	  public DaoAuthenticationProvider authenticationProvider(){
		  
		  System.out.println(" <<<<<<<<<<<<<< security.datasource 1111111111 >>>>>>>>>>");
	  DaoAuthenticationProvider auth = new DaoAuthenticationProvider();		  
	  auth.setUserDetailsService(userService);
	  auth.setPasswordEncoder(passwordEncoder()); return auth; }
	 

	
	  @Override 
	  protected void configure(AuthenticationManagerBuilder auth) throws
	  Exception { auth.authenticationProvider(authenticationProvider()); }
	 

}
