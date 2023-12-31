package org.example;

import java.util.Arrays;

public class SortingComparison {
    public static void main(String[] args) {
        Integer[] arr1 = generateRandomArray(100000);
        Integer[] arr2 = arr1.clone();
        Integer[] arr3 = arr1.clone();

        long start = System.currentTimeMillis();
        quickSort(arr1, 0, arr1.length - 1);
        System.out.println("Quick sort time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        Arrays.sort(arr2);
        System.out.println("Arrays.sort time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        bubbleSort(arr3);
        System.out.println("Bubble sort time: " + (System.currentTimeMillis() - start));
    }

    private static Integer[] generateRandomArray(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * size);
        }
        return arr;
    }

    private static void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Integer[] arr, int low, int high) {
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

    private static void bubbleSort(Integer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    Integer temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
