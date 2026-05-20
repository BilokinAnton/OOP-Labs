package io.lab4.text;

/**
 * Представляє один розділовий знак.
 */
public class Punctuation {
    private final char mark;

    public Punctuation(char mark) {
        this.mark = mark;
    }

    public char getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return String.valueOf(mark);
    }
}