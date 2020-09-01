

//    Дан массив целых чисел.
//    Необходимо реализовать метод, которые определяет, содержит ли данный массив дубликаты
//
//    Пример:
//    Array: [4,5,6,6,8]
//    Result: true
//    Число 6 повторяется 2 раза
//
//    Array: [4,5,6,7,8]
//    Result: false
//    Дубликатов нет

package main.lesson02Collections;

public class Duplicates {
    static public void main(String[] args) {
        int[] arr = {4,5,5,6,6,8};
        System.out.println(hasDuplicates(arr));


    }

    public static boolean hasDuplicates(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]==arr[j]) {
                    System.out.println(arr[i] + " is duplicated!");
                    return true;
                }
            }
        }
        return false;
    }
}
