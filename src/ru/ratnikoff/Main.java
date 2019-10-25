package ru.ratnikoff;

import javafx.concurrent.Worker;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static javafx.scene.input.KeyCode.T;

//        1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
//        2. Написать метод, который преобразует массив в ArrayList;
//        3. Большая задача:
//        Есть классы Fruit -> Apple, Orange (больше фруктов не надо);
//        Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//        Для хранения фруктов внутри коробки можно использовать ArrayList;
//        Сделать метод getWeight(), который высчитывает вес коробки, зная количество фруктов и вес одного фрукта (вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);
//        Внутри класса Коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true – если она равны по весу, false – в противном случае (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
//        Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую (помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами). Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
//        Не забываем про метод добавления фрукта в коробку.
//        4 Необходимо из плоского списка (это List<SomeClass>)
//        SomeClass {
//        int id;
//        String name;
//        }
//
//        id name
//        1 Test1
//        2 Test1
//        3 Test1
//        4 Test2
//        5 Test2
//        6 Test3
//        7 Test3
//        8 Test4
//
//        переложить данные в HashMap
//
//        должно получиться
//
//        Test1 {1,2,3}
//        Test2 {4,5}
//        Test3 {6,7}
//        Test4 {8}

public class Main {

    //   private static Object Fruit;

    public static void main(String[] args) {
        // 1 задача
        Object[] box1 = new Object[10];
        swapPos(box1, 2, 4);

        // 2 задача
        String[] strings = new String[]{"a", "b", "с"};
        Integer[] ints = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        conversion(strings);
        conversion(ints);

        // 3 задача
        ArrayList<Box> boxes = new ArrayList<>();
        Box<Fruit> boxF = new Box<>();
        Box<Apple> boxA = new Box<>();
        Box<Orange> boxO = new Box<>();
        for (float i = 1; i < 10; i++) {
            Orange orange = new Orange(i);
            Apple apple = new Apple(i + 1);
            boxO.addFruit(orange);
            boxA.addFruit(apple);
        }
        boxO.compare(boxA);
        boxO.compare(boxO);
        boxA.transfer(boxF);

        // 4 задание
        List<SomeClass> list = new LinkedList<>();//,
        list.add(new SomeClass(1, "Test1"));
        list.add(new SomeClass(2, "Test1"));
        list.add(new SomeClass(3, "Test1"));
        list.add(new SomeClass(4, "Test1"));
        list.add(new SomeClass(5, "Test2"));
        list.add(new SomeClass(6, "Test3"));
        list.add(new SomeClass(7, "Test3"));
        list.add(new SomeClass(8, "Test4"));

        // list.forEach(item->result.computeIfAbsent(item.getName(),k->new ArrayList<>()).add(item.getId()));
        Map<String, List<Integer>> result = list.stream().collect(Collectors.groupingBy(SomeClass::getName, Collectors.mapping(SomeClass::getId, Collectors.toList())));
    }

    private static <T> void conversion(T[] ints) {
        ArrayList<T> temp = new ArrayList<T>(Arrays.asList(ints));
    }

    private static void swapPos(Object[] array, int a, int b) {
        Object temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
