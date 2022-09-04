package ru.vinogradov.homework_02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.titov.config.AppConfiguration;

import java.util.Scanner;

public interface CartManager {

    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

    Scanner scanner = new Scanner(System.in);

    public void startMenu();

    public CartService commandNewCart();

    public void commandAddToCart(CartService cartService);

    public void commandRemoveToCart(CartService cartService);

    public void commandShowToCart(CartService cartService);

    public void commandExitToCart();

    public TitleCommand dialog();


}

