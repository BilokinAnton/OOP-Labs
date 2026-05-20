package io.lab5.toy;

public class Ball extends Toy {
    private int diameterCm;

    public Ball(String name, double price, int ageGroup, int diameterCm) {
        super(name, price, ageGroup);
        this.diameterCm = diameterCm;
    }

    @Override
    public String getType() { return "М'яч"; }

    public int getDiameterCm()         { return diameterCm; }
    public void setDiameterCm(int d)   { this.diameterCm = d; }

    @Override
    public String toString() {
        return super.toString() + " | діаметр: " + diameterCm + " см";
    }
}