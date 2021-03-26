package com.marsMarketing.webhookreceiveSMS.securite;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
//@EnableWebSecurity
@EnableGlobalMethodSecurity(
		jsr250Enabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
	// . . .
    @Autowired
    private AuthenticationEntryPoint authEntryPoint;
 
    @Autowired
	DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select login as principal, password as credentials, "
					+ "active from user where login=?")
			.authoritiesByUsernameQuery("select login as principal, role as role "
										+ "from user_role where login=?")
			.passwordEncoder(new BCryptPasswordEncoder())
			.rolePrefix("ROLE_");
	}
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	System.out.println("WebSecurityConfig - configure");
    	// Permettre aprés modification de modifier des données 
        http.csrf().disable();
        http.cors().disable();
        
        
        // Toutes les requêtes envoyées a serveur web doivent être authentifiées
        //http.authorizeRequests().anyRequest().authenticated();
        http.authorizeRequests().antMatchers("/**").permitAll();
        // Use AuthenticationEntryPoint to authenticate user/password
        http.httpBasic().authenticationEntryPoint(authEntryPoint);        
        
    }
 /*
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    */
}