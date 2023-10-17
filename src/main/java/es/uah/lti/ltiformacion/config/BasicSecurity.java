package es.uah.lti.ltiformacion.config;

import es.uah.lti.ltiformacion.utils.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Order(79)
public class BasicSecurity extends WebSecurityConfigurerAdapter {

    private static final String REQUIRED_ROLE = "NAGIOS";
    @Autowired
    ApplicationContext appContext;
    @Value("${basic.auth.user}")
    private String basicAuthUsername;
    @Value("${basic.auth.password}")
    private String basicAuthPassword;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .antMatcher(Paths.HEALTH + "/**")
                .authorizeRequests().anyRequest()
                .hasRole(REQUIRED_ROLE)
                .and().httpBasic().authenticationEntryPoint(getBasicAuthEntryPoint())
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
        return new CustomBasicAuthenticationEntryPoint();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication().withUser(basicAuthUsername).password(encoder.encode(basicAuthPassword))
                .roles(REQUIRED_ROLE);
    }
}