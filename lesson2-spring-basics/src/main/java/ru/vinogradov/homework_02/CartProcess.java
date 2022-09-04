package ru.vinogradov.homework_02;

public class CartProcess extends CartManagerImpl implements StarterCart {
    CartService cartService = null;

    private void startProcess() {
        startMenu();

        while (true) {
            switch (dialog()) {
                case NEW: {
                    cartService = commandNewCart();
                    break;
                }
                case ADD: {
                    commandAddToCart(cartService);
                    break;
                }
                case RM: {
                    commandRemoveToCart(cartService);
                    break;
                }
                case SW: {
                    commandShowToCart(cartService);
                    break;
                }
                case EX: {
                    commandExitToCart();
                    return;
                }
            }
        }
    }


    @Override
    public void run() {
        startProcess();
    }
}
