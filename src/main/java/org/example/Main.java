package org.example;

import org.example.Impl.StringListImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringList stringList = new StringListImpl(10);
        stringList.add("Vlad");
        stringList.add("Goga");
        stringList.add("Anna");

        stringList.add(6, "Grna");
        stringList.add(6, "Bob");
        stringList.set(6, "Vas");

        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.remove(6);
        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.remove("Goga");
        System.out.println(stringList.contains("Vlaad"));
        System.out.println(stringList.indexOf("Vlad"));
        stringList.add("Vlad");
        System.out.println(stringList.lastIndexOf("Vlad"));
        System.out.println(stringList.get(0));
        System.out.println(stringList.isEmpty());
        System.out.println(stringList.size());
        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.clear();
        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.add(null);





    }
}