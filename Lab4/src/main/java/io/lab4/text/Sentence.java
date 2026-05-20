package io.lab4.text;

import java.util.ArrayList;

/**
 * Речення, що складається з масиву слів та розділових знаків.
 */

public class Sentence {
    private final Word[] words;
    private final Punctuation[] punctuations;

    // Масив, який запам'ятовує правильний порядок всього (слів, знаків і пробілів)
    private final Object[] elements;

    public Sentence(String sentenceStr) {
        // Створюємо списки, бо ми ще не знаємо точної кількості елементів
        ArrayList<Word> wordList = new ArrayList<>();
        ArrayList<Punctuation> punctList = new ArrayList<>();
        ArrayList<Object> elementList = new ArrayList<>();

        // Розбиваємо текст на шматочки по пробілах (наприклад: ["Привіт,", "світе!"])
        String[] parts = sentenceStr.trim().split("\\s+");

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];

            // 1. Витягуємо слово (видаляємо з шматочка всі знаки пунктуації)
            String wordStr = part.replaceAll("[\\p{Punct}]", "");
            if (!wordStr.isEmpty()) {
                Word word = new Word(wordStr);
                wordList.add(word);
                elementList.add(word); // Додаємо у загальну чергу
            }

            // 2. Витягуємо розділові знаки (видаляємо все, що НЕ є пунктуацією)
            String punctStr = part.replaceAll("[^\\p{Punct}]", "");
            if (!punctStr.isEmpty()) {
                // Знаків може бути кілька (наприклад "..."), тому проходимо циклом
                for (int j = 0; j < punctStr.length(); j++) {
                    Punctuation punct = new Punctuation(punctStr.charAt(j));
                    punctList.add(punct);
                    elementList.add(punct); // Додаємо у загальну чергу
                }
            }

            // 3. Додаємо пробіл після кожної частини (крім останньої)
            if (i < parts.length - 1) {
                elementList.add(" ");
            }
        }

        // Перетворюємо списки назад у звичайні масиви, як того вимагає структура
        this.words = wordList.toArray(new Word[0]);
        this.punctuations = punctList.toArray(new Punctuation[0]);
        this.elements = elementList.toArray();
    }

    public Word[] getWords() {
        return words;
    }

    public Punctuation[] getPunctuations() {
        return punctuations;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        // Щоб зібрати речення, просто проходимо по збереженому порядку
        // і викликаємо toString() для кожного елемента (Word або Punctuation)
        for (Object element : elements) {
            result.append(element.toString());
        }

        return result.toString();
    }
}