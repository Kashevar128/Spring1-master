package ru.vinogradov;

import ru.vinogradov.myHomework_05.MyMainList;
import ru.vinogradov.myHomework_05.ProductRepository;

public class MyMain {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();// Создаем новый репозиторий продуктов
        MyMainList mainList = new MyMainList(productRepository);

        mainList.doSave(); //Сохраняем пользователей

        mainList.doFindById(); //Получаем пользователя по Id

        mainList.doUpdate(); //Обновляем поля пользователей

        mainList.doDeleteById(); //Удаляем пользователя по Id

        mainList.stop(); //Завершаем процессы

        //Метод doFindAll вшит внутри методов

    }
}
