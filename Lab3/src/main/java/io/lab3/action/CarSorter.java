package io.lab3.action;

import java.util.Arrays;
import java.util.Comparator;

import io.lab3.car.Car;

/**
 * Сортує масив автомобілів за критеріями
 *
 */
public class CarSorter {
    /**
     * Сортує масив об'єктів класу {@link Car} за критеріями швидкість та рік випуску
     * (є простою реалізацією)
     *
     * @param cars масив об'єктів {@link Car}
     * @return відсортований за першим (зростання) та другим (спадання) полем масив
     */
    public static Car[] sort(Car[] cars) {
        if (cars == null) return null;

        Car[] result = new Car[cars.length];
        System.arraycopy(cars, 0, result, 0, cars.length);

        // Використання стандартних засобів сортування
        Arrays.sort(result, Comparator
                // Сортування за першим полем (швидкістю)
                .comparingInt(Car::getMaxSpeed)
                // Сортування за другим (роком)
                .thenComparing(Comparator.comparingInt(Car::getProdYear).reversed())
        );
        return result;
    }
}
