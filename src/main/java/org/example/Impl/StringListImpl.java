package org.example.Impl;

import org.example.StringList;
import java.util.NoSuchElementException;

public class StringListImpl implements StringList {

    private String[] array;
    private int currentSize = 0;

    public StringListImpl(int size) {
        this.array = new String[size];
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new NullPointerException("Item не может быть null!");
        }

        if (currentSize == array.length) {
            resize();
        }
        array[currentSize] = item;
        currentSize++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new NullPointerException("Item не может быть null!");
        }

        if (currentSize == array.length) {
            resize();
        }

        if (index >= array.length - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс за пределами массива!");
        }

        for (int i = array.length - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        currentSize++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (item == null) {
            throw new NullPointerException("Item не может быть null!");
        }

        if (index >= array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс за пределами массива!");
        }

        array[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new NullPointerException("Item не может быть null!");
        }

        boolean check = false;
        for (int i = 0; i < array.length ; i++) {
            if (item.equals(array[i])) {
                remove(i);
                check = true;
                break;
            }
        }
        if (!check) {
            throw new NoSuchElementException(item + " не найден в массиве!");
        }
        return item;
    }

    @Override
    public String remove(int index) {
        if (index >= array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс за пределами массива!");
        }

        String deletedObject = array[index];

        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

        array[array.length - 1] = null;
        currentSize--;

        return deletedObject;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new NullPointerException("Item не может быть null!");
        }

        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(item)) {
                check = true;
                break;
            }
        }
        return check;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            throw new NullPointerException("Item не может быть null!");
        }

        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(item)) {
                index = i;
                break;
            }

        }
        return index;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new NullPointerException("Item не может быть null!");
        }

        int index = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != null  && array[i].equals(item)) {
                index = i;
                break;
            }
        }

        return index;
    }

    @Override
    public String get(int index) {
        if (index >= array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс за пределами массива!");
        }

        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Other list cannot be null");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null && otherList.get(i) == null){
                continue;
            } else if (!array[i].equals(otherList.get(i))){
                    return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        currentSize = 0;
    }

    @Override
    public String[] toArray() {
        String[] newArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    private void resize() {
        String[] newArray = new String[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;

    }
}
