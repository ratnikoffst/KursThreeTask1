package ru.ratnikoff;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> boxList = new ArrayList<>();

    public void addFruit(T fruit) {
        boxList.add(fruit);
    }


    private float getSumWeith() {
        float sum = 0;
        for (T fruit : boxList) {
            sum += fruit.getWeigth();
        }
        return sum;
    }

    public boolean compare(Box boxA) {
        return (getSumWeith() - boxA.getSumWeith()) > 0;
    }

    public void transfer(Box<? super T> another) {
        another.boxList.addAll(this.boxList);
        this.boxList.clear();
    }
}
