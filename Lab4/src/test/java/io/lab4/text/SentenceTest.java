package io.lab4.text;

import io.lab4.text.Sentence;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SentenceTest {
    @Test
    void testSentenceParsing() {
        String input = "Hello, world!";
        Sentence sentence = new Sentence(input);

        // Очікуємо 2 слова: "Hello" та "world"
        assertEquals(2, sentence.getWords().length);
        assertEquals("Hello", sentence.getWords()[0].toString());
        assertEquals("world", sentence.getWords()[1].toString());

        // Очікуємо 2 розділові знаки: ',' та '!'
        assertEquals(2, sentence.getPunctuations().length);
        assertEquals(',', sentence.getPunctuations()[0].getMark());
        assertEquals('!', sentence.getPunctuations()[1].getMark());

        // Перевіряємо метод toString() (має повертати оригінальне речення)
        assertEquals("Hello, world!", sentence.toString());
    }
}