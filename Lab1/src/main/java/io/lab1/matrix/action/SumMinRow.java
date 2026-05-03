package io.lab1.matrix.action;

public class SumMinRow {
    /**
     * Виконує додавання всіх найменших значень рядка
     *
     * @param matrix Довільна матриця з елементами типу long
     * @return сума найменших значень рядків
     */
    public static long sumMinRow(long[][] matrix) {

        if (matrix == null) {
            throw new IllegalArgumentException("Матриця не може бути null");
        }

        long result = 0;
        long min;

        // Обхід масиву та визначення найменшого числа, знайдене число додається до результату
        for (long[] i : matrix) {
            if (i == null || i.length == 0) continue;

            min = i[0];
            for (long j : i) {
                if (j < min) min = j;
            }
            result += min;
        }
        return result;
    }
}
