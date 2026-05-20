package io.lab5.toy;

public class Car extends Toy {
    private String size;

    public Car(String name, double price, int ageGroup, String size) {
        super(name, price, ageGroup);
        this.size = size;
    }

    @Override
    public String getType() { return "Машинка"; }

    public String getSize()        { return size; }
    public void setSize(String s)  { this.size = s; }

    @Override
    public String toString() {
        return super.toString() + " | розмір: " + size;
    }
}