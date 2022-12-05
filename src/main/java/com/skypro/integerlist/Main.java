package com.skypro.integerlist;


import com.skypro.integerlist.service.IntegerService;

import java.util.Arrays;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        IntegerService service = new IntegerService(100000);
        Integer[] integers = generateRandomArray();
//        Integer[] integers1 = Arrays.copyOf(integers, 100000);
//        Integer[] integers2 = Arrays.copyOf(integers, 100000);
//        Integer[] integers3 = Arrays.copyOf(integers, 100000);
        Integer[] integers4 = Arrays.copyOf(integers, 100000);

//        long start1 = System.currentTimeMillis();
//        service.sortBubble(integers1);
//        long test1 = System.currentTimeMillis() - start1;
//        System.out.println("Time for sortBubble: " + test1);
////
//        long start2 = System.currentTimeMillis();
//        service.sortInsertion(integers2);
//        long test2 = System.currentTimeMillis() - start2;
//        System.out.println("Time for sortInsertion: " + (test2));
//
//        long start3 = System.currentTimeMillis();
//        service.sortSelection(integers3);
//        long test3 = System.currentTimeMillis() - start3;
//        System.out.println("Time for sortSelection: " + test3);

        long start4 = System.currentTimeMillis();
        service.mergeSort(integers4);
        long test4 = System.currentTimeMillis() - start4;
        System.out.println("Time for mergeSort: " + test4);

    }

    public static Integer[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        Integer[] arr = new Integer[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
}
