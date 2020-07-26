
//Необходимо реализовать коллекцию целых чисел, которая позволяет выполнять операции:
//        добавления
//        удаления
//        поиска элемента по значению
//        При этом:
//        при добавлении нового элемента все элементы увеличивают своё значение на добавляемый элемент
//        при удалении - уменьшают своё значение на удаляемый элемент
//        Недопустим ввод в коллекцию null, символов и других значений, кроме целых чисел.
//        Результатом работы должен быть отдельный репозиторий github/bitbucket с README файлом, который описывает задание, сам класс и содержит инструкции по запуску приложения.

package com.collections;

import java.util.ArrayList;
import java.util.List;

class MyCollection extends ArrayList<Integer> {
    private static List<Integer> values = new ArrayList<>();

    public static void main(String[] args) {
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(5);
        values.remove(1);
        System.out.println(values);

    }

    public MyCollection(List<Integer> values) {
        MyCollection.values = values;
    }

    public int getIndex(int index) {
        return values.get(index);
    }

    
    public boolean add(Integer value) {
        for (Integer i : values) {
            i += value;
        }
        return values.add(value);
    }

    public boolean remove(Integer value) {

        for (Integer i : values) {
            i -= value;
        }
        return values.remove(value);
    }
//    @Override
//    public boolean add(Integer integer) {
//        return super.add(integer);
//    }


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


}
