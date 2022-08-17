package ru.titov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.vinogradov.homework_02.Cart;
import ru.titov.UserService;
import ru.titov.persist.UserRepository;
import ru.titov.persist.UserRepositoryImpl;
import ru.vinogradov.homework_02.CartService;

@Configuration
@ComponentScan("ru.vinogradov")
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
