package io.lab6.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class DLinkedHashSetTest {

    private DLinkedHashSet<String> set;

    @BeforeEach
    void setUp() {
        set = new DLinkedHashSet<>();
    }

    @Test
    void testEmptyConstructor() {
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }

    @Test
    void testSingleElementConstructor() {
        DLinkedHashSet<Integer> singleSet = new DLinkedHashSet<>(42);
        assertFalse(singleSet.isEmpty());
        assertEquals(1, singleSet.size());
        assertTrue(singleSet.contains(42));
    }

    @Test
    void testCollectionConstructor() {
        List<String> listWithDuplicates = Arrays.asList("A", "B", "A", "C");
        DLinkedHashSet<String> collectionSet = new DLinkedHashSet<>(listWithDuplicates);

        assertEquals(3, collectionSet.size(), "Дублікати повинні бути проігноровані");
        assertTrue(collectionSet.containsAll(Arrays.asList("A", "B", "C")));
    }

    @Test
    void testAddAndContains() {
        assertTrue(set.add("Apple"));
        assertTrue(set.add("Banana"));
        assertFalse(set.add("Apple"), "Додавання дублікату має повертати false");

        assertEquals(2, set.size());
        assertTrue(set.contains("Apple"));
        assertTrue(set.contains("Banana"));
        assertFalse(set.contains("Orange"));
    }

    @Test
    void testAddAndContainsNull() {
        assertTrue(set.add(null));
        assertFalse(set.add(null), "Дублікат null не повинен додаватися");

        assertTrue(set.contains(null));
        assertEquals(1, set.size());
    }

    @Test
    void testRemove() {
        set.add("A");
        set.add("B");
        set.add("C");

        assertTrue(set.remove("B"));
        assertEquals(2, set.size());
        assertFalse(set.contains("B"));

        // Видалення неіснуючого
        assertFalse(set.remove("Z"));

        assertTrue(set.remove("A"));
        assertTrue(set.remove("C"));

        assertTrue(set.isEmpty());
    }

    @Test
    void testClear() {
        set.add("A");
        set.add("B");
        set.clear();

        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
        assertFalse(set.contains("A"));
    }

    @Test
    void testIterator() {
        set.add("First");
        set.add("Second");
        set.add("Third");

        Iterator<String> iterator = set.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("First", iterator.next()); // Перевіряємо збереження порядку вставки
        assertEquals("Second", iterator.next());
        assertEquals("Third", iterator.next());
        assertFalse(iterator.hasNext());

        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testToArrayObject() {
        set.add("One");
        set.add("Two");

        Object[] array = set.toArray();
        assertEquals(2, array.length);
        assertEquals("One", array[0]);
        assertEquals("Two", array[1]);
    }

    @Test
    void testToArrayGeneric() {
        set.add("X");
        set.add("Y");

        // Масив правильного розміру
        String[] exactArray = new String[2];
        String[] res1 = set.toArray(exactArray);
        assertSame(exactArray, res1);
        assertEquals("X", res1[0]);

        // Замалий масив
        String[] smallArray = new String[0];
        String[] res2 = set.toArray(smallArray);
        assertNotSame(smallArray, res2);
        assertEquals(2, res2.length);
        assertEquals("Y", res2[1]);

        // Завеликий масив
        String[] largeArray = new String[5];
        largeArray[0] = "Keep";
        largeArray[1] = "Keep";
        largeArray[2] = "Keep";
        String[] res3 = set.toArray(largeArray);
        assertSame(largeArray, res3);
        assertNull(res3[2], "Наступний елемент після кінця колекції має бути null");
    }

    @Test
    void testAddAll() {
        set.add("1");
        List<String> toAdd = Arrays.asList("2", "3", "1");

        assertTrue(set.addAll(toAdd));
        assertEquals(3, set.size());
        assertFalse(set.addAll(toAdd), "Якщо нічого не додалося, має повертати false");
    }

    @Test
    void testRemoveAll() {
        set.addAll(Arrays.asList("A", "B", "C", "D"));
        List<String> toRemove = Arrays.asList("B", "D", "Z");

        assertTrue(set.removeAll(toRemove));
        assertEquals(2, set.size());
        assertTrue(set.contains("A"));
        assertTrue(set.contains("C"));
        assertFalse(set.contains("D"));
    }

    @Test
    void testRetainAll() {
        set.addAll(Arrays.asList("1", "2", "3", "4"));
        List<String> toRetain = Arrays.asList("2", "4", "6");

        assertTrue(set.retainAll(toRetain));
        assertEquals(2, set.size());
        assertTrue(set.contains("2"));
        assertTrue(set.contains("4"));
        assertFalse(set.contains("1"));
    }
}