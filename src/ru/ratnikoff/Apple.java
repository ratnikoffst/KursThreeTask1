package ru.ratnikoff;

 public class Apple extends Fruit {

    public Apple(float wegth) {
        setWeigth(wegth);
    }

    @Override
    public Fruit newInstance() {
        return new Orange(weigth);
    }
}
