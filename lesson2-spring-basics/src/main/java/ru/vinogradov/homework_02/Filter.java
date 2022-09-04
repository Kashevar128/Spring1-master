package ru.vinogradov.homework_02;

public class Filter {

    public static long filterId(String objStr) {
        try{
            long id = Long.parseLong(objStr);
            return id;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }
}
