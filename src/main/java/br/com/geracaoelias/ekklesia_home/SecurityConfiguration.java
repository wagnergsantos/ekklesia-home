package br.com.geracaoelias.ekklesia_home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

import br.com.geracaoelias.ekklesia_home.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
    static final String USER_ROLE_NAME = "USER";
    static final String ADMIN_ROLE_NAME = "ADMIN";

    @Autowired(required=true)
    private UserDetailsService userDetailsService;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userDetailsService);//.passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        
        http
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().authorizeRequests()
        .antMatchers(HttpMethod.GET, "/error/**").permitAll()
        .antMatchers(HttpMethod.GET, "/api/browser/**").permitAll()
        .antMatchers(HttpMethod.GET, "/api/**").permitAll()
        .antMatchers(HttpMethod.POST, "/api").hasRole(ADMIN_ROLE_NAME)
        .and().exceptionHandling()
        .authenticationEntryPoint(digestEntryPoint())
        .and().addFilter(digestAuthenticationFilter());
    }

    public DigestAuthenticationEntryPoint digestEntryPoint() {
        DigestAuthenticationEntryPoint digestAuthenticationEntryPoint = new DigestAuthenticationEntryPoint();
        digestAuthenticationEntryPoint.setKey("key");
        digestAuthenticationEntryPoint.setRealmName("realm");
        digestAuthenticationEntryPoint.setNonceValiditySeconds(60*60*24*14); // 14 days
        return digestAuthenticationEntryPoint;
    }

    public DigestAuthenticationFilter digestAuthenticationFilter() throws Exception {
        DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter();
        digestAuthenticationFilter.setAuthenticationEntryPoint(digestEntryPoint());
        digestAuthenticationFilter.setUserDetailsService(userDetailsServiceBean());
        return digestAuthenticationFilter;
}
    
    public static void main(String[] args)
    {
        System.out.println((new BCryptPasswordEncoder()).encode("admin"));
    }
}
