package io.lab1.matrix.actions;
import io.lab1.matrix.action.SumMinRow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SumMinRowTest {

    @Test
    @DisplayName("Перевірка суми найменших елементів рядків")
    void testSumMinRow() {
        long [][] matrix = {{1, 4, 5, 1, 0}, {0, 1, 1, 8, 9}};
        long res = SumMinRow.sumMinRow(matrix);
        Assertions.assertEquals(0, res);
    }

    @Test
    @DisplayName("Перевірка з від'ємними числами")
    void testSumMinRowWithNegatives() {
        long[][] matrix = {
                {-1, -5, 0}, // min = -5
                {10, -2, 4}   // min = -2
        };
        long res = SumMinRow.sumMinRow(matrix);
        Assertions.assertEquals(-7L, res);
    }

}
