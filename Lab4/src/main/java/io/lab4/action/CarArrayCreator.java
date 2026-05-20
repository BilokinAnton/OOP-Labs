package io.lab4.action;

import io.lab4.car.Car;

/**
 * Створює масив об'єктів класу {@link Car}
 */
public class CarArrayCreator {
    /**
     * Генерує масив об'єктів класу {@link Car} за вхідними даними
     *
     * @param models масив назв моделей
     * @param brands масив назв брендів
     * @param years масив років
     * @param speeds масив макс. швидкостей
     * @param consumptions масив споживань пального
     * @param electrics масив параметрів "є електромобілем"
     * @return масив об'єктів автомобілів
     */
    public static Car[] createCars(String[] models, String[] brands, int[] years,
                                   int[] speeds, double[] consumptions, boolean[] electrics) {

        // Перевірка на однакову довжину
        int length = models.length;
        if (brands.length != length || years.length != length ||
                speeds.length != length || consumptions.length != length || electrics.length != length) {
            throw new IllegalArgumentException("Масиви даних повинні мати однакову довжину!");
        }

        // Створення цільового масиву об'єктів
        Car[] cars = new Car[length];

        // Заповнення масиву об'єктами через конструктор
        for (int i = 0; i < length; i++) {
            cars[i] = new Car(
                    models[i],
                    brands[i],
                    years[i],
                    speeds[i],
                    consumptions[i],
                    electrics[i]
            );
        }

        return cars;
    }

    /**
     * Генерує тестовий масив об'єктів класу {@link Car}
     * @return масив об'єктів автомобілів
     */
    public static Car[] createCars() {
        // Створення масиву Car-ів
        Car[] cars = {
                new Car("RAV4", "Toyota", 2023, 180, 7.5, false),
                new Car("Model 3", "Tesla", 2022, 225, 0.0, true),

                new Car("5 Series", "BMW", 2021, 250, 6.2, false),
                new Car("Aventador", "Lamborghini", 2020, 350, 18.0, false),
                new Car("Fabia", "Skoda", 2019, 170, 5.4, false),
        };
        return cars;
    }
}
