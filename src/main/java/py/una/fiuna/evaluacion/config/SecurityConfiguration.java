package py.una.fiuna.evaluacion.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import py.una.fiuna.evaluacion.security.component.GetAuthEntryPoint;
//import py.una.fiuna.evaluacion.security.service.UserDetailsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Configuration
////@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

/*  //  @Autowired
  //  UserDetailsServiceImpl userDetailsService;

   // @Autowired
  //  GetAuthEntryPoint getAuthEntryPoint;



    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     //   auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable();
        http.sessionManagement().maximumSessions(1).expiredUrl("/expired");

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expression = http
                .authorizeRequests();

      //  http.exceptionHandling().authenticationEntryPoint(getAuthEntryPoint);



        setAntMatchers(expression);

        http.authorizeRequests().anyRequest().authenticated();


    }




    protected void setAntMatchers(
            ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expression) throws Exception {

        //URL para login con authorities permitAll()
        expression.antMatchers(HttpMethod.GET,"/logout/**").permitAll();
        expression.antMatchers(HttpMethod.POST, "/login/**").permitAll();

        expression.antMatchers(HttpMethod.GET, "/inicio/**").hasAnyAuthority("ROLE_ADMIN");
        expression.antMatchers(HttpMethod.GET, "/preguntas/**").hasAnyAuthority("ROLE_ADMIN");

        expression.antMatchers(HttpMethod.POST, "/preguntas/**").hasAnyAuthority("ROLE_ADMIN");


        expression.antMatchers(HttpMethod.PUT, "/preguntas/**").hasAnyAuthority("ROLE_ADMIN");


        expression.antMatchers(HttpMethod.DELETE, "/preguntas/**").hasAnyAuthority("ROLE_ADMIN");


    }


*/




}
