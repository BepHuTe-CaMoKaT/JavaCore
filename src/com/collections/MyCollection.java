
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

class MyCollection extends ArrayList<Integer> {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(5);
        System.out.println(arrayList);
    }
    public int getIndex(int index) {
        return get(index);
    }

    @Override
    public boolean add(Integer value) {
        for (int i = 0; i < size(); i++) {
            set(i,get(i)+value);
        }
        return super.add(value);
    }

    public boolean remove(Integer value) {
        for (int j = 0; j < size(); j++) {
            set(j, get(j) - value);
        }
        return super.remove(value);
    }

    public double getAverage(){
        int sum = 0;
        double avg;
        for(int i = 0; i < size(); i++)
            sum += getIndex(i);
        avg = (float)sum / size();
        return avg;
    }

    public int maxValue(){
        int max = 0;
        for(int i = 0; i < size(); i++) {
            if (getIndex(i) > max)
                max = getIndex(i);
        }
        return max;
    }

    public int minValue(){
        int min = getIndex(0);
        for(int i = 0; i < size(); i++) {
            if (getIndex(i) < min)
                min = getIndex(i);
        }
        return min;
    }
}
