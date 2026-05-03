package io.lab3.car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testConstructorAndGetters() {
        // Перевірка базового функціоналу
        String model = "Model 3";
        String brand = "Tesla";
        int year = 2022;
        int speed = 225;
        double consumption = 0.0;
        boolean isElectro = true;

        Car car = new Car(model, brand, year, speed, consumption, isElectro);

        assertEquals(model, car.getModel());
        assertEquals(brand, car.getBrand());
        assertEquals(year, car.getProdYear());
        assertEquals(speed, car.getMaxSpeed());
        assertEquals(consumption, car.getFuelConsumption(), 0.001);
        assertTrue(car.isElectro());
    }

    @Test
    void testEquals_DifferentObjects() {
        // Перевірка нерівності об'єктів
        Car car1 = new Car("X5", "BMW", 2021, 250, 9.0, false);
        Car car2 = new Car("X6", "BMW", 2021, 250, 9.0, false);

        assertNotEquals(car1, car2, "Об'єкти з різними моделями не мають бути рівними");
    }

    @Test
    void testEquals_WithNullAndDifferentClass() {
        // Перевірка з null
        Car car = new Car("X5", "BMW", 2021, 250, 9.0, false);

        assertNotEquals(null, car);
        assertNotEquals("Not a Car object", car);
    }
}