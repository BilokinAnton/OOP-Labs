package io.lab3.action;

import io.lab3.car.Car;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SearcherTest {

    @Test
    void testFindIdentical_Found() {
        // Перевірка базового функціоналу
        Car target = new Car("Model 3", "Tesla", 2022, 225, 0.0, true);
        Car[] cars = {
                new Car("RAV4", "Toyota", 2023, 180, 7.5, false),
                new Car("Model 3", "Tesla", 2022, 225, 0.0, true),
                new Car("5 Series", "BMW", 2021, 250, 6.2, false)
        };

        int index = Searcher.findIdentical(cars, target);

        assertEquals(1, index, "Метод мав знайти об'єкт за індексом 1");
    }

    @Test
    void testFindIdentical_NotFound() {
        // Перевірка за відсутності
        Car target = new Car("Mustang", "Ford", 1967, 200, 15.0, false);
        Car[] cars = {
                new Car("RAV4", "Toyota", 2023, 180, 7.5, false),
                new Car("Model 3", "Tesla", 2022, 225, 0.0, true)
        };

        int index = Searcher.findIdentical(cars, target);

        assertEquals(-1, index, "Якщо об'єкта немає, метод має повернути -1");
    }

    @Test
    void testFindIdentical_EmptyArray() {
        // Перевірка для випадку порожнього масиву
        Car target = new Car("Model 3", "Tesla", 2022, 225, 0.0, true);
        Car[] cars = new Car[0];

        int index = Searcher.findIdentical(cars, target);

        assertEquals(-1, index);
    }

    @Test
    void testFindIdentical_FirstAndLast() {
        Car target = new Car("RAV4", "Toyota", 2023, 180, 7.5, false);
        Car[] cars = {
                target, // Перший елемент
                new Car("5 Series", "BMW", 2021, 250, 6.2, false)
        };

        assertEquals(0, Searcher.findIdentical(cars, target));

        Car[] cars2 = {
                new Car("5 Series", "BMW", 2021, 250, 6.2, false),
                target
        };
        assertEquals(1, Searcher.findIdentical(cars2, target));
    }
}