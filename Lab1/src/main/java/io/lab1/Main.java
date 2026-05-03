package io.lab1;

import io.lab1.matrix.tool.MatrixTool;
import io.lab1.matrix.action.BitXorMatrix;
import io.lab1.matrix.action.SumMinRow;

/**
 * Лабораторна робота з ООП №1
 * <p>
 * Номери завдань:
 * - C5 = 5303 % 5 = 3 - побітове виключне “але”
 * - C7 = 5303 % 7 = 4 - long type
 * - C11 = 5303 % 11 = 1 - Обчислити суму найменших елементів кожного рядка матриці
 */

public class Main {
    public static void main(String[] args) {
        // Генерація матриць
        long[][] a = MatrixTool.generateMatrix(3, 3);
        long[][] b = MatrixTool.generateMatrix(3, 3);

        // Вивід матриць у термінал
        System.out.print("Матриця A");
        MatrixTool.printMatrix(a);
        System.out.print("Матриця B");
        MatrixTool.printMatrix(b);

        // Побітове Xor для відповідних елементів матриць
        long[][] resMatrix = BitXorMatrix.mXOR(a, b);

        // Вивід вихідної матриці C
        System.out.print("Матриця C");
        MatrixTool.printMatrix(resMatrix);

        // Сума найменших елементів рядків
        long result = SumMinRow.sumMinRow(resMatrix);
        System.out.printf("\u001B[32m" + "%s" + "\u001B[1m" + " %d" + "\u001B[0m" + "\n",
                "Сума найменших елементів рядків:",
                result);
    }
}
