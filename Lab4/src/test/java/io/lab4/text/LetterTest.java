package io.lab4.text;

import io.lab4.text.Letter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LetterTest {
    @Test
    void testLetterCreation() {
        Letter letter = new Letter('A');
        assertEquals('A', letter.getValue());
        assertEquals("A", letter.toString());
    }
}
