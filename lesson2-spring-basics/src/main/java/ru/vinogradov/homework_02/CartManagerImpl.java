package ru.vinogradov.homework_02;

import java.util.InputMismatchException;

public class CartManagerImpl implements CartManager {

    @Override
    public void startMenu() {
        System.out.println("Commands:\n" +
                "new - create new cart\n" +
                "add - add product with id\n" +
                "remove - remove product by id\n" +
                "show - show the products in the cart\n" +
                "exit - close console");
    }

    @Override
    public CartService commandNewCart() {
        return context.getBean(CartService.class);
    }

    @Override
    public void commandAddToCart(CartService cartService) {
        if (cartService == null) {
            System.out.println("You have to create the cart first");
            return;
        }
        System.out.println("Enter product id");
        long id = Filter.filterId(scanner.next());
        if(id == -1) return;
        cartService.addProductToCart(id);
    }


    @Override
    public void commandRemoveToCart(CartService cartService) {
        if (cartService == null) {
            System.out.println("You have to create the cart first");
            return;
        }
        System.out.println("Enter product id you want to add");
        long id = Filter.filterId(scanner.next());
        if(id == -1) return;
        cartService.removeProductFromCart(id);
    }

    @Override
    public void commandShowToCart(CartService cartService) {
        if (cartService == null) {
            System.out.println("You have to create the cart first");
            return;
        }
        cartService.getCartProducts().forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void commandExitToCart() {
        System.out.println("The program is completed");
    }

    @Override
    public TitleCommand dialog() {
        System.out.println("Enter command to operate with the cart");
        TitleCommand titleCommand = null;
        while (titleCommand == null) {
            titleCommand = Command.getMap(scanner.next().toLowerCase().trim());
        }
        return titleCommand;
    }
}
