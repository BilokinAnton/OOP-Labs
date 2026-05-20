package io.lab4.text;

import io.lab4.text.Word;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WordTest {
    @Test
    void testWordCreationAndParsing() {
        String input = "Java";
        Word word = new Word(input);

        // Перевіряємо кількість літер у слові
        assertEquals(4, word.getLetters().length);

        // Перевіряємо першу та останню літеру
        assertEquals('J', word.getLetters()[0].getValue());
        assertEquals('a', word.getLetters()[3].getValue());

        // Перевіряємо метод toString()
        assertEquals("Java", word.toString());
    }
}