package io.lab5.toy;

public class Doll extends Toy {
    private String material;

    public Doll(String name, double price, int ageGroup, String material) {
        super(name, price, ageGroup);
        this.material = material;
    }

    @Override
    public String getType() { return "Лялька"; }

    public String getMaterial()        { return material; }
    public void setMaterial(String m)  { this.material = m; }

    @Override
    public String toString() {
        return super.toString() + " | матеріал: " + material;
    }
}
