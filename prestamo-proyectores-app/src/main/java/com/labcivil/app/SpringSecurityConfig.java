package com.labcivil.app;

//import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import com.labcivil.app.auth.handler.LoginSuccessHandler;
import com.labcivil.app.models.service.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	 @Autowired
	 private LoginSuccessHandler successHandler;

	//UTILIZANDO JDBC
//	@Autowired
//	private DataSource dataSource;
	
	@Autowired
	private JpaUserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**", "/listar**", "/graficas", "/lab-civil",
				"/user/form2", "/cargar-proyectoresg", "/cargar-materiasg", "/cargar-estudiantesg", "/cargar-profesoresg",
				"/sendFecha", "/listadoFecha","/sendHora", "/listadoHora").permitAll()
				 .antMatchers("/ver/**").hasAnyRole("USER")
				 .antMatchers("/uploads/**").hasAnyRole("USER")
				 .antMatchers("/form/**").hasAnyRole("ADMIN")
				 .antMatchers("/eliminar/**").hasAnyRole("ADMIN")
				 .antMatchers("/registro/**").hasAnyRole("ADMIN")
				 .antMatchers("/materia/**").hasAnyRole("ADMIN")
				 .antMatchers("/profesor/**").hasAnyRole("ADMIN")
				 .antMatchers("/estudiante/**").hasAnyRole("USER")
//				.anyRequest().authenticated()
				.anyRequest().authenticated().and().formLogin()
//				.loginPage("/login").permitAll().and().logout().permitAll();				
				.successHandler(successHandler)
				.loginPage("/login").permitAll().and().logout().permitAll().and().exceptionHandling()
				.accessDeniedPage("/error_403");
	}
	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		
//		PasswordEncoder encoder = passwordEncoder();
//		UserBuilder users = User.builder().passwordEncoder(encoder:: encode);
//		build.inMemoryAuthentication().withUser(users.username("admin").password("12345").roles("ADMIN", "USER")).
//		withUser(users.username("carlos").password("12345").roles("USER"));
//		
//		UserBuilder users = User.builder().passwordEncoder(password -> {
//			return encoder.encode(password);
//		});
		
		
		//UTILIZANDO JDBC
//		build.jdbcAuthentication()
//		.dataSource(dataSource)
//		.passwordEncoder(passwordEncoder)
//		.usersByUsernameQuery("select username, password, enabled from users where username=?")
//		.authoritiesByUsernameQuery("select u.username, a.authority from authorities a inner join users u on (a.user_id=u.id) where u.username=?");

		//UTILIZANDO JPA
		build.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);

		
		/*
		 * Deprecated UserBuilder users = User.withDefaultPasswordEncoder();
		 */
		// Sin utilizar autenticación de BD
		// PasswordEncoder encoder =
		// PasswordEncoderFactories.createDelegatingPasswordEncoder();
		// UserBuilder users = User.builder().passwordEncoder(encoder::encode);
		//
		// build.inMemoryAuthentication()
		// .withUser(users.username("admin").password("123").roles("ADMIN", "USER"))
		// .withUser(users.username("carlos").password("123").roles("USER"));
	}
}
