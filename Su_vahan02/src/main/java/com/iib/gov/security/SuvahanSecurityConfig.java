package com.iib.gov.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SuvahanSecurityConfig extends WebSecurityConfigurerAdapter{
	
//	@Autowired
//	private UserDetailsService userdetailservice;
	@Autowired
	private SeurityEntryPointHandler authenicatedEntryPoint;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		System.err.println("Request 1st coming here");
//		String user="iibadmin";
//		
// 
//			
//
//			auth.inMemoryAuthentication()
//	        .withUser(user)
//	        .password(encoder().encode("iibadmin@123"))
//	        .roles("USER");
			
		

			
			auth.inMemoryAuthentication()
			
			
			.withUser(
					User.withUsername("iibadmin")
					.password(encoder().encode("iibadmin@123"))
					//.password("{noop}sanu1234")
					.authorities("admin")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("NGI58")
					.password(encoder().encode("Hybrid@NGI58"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("NIA90")
					.password(encoder().encode("Hybrid@NIA90"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			
			.withUser(
					User.withUsername("RGI102")
					.password(encoder().encode("Hybrid@RGI102"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			
			
			.withUser(
					User.withUsername("RGI103")
					.password(encoder().encode("Hybrid@RGI103"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("ITGI106")
					.password(encoder().encode("Hybrid@ITGI106"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("TAGI108")
					.password(encoder().encode("Hybrid@TAGI108"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("BAGI113")
					.password(encoder().encode("Hybrid@BAGI113"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("ILGI115")
					.password(encoder().encode("Hybrid@ILGI115"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("CGI123")
					.password(encoder().encode("Hybrid@CGI123"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("FGI132")
					.password(encoder().encode("Hybrid@FGI132"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("USGI134")
					.password(encoder().encode("Hybrid@USGI134"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("SGI137")
					.password(encoder().encode("Hybrid@SGI137"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("RQGI141")
					.password(encoder().encode("Hybrid@RQGI141"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("SGI144")
					.password(encoder().encode("Hybrid@SGI144"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("HDFC146")
					.password(encoder().encode("Hybrid@HDFC146"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("MGI149")
					.password(encoder().encode("Hybrid@MGI149"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("LGI150")
					.password(encoder().encode("Hybrid@LGI150"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("KGI152")
					.password(encoder().encode("Hybrid@KGI152"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("NGI155")
					.password(encoder().encode("Hybrid@NGI155"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("AGI157")
					.password(encoder().encode("Hybrid@AGI157"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("GDGI158")
					.password(encoder().encode("Hybrid@GDGI158"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("ZGI159")
					.password(encoder().encode("Hybrid@ZGI159"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("UIGI545")
					.password(encoder().encode("Hybrid@UIGI545"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("OGI556")
					.password(encoder().encode("Hybrid@OGI556"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					);
//			
//			.withUser(
//					User.withUsername("015689")
//					.password(encoder().encode("NIVS01"))
//					//.password("{noop}sanu1234")
//					.authorities("ROLE_USER")
//					//.roles("USERs")
//					);
//			
	}
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
        
       http .authorizeRequests().antMatchers("/access/**","/swagger-ui/**")
       .hasAnyAuthority("ROLE_USER")
    //   .antMatchers("/access/**").hasIpAddress("0:0:0:0:0:0:0:1")
    //   .antMatchers("/access/**").hasIpAddress("192.168.0.120")
     //  .hasAnyRole("USER")
       
       .anyRequest()
       .authenticated()
      
       .and()
       .formLogin() 
        .and()
        .httpBasic().authenticationEntryPoint(authenicatedEntryPoint);
       http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
//       
       ////////////////////////////
	

	}
	
	//create BcryptPassencoder
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	

	

}
