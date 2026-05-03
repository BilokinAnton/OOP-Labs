package io.lab1.matrix.tool;

import java.util.Random;

public class MatrixTool {
    private static final Random RANDOM = new Random();

    /**
     * Генерує матрицю випадкових чисел.
     *
     * @param rows кількість рядків
     * @param cols кількість стовпців
     * @return двовимірний масив типу long
     */
    public static long[][] generateMatrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Параметри повинні бути більшими за 0");
        }
        long[][] matrix = new long[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = RANDOM.nextInt();
            }
        }
        return matrix;
    }

    /**
     * Просто друкує матрицю в термінал
     *
     * @param matrix матриця чисел типу long
     */
    public static void printMatrix(long[][] matrix) {
        if (matrix == null) return;
        for (long[] i : matrix) {
            System.out.println();
            for (long j : i) {
                System.out.print(j + " ");
            }
        }
        System.out.println();
        System.out.println();
    }
}
