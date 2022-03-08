package perscholas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import perscholas.service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailsServiceImpl userDetailsService;
	@Autowired
	public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
			.csrf().disable()
	        .authorizeRequests()
	        	.antMatchers("/static/**", "/error/**", "/login/**","/search").permitAll()
				.antMatchers("/admin/**", "/user/**").authenticated()
	        	.and()
	        .formLogin()
				.loginPage("/login")
	            .loginProcessingUrl("/loginSecurityPost")
	            .and()
	        .logout()
	            .invalidateHttpSession(true)
				.logoutUrl("/login/logout")
				.logoutSuccessUrl("/login/logoutSuccess")
	            .and()
	        .rememberMe()
				.key("SR_KEY_1")
	        	.tokenValiditySeconds(60 * 60 * 24 * 30)
	        	.rememberMeParameter("remember-me")
	        	.and()
			.exceptionHandling()
				.accessDeniedPage("/error/404");
	}
	
	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userDetailsService);
	    authProvider.setPasswordEncoder(passwordEncoder());
	    return authProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService);
	    auth.authenticationProvider(getAuthenticationProvider());
	}
	
	@Bean 
	@Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
}
