package com.collections;

import java.util.Arrays;

public class ArraySumIdentification {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int value=7;
        System.out.println(Arrays.toString(task(array, value)));
    }

    public static int[] task(int[] arr, int number){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (i+j==number) return new int[]{arr[i],arr[j]};
            }
        }
        return null;
    }
}

//for (int i = 0; i < arr.length; i++) {
//        for (int j = i+1; j < arr.length; j++) {
//        if (i+j==number) return new int[]{arr[i],arr[j]};
//        }
//        }
//        return null;