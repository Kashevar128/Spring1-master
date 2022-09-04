package ru.vinogradov.homework_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Command {
    static Map map = new HashMap<String, TitleCommand>();

    static {
        map.put("new", TitleCommand.NEW);
        map.put("add", TitleCommand.ADD);
        map.put("remove", TitleCommand.RM);
        map.put("show", TitleCommand.SW);
        map.put("exit", TitleCommand.EX);
    }

    public static TitleCommand getMap(String key) {
        if (!searchKey(key)) {
            System.out.println("Invalid command, try again");
            return null;
        }
        return (TitleCommand) map.get(key);
    }

    private static boolean searchKey(String key) {
        List<String> list = new ArrayList<>(map.keySet());
        for (String k : list) {
            if (key.equals(k)) {
                return true;
            }
        }
        return false;
    }
}
