package io.lab5.space;

import io.lab5.toy.Toy;

import java.util.Arrays;

public class ToyRoom {
    private Toy[] toys;
    private int count;
    private double budget;
    private double spent;

    public ToyRoom(int capacity, double budget) {
        this.toys = new Toy[capacity];
        this.count = 0;
        this.budget = budget;
        this.spent = 0;
    }

    public void addToy(Toy toy) {
        if (toy == null) {
            System.out.println("Помилка: іграшка не може бути null.");
            return;
        }
        if (count >= toys.length) {
            System.out.println("Помилка: кімната заповнена.");
            return;
        }
        if (spent + toy.getPrice() > budget) {
            System.out.println("Помилка: недостатньо бюджету для \"" + toy.getName() + "\".");
            return;
        }
        toys[count++] = toy;
        spent += toy.getPrice();
    }

    // Сортування за ціною
    public void sortByPrice() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (toys[j].getPrice() > toys[j + 1].getPrice()) {
                    Toy temp = toys[j];
                    toys[j] = toys[j + 1];
                    toys[j + 1] = temp;
                }
            }
        }
    }

    // Пошук іграшок у діапазоні цін
    public void findByPriceRange(double min, double max) {
        if (min < 0 || max < min) {
            System.out.println("Помилка: некоректний діапазон цін.");
            return;
        }
        System.out.printf("Іграшки у діапазоні %.2f – %.2f грн:%n", min, max);
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (toys[i].getPrice() >= min && toys[i].getPrice() <= max) {
                System.out.println("  " + toys[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("  Нічого не знайдено.");
        }
    }

    public void printAll() {
        System.out.println("=".repeat(70));
        System.out.printf("Бюджет: %.2f грн | Витрачено: %.2f грн | Залишок: %.2f грн%n",
                budget, spent, budget - spent);
        System.out.println("=".repeat(70));
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + toys[i]);
        }
        System.out.println("=".repeat(70));
    }
}