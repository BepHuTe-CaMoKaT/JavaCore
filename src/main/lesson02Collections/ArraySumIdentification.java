
//Дан массив целых чисел. Необходимо реализовать метод, который возвращает индексы массива, значения которых в сумме дают число переданное в массив.
//
//        Предполагается, что массив содержит только уникальные числа и всегда имеет искомые числа.
//        Один и тот же элемент не может быть использован дважды.
//
//        array = [3, 8, 15, 17], Number = 23
//        result = [1,2]
//
//        Т.е. индексы 1 и 2 (значение 8 и 15) в сумме дают искомое число 23


package main.lesson02Collections;

import java.util.Arrays;

public class ArraySumIdentification {

    public static void main(String[] args) {
        int[] array = {1,6,2,4,8};
        int value=10;
        System.out.println(Arrays.toString(findSum(array, value)));
    }

    public static int[] findSum(int[] arr, int number){
        int[] result;
        for(int i = 0; i < arr.length; ++i){
            for(int j = 0; j < arr.length; ++j){
                if (arr[i]+arr[j]==number) {
                    return new int[]{arr[i],arr[j]};
                }
            }
        }
        return null;
    }//найти в массиве такие числа, которые в сумме будут давать number, который введет юзер
}
