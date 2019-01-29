package cc.lexium.utils;

import java.util.ArrayList;

public class Listener {

    public enum Type
    {
        READ,
        WRITE,
        EXECUTE
    }

    private static ArrayList<Class> classes = new ArrayList<>();

    public Listener(Class<?> target) {classes.add(target);}

    public void register() {

    }

}
