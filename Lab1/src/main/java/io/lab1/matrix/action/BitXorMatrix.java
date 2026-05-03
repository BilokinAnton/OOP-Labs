package io.lab1.matrix.action;

/**
 * Логіка для виконання операції XOR над матрицями
 */
public class BitXorMatrix {
    /**
     * Виконує операцію xor для двох відповідних елементів матриці
     *
     * @param a Матриця 1 з елементами типу long
     * @param b Матриця 2 з елементами типу long
     * @return двовимірний масив (Матрицю) типу long
     */
    public static long[][] mXOR(long[][] a, long[][] b) {
        // Перевірка вхідних даних
        if (a == null || b == null) return null;

        int colLen = a.length;
        int rowLen = a[0].length;

        // Перевірка розмірності
        if (rowLen != b.length || colLen != b[0].length) {
            throw new IllegalArgumentException("Матриці мають бути однакової розмірності");
        }
        // Матриця результату
        long[][] result = new long[rowLen][colLen];

        // Обхід матриці
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                result[i][j] = a[i][j] ^ b[i][j];
            }
        }
        return result;
    }
}