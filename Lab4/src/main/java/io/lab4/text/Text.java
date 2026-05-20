package io.lab4.text;

/**
 * Текст, що складається з масиву речень.
 */
public class Text {
    private final Sentence[] sentences;

    public Text(String originalText) {
        String cleanedText = cleanSpaces(originalText);

        // Розбиття тексту на речення
        String[] sentenceSplits = cleanedText.split("(?<=[.!?])\\s*");

        this.sentences = new Sentence[sentenceSplits.length];
        for (int i = 0; i < sentenceSplits.length; i++) {
            this.sentences[i] = new Sentence(sentenceSplits[i]);
        }
    }

    /**
     * Замінює послідовності пробілів та табуляцій на один пробіл
     */
    private String cleanSpaces(String input) {
        if (input == null) return "";
        return input.replaceAll("\\s+", " ");
    }

    public Sentence[] getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            sb.append(sentences[i].toString());
            if (i < sentences.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}