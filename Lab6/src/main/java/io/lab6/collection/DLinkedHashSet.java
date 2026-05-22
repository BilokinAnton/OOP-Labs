package io.lab6.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

@SuppressWarnings("NullableProblems")
public class DLinkedHashSet<E> implements Set<E> {
    private Node head;
    private Node tail;
    private int size;


    // Конструктори
    public DLinkedHashSet() {
        // Поля ініціалізуються значеннями за замовчуванням (null, 0)
    }

    public DLinkedHashSet(E element) {
        add(element);
    }

    public DLinkedHashSet(Collection<? extends E> collection) {
        addAll(collection);
    }

    // Додати елемент в кінець
    @Override
    public boolean add(E element) {
        if (contains(element)) {
            return false;
        }

        Node newNode = new Node(element);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
        return true;
    }

    // Перевірка чи включає елемент
    @Override
    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if ((o == null && current.data == null) ||
                    (o != null && o.equals(current.data))) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Отримати ітератор
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = current.data;
                current = current.next;
                return value;
            }
        };
    }

    // Перетворити в масив
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node current = head; current != null; current = current.next) {
            result[i++] = current.data;
        }
        return result;
    }

    // Перетворити в масив типу
    @Override
    public <T> T[] toArray(T[] a) {
        // Якщо переданий масив замалий, створюємо новий такого ж типу
        if (a.length < size) {
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }

        int i = 0;
        Object[] result = a;
        for (Node current = head; current != null; current = current.next) {
            result[i++] = current.data;
        }

        // За контрактом колекцій, якщо масив більший, наступний елемент ставиться null
        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    // Видалення елемента
    @Override
    public boolean remove(Object o) {
        Node current = head;
        while (current != null) {
            if ((o == null && current.data == null) ||
                    (o != null && o.equals(current.data))) {

                // якщо не перший
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                // якщо не останній
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Перевірка чи включає всі елементи переданої множини
    @Override
    public boolean containsAll(Collection<?> collection) {
        // Перевіряємо, чи кожен елемент з переданої колекції є у нашому Set
        for (Object obj : collection) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    // Додати всі елементи вхідної множини
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean m = false;
        for (E obj : collection) {
            if (add(obj)) {
                m = true;
            }
        }
        return m;
    }

    // Перетин множин
    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean m = false;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            if (!collection.contains(current.data)) {
                remove(current.data);
                m = true;
            }
            current = next;
        }
        return m;
    }

    // Видалення всіх елементів, що є у переданій колекції
    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean m = false;
        for (Object obj : collection) {
            if (remove(obj)) {
                m = true;
            }
        }
        return m;
    }

    // Отримання кількості елементів
    @Override
    public int size() {
        return size;
    }

    // Перевірка на відсутність елементів
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Повне видалення всіх елементів
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // Метод перетворення в рядок
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;

        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    // Клас вузла
    private class Node {
        E data;
        Node prev;
        Node next;

        Node(E data) {
            this.data = data;
        }
    }
}