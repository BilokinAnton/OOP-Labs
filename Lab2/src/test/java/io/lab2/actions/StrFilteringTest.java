package io.lab2.actions;

import io.lab2.action.StrFiltering;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StrFilteringTest {

    @Test
    void testRemoveBeforeLastStandard() {
        // Тест базової логіки
        StringBuffer input = new StringBuffer("banana apple");
        String result = StrFiltering.removeBeforeLast(input).toString();

        assertEquals("bnna apple ", result);
    }

    @Test
    void testNewline() {
        // Тест з переносом рядка
        StringBuffer input = new StringBuffer("banana\n");
        String result = StrFiltering.removeBeforeLast(input).toString();

        assertEquals("bnna" + System.lineSeparator(), result);
    }

    @Test
    void testMultipleSpaces() {
        // Для декількох пробілів
        StringBuffer input = new StringBuffer("test    test");
        String result = StrFiltering.removeBeforeLast(input).toString();

        assertEquals("est est ", result);
    }

    @Test
    void testSingleCharacter() {
        // Один символ
        StringBuffer input = new StringBuffer("a b c");
        String result = StrFiltering.removeBeforeLast(input).toString();

        assertEquals("a b c ", result);
    }

    @Test
    void testOnlyNewlines() {
        // Лише нові рядки
        StringBuffer input = new StringBuffer("\n \n");
        String result = StrFiltering.removeBeforeLast(input).toString();

        assertEquals(System.lineSeparator() + System.lineSeparator(), result);
    }

    @Test
    void testNullInput() {
        assertNull(StrFiltering.removeBeforeLast(null));
    }

    @Test
    void testEmptyBuffer() {
        // Порожній рядок
        StringBuffer input = new StringBuffer();
        assertEquals("", StrFiltering.removeBeforeLast(input).toString());
    }

    @Test
    void testAllIdenticalChars() {
        // Всі однакові символи
        StringBuffer input = new StringBuffer("aaaaa");
        String result = StrFiltering.removeBeforeLast(input).toString();

        assertEquals("a ", result);
    }
}