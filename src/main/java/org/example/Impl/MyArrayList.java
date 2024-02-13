package org.example.Impl;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList<T>  {

    private Object [] array;
    private int currentSize = 0;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.array = new String[DEFAULT_CAPACITY];
    }

    public void add(Object item) {
        if (item == null) {
            throw new NullPointerException("Item не может быть null!");
        }

        if (currentSize == array.length) {
            resize();
        }
        array[currentSize] = item;
        currentSize++;
    }

    public void add(int index, Object item) {
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
    }

    public void set(int index, Object item) {
        if (item == null) {
            throw new NullPointerException("Item не может быть null!");
        }

        if (index >= array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс за пределами массива!");
        }

        array[index] = item;
    }

    public void remove(Object item) {
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
    }

    public void remove(int index) {
        if (index >= array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс за пределами массива!");
        }

        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

        currentSize--;
    }

    public boolean contains(Object item) {
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

    public int indexOf(Object item) {
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

    public int lastIndexOf(Object item) {
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

    public Object get(int index) {
        if (index >= array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс за пределами массива!");
        }

        return array[index];
    }

    public boolean equals(MyArrayList otherList) {
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


    public int size() {
        return currentSize;
    }


    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void clear() {
        Arrays.fill(array, null);
        currentSize = 0;
    }

    private void resize() {
        Object[] newArray = new Object[(int) (array.length * 1.5 + 1)];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void bubbleSort() {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < currentSize - 1; i++) {
                if (((Comparable<T>) array[i]).compareTo((T) array[i + 1]) > 0) {
                    T temp = (T) array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }
}
