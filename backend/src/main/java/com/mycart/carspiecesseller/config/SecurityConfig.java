package com.mycart.carspiecesseller.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mycart.carspiecesseller.config.jwt.JwtAuthorizationFilter;
import com.mycart.carspiecesseller.entities.enums.Role;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.headers().frameOptions().disable();
		http.cors().and().csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//http.authorizeHttpRequests((auth) -> auth.anyRequest().permitAll()) 
		http.authorizeRequests()
			.antMatchers("/**").permitAll()
			.antMatchers("/api/user/**").permitAll()
			.antMatchers("/api/client/sign-up").permitAll()//first allowed endpoints for all user roles
			.antMatchers("/api/client/findall").hasRole(Role.CLIENT.name())
		 .anyRequest().authenticated();
		
		 http.addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		//permitir acesso
		return http.build();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
	//why dont we use it as a component, because of scope
		@Bean
		 public JwtAuthorizationFilter jwtAuthorizationFilter () {
			 
			 return new JwtAuthorizationFilter();
		 }
		
		
		@Bean(BeanIds.AUTHENTICATION_MANAGER)
	    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception { 
	        return authenticationConfiguration.getAuthenticationManager();
	    }			

		@Bean
		public WebMvcConfigurer corsConfigurer() {
			
			return new WebMvcConfigurer() {

				@Override
				public void addCorsMappings(CorsRegistry registry) {
					
					registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
				}
				
			};
		}
		
		@Bean 
		public PasswordEncoder passwordEncoder() {
			
			return new BCryptPasswordEncoder();
		}
		
	
}