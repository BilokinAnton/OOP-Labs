package io.lab4.text;

import io.lab4.text.Punctuation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PunctuationTest {
    @Test
    void testPunctuationCreation() {
        Punctuation punctuation = new Punctuation(',');
        assertEquals(',', punctuation.getMark());
        assertEquals(",", punctuation.toString());
    }
}
