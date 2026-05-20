package io.lab4.car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void testCarTextNormalization() {
        Car car = new Car(
                "Model   \t  S",
                "Tesla \t Motors",
                2022, 250, 0.0, true
        );

        // Перевірка, чи класи Text всередині Car виконали очищення
        assertEquals("Model S", car.getModel().toString());
        assertEquals("Tesla Motors", car.getBrand().toString());
    }

    @Test
    void testCarEqualsMethod() {
        Car car1 = new Car("Model S", "Tesla", 2022, 250, 0.0, true);

        Car car2 = new Car("Model  S", "Tesla   ", 2022, 250, 0.0, true);

        Car car3 = new Car("Model X", "Tesla", 2022, 250, 0.0, true);

        assertEquals(car1, car2, "Автомобілі мають бути однаковими після нормалізації тексту");
        assertNotEquals(car1, car3, "Автомобілі з різними моделями не повинні бути рівними");
    }

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

        assertEquals(model, car.getModel().toString());
        assertEquals(brand, car.getBrand().toString());
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
    }
}