package io.lab2;

import io.lab2.action.StrFiltering;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Лабораторна робота з ООП №2
 * Номери завдань:
 * - C3 = 5303 % 3 = 2 - "StringBuffer"
 * - C17 = 5303 % 17 = 16 - В кожному слові заданого тексту,
 *..........................видалити всі попередні входження
 *..........................останньої літери цього слова.
 */

public class Main {
    public static void main(String[] args) {
        StringBuffer text = new StringBuffer();

        // Зчитуємо шлях до файлу
        Scanner stdin = new Scanner(System.in);
        System.out.print("Вкажіть шлях до фалу: ");
        String filePath = stdin.nextLine();
        stdin.close();

        // Зчитуємо файл
        try (BufferedReader file = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = file.readLine()) != null) {
                text.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        // Обробка
        StringBuffer result = StrFiltering.removeBeforeLast(text);

        // Результат
        System.out.print(result);
    }
}
