package io.lab3.action;

import io.lab3.car.Car;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarSorterTest {

    @Test
    void testSort_CorrectOrder() {
        // Перевірка базового функціоналу
        Car c1 = new Car("X5", "BMW", 2024, 250, 9.0, false);
        Car c2 = new Car("RAV4", "Toyota", 2023, 180, 7.5, false);
        Car c3 = new Car("A4 Old", "Audi", 2010, 210, 8.0, false);
        Car c4 = new Car("A4 New", "Audi", 2022, 210, 7.0, false);

        Car[] input = {c1, c2, c3, c4};

        Car[] sorted = CarSorter.sort(input);

        assertNotNull(sorted);
        assertEquals(4, sorted.length);

        assertEquals("Toyota", sorted[0].getBrand());
        assertEquals(2022, sorted[1].getProdYear());
        assertEquals(2010, sorted[2].getProdYear());
        assertEquals("BMW", sorted[3].getBrand());
    }

    @Test
    void testSort_Immutability() {
        Car c1 = new Car("Model 1", "Brand B", 2020, 200, 5.0, false);
        Car c2 = new Car("Model 2", "Brand A", 2021, 100, 5.0, false);
        Car[] input = {c1, c2};

        Car firstBefore = input[0];

        CarSorter.sort(input);

        assertEquals(firstBefore, input[0], "Оригінальний масив не повинен змінюватися");
    }

    @Test
    void testSort_NullInput() {
        assertNull(CarSorter.sort(null), "Метод має повертати null, якщо вхідний масив null");
    }

    @Test
    void testSort_EmptyArray() {
        Car[] empty = new Car[0];
        Car[] result = CarSorter.sort(empty);

        assertNotNull(result);
        assertEquals(0, result.length);
        assertNotSame(empty, result, "Має повертатися новий екземпляр масиву");
    }
}