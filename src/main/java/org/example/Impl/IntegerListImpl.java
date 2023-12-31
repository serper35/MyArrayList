package org.example.Impl;

import org.example.IntegerList;
import org.example.StringList;

import java.util.NoSuchElementException;

public class IntegerListImpl implements IntegerList {

    private Integer[] array;
    private int currentSize = 0;

    public IntegerListImpl(int size) {
        this.array = new Integer[size];
    }

    @Override
    public Integer add(Integer item) {
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
    public Integer add(int index, Integer item) {
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
    public Integer set(int index, Integer item) {
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
    public Integer remove(Integer item) {
        if (item == null) {
            throw new NullPointerException("Item не может быть null!");
        }

        boolean check = false;
        for (int i = 0; i < array.length ; i++) {
            if (item.equals(array[i]) && array[i] != null) {
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
    public Integer remove(int index) {
        if (index >= array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс за пределами массива!");
        }

        Integer deletedObject = array[index];

        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

        array[array.length - 1] = null;
        currentSize--;

        return deletedObject;
    }

    @Override
    public boolean contains(Integer item) {
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
    public Integer indexOf(Integer item) {
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
    public Integer lastIndexOf(Integer item) {
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
    public Integer get(int index) {
        if (index >= array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс за пределами массива!");
        }

        return array[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
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
    public Integer size() {
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
    public Integer[] toArray() {
        Integer[] newArray = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    private void resize() {
        Integer[] newArray = new Integer[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;

    }

    private void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(Integer[] arr, int low, int high) {
        Integer pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                Integer temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Integer temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private int binarySearch(Integer[] arr, int low, int high, Integer key) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (arr[mid].equals(key)) {
                return mid;
            }
            if (arr[mid] > key) {
                return binarySearch(arr, low, mid - 1, key);
            }
            return binarySearch(arr, mid + 1, high, key);
        }
        return -1;
    }
}
