package io.lab3.action;

import io.lab3.car.Car;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarArrayCreatorTest {

    @Test
    void testCreateCars_ValidInput() {
        // Перевірка базового функціоналу
        String[] models = {"Model S", "Golf"};
        String[] brands = {"Tesla", "VW"};
        int[] years = {2022, 2020};
        int[] speeds = {250, 200};
        double[] consumptions = {0.0, 6.5};
        boolean[] electrics = {true, false};

        Car[] result = CarArrayCreator.createCars(models, brands, years, speeds, consumptions, electrics);

        assertNotNull(result);
        assertEquals(2, result.length);

        // Перевірка конкретних значень першого об'єкта
        assertEquals("Model S", result[0].getModel());
        assertEquals("Tesla", result[0].getBrand());
        assertTrue(result[0].isElectro());

        // Перевірка другого об'єкта
        assertEquals("VW", result[1].getBrand());
        assertEquals(200, result[1].getMaxSpeed());
    }

    @Test
    void testCreateCars_DifferentLengths_ThrowsException() {
        // Один масив коротший за інші
        String[] models = {"Model S", "Golf"};
        String[] brands = {"Tesla", "VW"};
        int[] years = {2022};
        int[] speeds = {250, 200};
        double[] consumptions = {0.0, 6.5};
        boolean[] electrics = {true, false};

        // Перевірка, що метод викидає IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            CarArrayCreator.createCars(models, brands, years, speeds, consumptions, electrics);
        });
    }

    @Test
    void testCreateCars_DefaultMethod() {
        // Тест методу без параметрів (тестовий набір)
        Car[] result = CarArrayCreator.createCars();

        assertNotNull(result);
        assertEquals(5, result.length);
        assertEquals("Toyota", result[0].getBrand());
        assertEquals("Skoda", result[4].getBrand());
    }

    @Test
    void testCreateCars_EmptyArrays() {
        // Перевірка роботи з порожніми масивами
        Car[] result = CarArrayCreator.createCars(
                new String[0], new String[0], new int[0],
                new int[0], new double[0], new boolean[0]
        );

        assertNotNull(result);
        assertEquals(0, result.length);
    }
}