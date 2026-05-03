package io.lab1.matrix.actions;

import io.lab1.matrix.action.BitXorMatrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BitXorMatrixTest {
    @Test
    @DisplayName("Перевірка коректного виконання методу XOR")
    void testXOR() {
        long[][] matrixA = {
                {-14, 25, -50, 7},
                {42, -31, 0, 18},
                {-10, 49, -22, -45},
                {33, 12, -15, 50}
        };
        long[][] matrixB = {
                {-45, 12, 33, -10},
                {50, -5, 0, 28},
                {-22, 41, -50, 15},
                {7, -36, 19, -14}
        };
        long[][] target = {
                {33, 21, -17, -15,},
                {24, 26, 0, 14},
                {28, 24, 36, -36},
                {38, -48, -30, -64}
        };

        long[][] res = BitXorMatrix.mXOR(matrixA, matrixB);

        Assertions.assertArrayEquals(res, target, "Результат XOR операції некоректний");

    }
}
