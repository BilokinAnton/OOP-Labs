package io.lab3.car;

public class Car {
    private String model;
    private String brand;
    private int prodYear;
    private int maxSpeed;
    private double fuelConsumption;
    private boolean isElectro;

    public Car(String model, String brand, int prodYear, int maxSpeed, double fuelConsumption, boolean isElectro) {
        this.model = model;
        this.brand = brand;
        this.prodYear = prodYear;
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumption;
        this.isElectro = isElectro;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
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

        // Порівнюємо кожне поле
        return prodYear == car.prodYear &&
                maxSpeed == car.maxSpeed &&
                Double.compare(car.fuelConsumption, fuelConsumption) == 0 &&
                isElectro == car.isElectro &&
                model.equals(car.model) &&
                brand.equals(car.brand);
    }
}
