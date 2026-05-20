package io.lab5.toy;

public abstract class Toy {
    private String name;
    private double price;
    private int ageGroup;

    public Toy(String name, double price, int ageGroup) {
        this.name = name;
        this.price = price;
        this.ageGroup = ageGroup;
    }

    public abstract String getType();

    public String getName()    { return name; }
    public double getPrice()   { return price; }
    public int getAgeGroup()   { return ageGroup; }

    public void setName(String name)       { this.name = name; }
    public void setPrice(double price)     { this.price = price; }
    public void setAgeGroup(int ageGroup)  { this.ageGroup = ageGroup; }

    @Override
    public String toString() {
        return String.format("%-10s | %-20s | вік: %d+ | ціна: %.2f грн",
                getType(), name, ageGroup, price);
    }
}