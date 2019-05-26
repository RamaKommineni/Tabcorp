package com.tabcorp.application.security;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;

@EnableOAuth2Sso
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*
	private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
	private final UserDetailsService userDetailsService;


   public ServerSecurityConfig(CustomAuthenticationEntryPoint customAuthenticationEntryPoint, @Qualifier("userService") UserDetailsService userDetailsService) {
       this.customAuthenticationEntryPoint = customAuthenticationEntryPoint;
       this.userDetailsService = userDetailsService;
   }  

   @Bean
   public DaoAuthenticationProvider authenticationProvider() {
       DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
       provider.setPasswordEncoder(passwordEncoder());
       provider.setUserDetailsService(userDetailsService);
       return provider;
   }

   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }

   @Bean
   @Override
   public AuthenticationManager authenticationManagerBean() throws Exception {
       return super.authenticationManagerBean();
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
	   
       http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and()
               .authorizeRequests()
               .antMatchers("/api/signin").permitAll()
               .antMatchers("/api/bet/**").hasAnyAuthority("ADMIN", "USER")
               .antMatchers("/api/user/**").hasAuthority("ADMIN")
               .antMatchers("/api/**").authenticated()
               //.anyRequest().authenticated()
               .and().exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint).accessDeniedHandler(new CustomAccessDeniedHandler());      
   }*/

}