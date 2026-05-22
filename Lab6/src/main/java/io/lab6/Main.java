package io.lab6;

import io.lab6.collection.DLinkedHashSet;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Лабораторна робота з ООП №6
 * Номери завдань:
 * - C2 = 5303 % 2 = 1
 * - C3 = 5303 % 3 = 2
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("- Тестування конструктора 1 (Порожній) -");
        Set<String> emptySet = new DLinkedHashSet<>();
        emptySet.add("Java");
        emptySet.add("Python");
        emptySet.add("Java"); // Дублікат, не додасться
        System.out.println("Колекція 1: " + emptySet);
        System.out.println("Розмір: " + emptySet.size());

        System.out.println("\n- Тестування конструктора 2 (З одним об'єктом) -");
        Set<Integer> singleElementSet = new DLinkedHashSet<>(100);
        singleElementSet.add(200);
        singleElementSet.add(300);
        System.out.println("Колекція 2: " + singleElementSet);
        System.out.println("Містить 200 " + singleElementSet.contains(200));

        System.out.println("\n- Тестування конструктора 3 (З іншої колекції) -");
        // Створюємо стандартну колекцію Java з дублікатами
        List<Double> standardList = Arrays.asList(1.5, 2.5, 3.5, 1.5, 4.5);
        System.out.println("Початковий List (з дублікатами): " + standardList);

        Set<Double> collectionSet = new DLinkedHashSet<>(standardList);
        System.out.println("Колекція 3 (Set без дублікатів): " + collectionSet);

        System.out.println("\n- Тестування видалення (remove) -");
        collectionSet.remove(2.5);
        System.out.println("Після видалення 2.5: " + collectionSet);

        System.out.println("\n- Тестування retainAll (залишити лише спільні) -");
        List<Double> keepList = Arrays.asList(1.5, 4.5, 9.9);
        collectionSet.retainAll(keepList);
        System.out.println("Після retainAll(1.5, 4.5, 9.9): " + collectionSet);

        System.out.println("\n- Тестування clear -");
        collectionSet.clear();
        System.out.println("Після clear() порожня" + collectionSet.isEmpty());
    }
}