package io.lab2.action;

/**
 * Надає логіку для обробки тексту
 */
public class StrFiltering {
    /**
     * В кожному слові заданого тексту,
     * видаляє всі попередні входження
     * останньої літери цього слова.
     *
     * @param text Текст для обробки
     * @return Оброблений текст
     */
    public static StringBuffer removeBeforeLast(StringBuffer text) {

        if (text == null) return null;

        StringBuffer result = new StringBuffer();
        int start = 0;
        int end;

        while ((end = text.indexOf(" ", start)) != -1 || (end = text.length()) > start) {

            StringBuffer word = new StringBuffer();
            word.append(text, start, end);

            start = end + 1;

            int length = word.length();
            if (length == 0) continue;

            boolean notNewLine = word.charAt(length - 1) != '\n';
            int target = notNewLine ? length - 1 : (length >= 2 ? length - 2 : -1);

            if (target != -1) {
                char lastChar = notNewLine ? word.charAt(length - 1) : word.charAt(length - 2);

                for (int i = target - 1; i >= 0; i--) {
                    if (word.charAt(i) == lastChar) {
                        word.deleteCharAt(i);
                    }
                }
            }

            result.append(word);
            if (notNewLine) {
                result.append(" ");
            }

        }
        return result;
    }
}
