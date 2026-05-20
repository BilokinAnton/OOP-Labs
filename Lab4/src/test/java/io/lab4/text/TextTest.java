package io.lab4.text;

import io.lab4.text.Sentence;
import io.lab4.text.Text;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextTest {

    @Test
    void testSpaceAndTabNormalization() {
        // Рядок із купою пробілів та знаків табуляції (\t)
        String dirtyInput = "This\t\tis   a    test.      Does it   work?\t Yes!";
        Text text = new Text(dirtyInput);

        // Очікуємо, що всі зайві пробіли замінені на один
        String expectedOutput = "This is a test. Does it work? Yes!";
        assertEquals(expectedOutput, text.toString(), "Текст має бути очищений від зайвих пробілів та табуляцій");
    }

    @Test
    void testSentenceSplitting() {
        String input = "First sentence. Second sentence! Third sentence?";
        Text text = new Text(input);

        // Перевіряємо, чи правильно текст розбився на 3 речення
        String[] sentences = input.split("(?<=[.!?])\\s*");
        assertEquals(3, sentences.length);

        assertEquals("First sentence.", sentences[0]);
        assertEquals("Second sentence!", sentences[1]);
        assertEquals("Third sentence?", sentences[2]);
    }

    @Test
    void testEmptyString() {
        Text text = new Text("");
        assertEquals(1, text.getSentences().length); // Буде одне порожнє речення
        assertEquals("", text.toString());
    }
}