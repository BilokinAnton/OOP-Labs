package io.lab3.tool;

import io.lab3.car.Car;

/**
 * Виводить інформацію про автомобілі з масиву в консоль у форматованому вигляді.
 */
public class OutputFormatter {
    /**
     * Виводить інформацію про автомобілі з масиву в консоль у форматованому вигляді.
     *
     * @param cars вхідний масив об'єктів класу {@link Car}
     */
    public static void printCars(Car[] cars) {
        if (cars == null) return;
        for (Car c : cars) {
            System.out.printf("%-15s | %3d км/год | %4d рік%n",
                    c.getBrand(), c.getMaxSpeed(), c.getProdYear());        }
    }
}
