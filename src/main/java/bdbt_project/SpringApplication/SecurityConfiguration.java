package bdbt_project.SpringApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("user")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() { return
            NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/resources/static/**").permitAll()
                .antMatchers("/main").authenticated()
                .antMatchers("/main_admin").access("hasRole('ADMIN')")
                .antMatchers("/main_user").access("hasRole('USER')")
                .antMatchers("/edit_customer/{nr_klienta}").access("hasRole('ADMIN')")
                .antMatchers("/edit_address/{nr_adresu}").access("hasRole('ADMIN')")
                .antMatchers("/edit_service").access("hasRole('ADMIN')")
                .antMatchers("/edit_empl").access("hasRole('ADMIN')")
                .antMatchers("/edit_sauna").access("hasRole('ADMIN')")
                .antMatchers("/sauna_management").access("hasRole('ADMIN')")
                .antMatchers("/service_management").access("hasRole('ADMIN')")
                .antMatchers("/empl_management").access("hasRole('ADMIN')")
                .antMatchers("/customer_management").access("hasRole('ADMIN')")
                .antMatchers("/address_management").access("hasRole('ADMIN')")


                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/index")
                .logoutSuccessUrl("/index")
                .permitAll();
    }
}
