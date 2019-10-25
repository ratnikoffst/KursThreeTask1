package ru.ratnikoff;

abstract class Fruit {
   protected float weigth;

    public abstract Fruit newInstance();

    public float getWeigth() {
        return weigth;
    }

    public void setWeigth(float weigth) {
        this.weigth = weigth;
    }
}
