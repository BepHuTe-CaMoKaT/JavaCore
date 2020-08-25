
//Необходимо реализовать коллекцию целых чисел, которая позволяет выполнять операции:
//        добавления
//        удаления
//        поиска элемента по значению
//        При этом:
//        при добавлении нового элемента все элементы увеличивают своё значение на добавляемый элемент
//        при удалении - уменьшают своё значение на удаляемый элемент
//        Недопустим ввод в коллекцию null, символов и других значений, кроме целых чисел.
//        Результатом работы должен быть отдельный репозиторий github/bitbucket с README файлом, который описывает задание, сам класс и содержит инструкции по запуску приложения.

package com.lesson02Collections;

import java.util.ArrayList;
import java.util.List;

class MyCollection {
    private static List<Integer> values = new ArrayList<>();

    public MyCollection(List<Integer> values) {
        MyCollection.values = values;
    }

    public int getIndex(int index) {
        return values.get(index);
    }

    public void add(Integer value) {
        for (int i = 0; i< values.size(); i++) {
            values.set(i,values.get(i)+value);
        }
        values.add(value);
    }

    public void remove(Integer value) {
        for (int i = 0; i < values.size(); i++) {
            values.set(i,values.get(i) - value);
        }
        values.remove(value);

    }


    public double getAverage() {
        int sum = 0;
        double avg;
        for (int i = 0; i < values.size(); i++)
            sum += getIndex(i);
        avg = (float) sum / values.size();
        return avg;
    }

    public int maxValue() {
        int max = 0;
        for (int i = 0; i < values.size(); i++) {
            if (getIndex(i) > max)
                max = getIndex(i);
        }
        return max;
    }

    public int minValue() {
        int min = getIndex(0);
        for (int i = 0; i < values.size(); i++) {
            if (getIndex(i) < min)
                min = getIndex(i);
        }
        return min;
    }
    public void test(){
        System.out.println(values);
    }
}
class Main{
    public static void main(String[] args) {
        MyCollection list = new MyCollection(new ArrayList<>());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.test();

        list.remove(5);
        list.test();

        System.out.println(list.getIndex(1));


        System.out.println("Среднее число: " + list.getAverage());
        System.out.println("Максимальное число: " + list.maxValue());
        System.out.println("Минимальное число: " + list.minValue());

    }
}
