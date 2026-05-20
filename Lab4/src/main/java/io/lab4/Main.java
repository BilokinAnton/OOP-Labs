package io.lab4;

import io.lab4.action.CarSorter;
import io.lab4.action.CarArrayCreator;
import io.lab4.action.Searcher;
import io.lab4.car.Car;
import io.lab4.tool.OutputFormatter;

/**
 * Лабораторна робота з ООП №4
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