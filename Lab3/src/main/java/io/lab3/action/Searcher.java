package io.lab3.action;

import io.lab3.car.Car;

/**
 * Надає функціонал для пошуку заданого об'єкта в масиві
 */
public class Searcher {
    /**
     * Виконує пошук заданого об'єкта в масиві з допомогою equals()
     *
     * @param cars масив для пошуку
     * @param target об'єкт для пошуку
     * @return індекс знайденого об'єкта
     */
    public static int findIdentical(Car[] cars, Car target) {
        if (cars == null || target == null) return -1;
        // Ітерація масивом та порівняння методом equals
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
