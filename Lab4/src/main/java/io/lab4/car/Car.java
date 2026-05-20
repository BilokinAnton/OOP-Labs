package io.lab4.car;

import io.lab4.text.Text;

public class Car {
    private Text model;
    private Text brand;
    private int prodYear;
    private int maxSpeed;
    private double fuelConsumption;
    private boolean isElectro;

    public Car(String model, String brand, int prodYear, int maxSpeed, double fuelConsumption, boolean isElectro) {
        this.model = new Text(model);
        this.brand = new Text(brand);
        this.prodYear = prodYear;
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumption;
        this.isElectro = isElectro;
    }

    public Text getModel() {
        return model;
    }

    public Text getBrand() {
        return brand;
    }

    public int getProdYear() {
        return prodYear;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public boolean isElectro() {
        return isElectro;
    }

    @Override
    public boolean equals(Object o) {
        // Перевірка за адресою
        if (this == o) return true;

        // Перевірка за типом
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        // Перевірка за полем
        return prodYear == car.prodYear &&
                maxSpeed == car.maxSpeed &&
                Double.compare(car.fuelConsumption, fuelConsumption) == 0 &&
                isElectro == car.isElectro &&
                model.toString().equals(car.model.toString()) &&
                brand.toString().equals(car.brand.toString());
    }
}