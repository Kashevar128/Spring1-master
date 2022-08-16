package ru.titov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.titov.Cart;
import ru.titov.UserService;
import ru.titov.persist.UserRepository;
import ru.titov.persist.UserRepositoryImpl;

@Configuration
public class AppConfiguration {

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryImpl();
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    @Scope("prototype")
    public Cart cart() {
        return new Cart();
    }
}
