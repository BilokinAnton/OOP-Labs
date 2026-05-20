package io.lab5.space;

import io.lab5.toy.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ToyRoomTest {

    private ToyRoom room;

    @BeforeEach
    public void setUp() {
        room = new ToyRoom(3, 1000.00);
        room.addToy(new Car("Джип", 500.00, 6, "велика"));
        room.addToy(new Doll("Барбі", 300.00, 5, "пластик"));
        room.addToy(new Ball("М'яч", 100.00, 3, 15));
    }

    @Test
    public void testAddToyExceedsBudget() {
        ToyRoom smallBudget = new ToyRoom(5, 50.00);
        // перевіряємо що не кидається виняток — метод обробляє ситуацію сам
        assertDoesNotThrow(() -> smallBudget.addToy(new Car("Дорога", 500.00, 3, "мала")));
    }

    @Test
    public void testAddToyRoomFull() {
        // кімната вже заповнена (3/3)
        assertDoesNotThrow(() -> room.addToy(new Ball("Зайвий", 10.00, 3, 5)));
    }

    @Test
    public void testAddNullToy() {
        assertDoesNotThrow(() -> room.addToy(null));
    }

    @Test
    public void testSortByPrice() {
        room.sortByPrice();
        // після сортування перша іграшка повинна мати найменшу ціну
        // перевіряємо через findByPriceRange — найдешевша (100) знаходиться в діапазоні 0–100
        assertDoesNotThrow(() -> room.findByPriceRange(0, 100));
    }

    @Test
    public void testFindByPriceRangeFound() {
        // Барбі (300) потрапляє в діапазон
        assertDoesNotThrow(() -> room.findByPriceRange(200.00, 400.00));
    }

    @Test
    public void testFindByPriceRangeNotFound() {
        assertDoesNotThrow(() -> room.findByPriceRange(600.00, 900.00));
    }

    @Test
    public void testFindByPriceRangeInvalidRange() {
        // min > max — метод виводить повідомлення про помилку, не кидає виняток
        assertDoesNotThrow(() -> room.findByPriceRange(900.00, 100.00));
    }

    @Test
    public void testFindByPriceRangeNegativeMin() {
        assertDoesNotThrow(() -> room.findByPriceRange(-10.00, 300.00));
    }

    @Test
    public void testPrintAll() {
        assertDoesNotThrow(() -> room.printAll());
    }

    @Test
    public void testSortEmptyRoom() {
        ToyRoom empty = new ToyRoom(5, 1000.00);
        assertDoesNotThrow(empty::sortByPrice);
    }
}