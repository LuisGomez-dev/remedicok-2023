package com.remedicok.backend.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Deshabilita la protección contra CSRF
        http.csrf(csrf -> csrf.disable()).cors();

        // Configuración de los filtros de seguridad
        configureFilters(http);

        // Configuración de autorización de rutas
        configureAuthorization(http);

        // Configuración del manejador de acceso denegado personalizado
        configureExceptionHandling(http);
    }

    private void configureFilters(HttpSecurity http) throws Exception {
        // Agrega un filtro de autorización JWT después del filtro de autenticación de usuario y contraseña
        http.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    private void configureAuthorization(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests
                // Rutas permitidas sin autenticación
                .antMatchers("/webjars/**", "/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs/**").permitAll()
                .antMatchers("/index.html", "/js/**", "/css/**", "/fontawesome-free/css/**", "/*.ico").permitAll()
                .antMatchers(HttpMethod.POST, "/api/login").permitAll()
                // Todas las demás rutas requieren autenticación
                .anyRequest().authenticated());
    }

    private void configureExceptionHandling(HttpSecurity http) throws Exception {
        // Configura el manejador de acceso denegado personalizado
        http.exceptionHandling(handling -> handling
                .accessDeniedHandler(customAccessDeniedHandler));
    }

}




