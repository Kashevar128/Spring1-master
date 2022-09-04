package ru.vinogradov.homework_02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.titov.config.AppConfiguration;

import java.util.Scanner;

public class CartMain {

    public static void main(String[] args) {
        StarterCart starter = new CartProcess();
        starter.run();
    }
}
