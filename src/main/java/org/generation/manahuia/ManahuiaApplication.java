package org.generation.manahuia;

import com.generation.manahuia.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean; // Añadí el punto y coma aquí

@SpringBootApplication
public class ManahuiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManahuiaApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilter() {
        FilterRegistrationBean<JwtFilter> registrationBean =
                new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/api/viajes/*");
        registrationBean.addUrlPatterns("/api/usuarios/*");
        return registrationBean;
    }//jwtFilter
}
