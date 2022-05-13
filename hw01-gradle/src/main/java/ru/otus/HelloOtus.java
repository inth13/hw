package ru.otus;


import com.google.common.collect.*;

import java.util.ArrayList;

public class HelloOtus {
    public static void main(String... args) {

        ArrayList<String> names = Lists.newArrayList("John", "Adam", "Jane");
        System.out.println(names);
    }
}
