package cl.edutecno.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 		auth.inMemoryAuthentication()
 		.withUser("admin")
 		.password(passwordEncoder().encode("admin"))
 		.roles("ADMIN")
 		.and()
 		.withUser("user")
 		.password(passwordEncoder().encode("user"))
 		.roles("USER");
 
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//		.authorizeRequests()
//		.antMatchers("/").hasRole("USER")
//		.antMatchers("/login").permitAll()
//		.anyRequest().authenticated()
//		.and().formLogin().loginPage("/login").failureUrl("/login?error=true")
//		.usernameParameter("user")
//		.passwordParameter("password")
//		.defaultSuccessUrl("/");
		
		http.csrf().disable().authorizeHttpRequests().antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user/**").hasRole("USER")
		.antMatchers("/login/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").failureUrl("/login?error=true")
		.usernameParameter("user")
		.passwordParameter("password")
		.defaultSuccessUrl("/default", true)
		.and()
		.exceptionHandling().
		accessDeniedPage("/recurso-prohibido");
		
		
	}
	
	@Bean //inicialización de codificador de contraseña
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	
}

