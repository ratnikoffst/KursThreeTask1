package ru.ratnikoff;

public class Orange extends Fruit {

    public Orange(float wegth) {
        setWeigth(wegth);
    }

    @Override
    public Fruit newInstance() {
        return new Orange(weigth);
    }
}
