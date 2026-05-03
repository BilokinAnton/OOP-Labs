package io.lab3;

import io.lab3.action.CarSorter;
import io.lab3.action.CarArrayCreator;
import io.lab3.action.Searcher;
import io.lab3.car.Car;
import io.lab3.tool.OutputFormatter;

/**
 * Лабораторна робота з ООП №2
 * Номери завдань:
 * - C11 = 5303 % 11 = 1
 */
public class Main {
    public static void main(String[] args) {

        // Створення масиву декількох Car
        Car[] carArr = CarArrayCreator.createCars();

        // Його вивід
        System.out.println("Вивід початкового масиву;");
        OutputFormatter.printCars(carArr);

        // Створення масиву з результатом
        Car[] result = CarSorter.sort(carArr);

        System.out.println("\n-----------\n");

        // Вивід результату
        System.out.println("Вивід відсортованого масиву:");
        OutputFormatter.printCars(result);

        System.out.println("\n-----------\n");

        // Пошук елемента відповідного заданому
        int resultSearch = Searcher.findIdentical(result, carArr[1]);

        // Його вивід
        System.out.print("Індекс цільового об'єкта");
        System.out.println(resultSearch);

    }
}